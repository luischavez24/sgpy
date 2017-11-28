package edu.unmsm.sistemas.sgpy.documents.repository.drive;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.*;
import com.google.api.services.drive.Drive;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriveConnection {

    private static DriveConnection INSTANCE = new DriveConnection();

    private DriveConnection() {
    }

    public static DriveConnection getInstance() {
        return INSTANCE;
    }

    /**
     * Application name.
     */
    private static final String APPLICATION_NAME = "SGPY";

    private static final String CARPETA_PROYECTO = "1Q8v9FMhze9KaCDGuJqJpliTHq6_DVG_f";

    /**
     * Directory to store user credentials for this application.
     */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
            System.getProperty("user.home"), ".credentials/drive-java-quickstart");

    /**
     * Global instance of the {@link FileDataStoreFactory}.
     */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY
            = JacksonFactory.getDefaultInstance();

    /**
     * Global instance of the HTTP transport.
     */
    private static HttpTransport HTTP_TRANSPORT;

    /**
     * Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials at
     * ~/.credentials/drive-java-quickstart
     */
    private static final List<String> SCOPES = Arrays.asList(DriveScopes.DRIVE);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     *
     * @return an authorized Credential object.
     * @throws IOException
     */
    private Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in
                = DriveConnection.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets
                = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow
                = new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();

        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Drive client service.
     *
     * @return an authorized Drive client service
     * @throws IOException
     */
    private Drive getDriveService() throws IOException {
        Credential credential = authorize();
        return new Drive.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public String subirArchivo(java.io.File filePath, String type) {

        String fileId = null;

        try {

            Drive service = getDriveService();

            File fileMetadata = new File();

            fileMetadata.setName(filePath.getName());

            fileMetadata.setParents(Collections.singletonList(CARPETA_PROYECTO));

            FileContent mediaContent = new FileContent(type, filePath);

            Drive.Files.Create createFile = service.files().create(fileMetadata, mediaContent);

            setProgressListener(createFile.getMediaHttpUploader());

            File file = createFile.setFields("id").execute();

            fileId = file.getId();

        } catch (IOException e) {
            System.out.println(e);
        }

        return fileId;
    }

    public String actualizarArchivo(java.io.File filePath, String type, String idArchivo) {

        String fileId = null;

        try {

            Drive service = getDriveService();

            File fileMetadata = new File();

            fileMetadata.setName(filePath.getName());

            FileContent mediaContent = new FileContent(type, filePath);

            Drive.Files.Update updateFile = service.files().update(idArchivo, fileMetadata, mediaContent);

            setProgressListener(updateFile.getMediaHttpUploader());

            File file = updateFile.execute();

            fileId = file.getId();

        } catch (IOException e) {
            System.out.println(e);
        }

        return fileId;
    }

    public int descargarArchivo(java.io.File archivoSalida, String idDocumento) {

        try {
            
            Drive service = getDriveService();
            File fileMetadata = service.files().get(idDocumento).execute();
            System.out.println(archivoSalida.getAbsoluteFile());
            System.out.println(archivoSalida.getAbsolutePath());
            try (OutputStream outputStream = new FileOutputStream(archivoSalida.getAbsolutePath() + "\\" + fileMetadata.getName())) {
                
                getDriveService().files().get(fileMetadata.getId())
                        .executeMediaAndDownloadTo(outputStream);
                return 1;
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        return 0;
    }

    public void goToURL(String URL) {
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI uri = new java.net.URI(URL);
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    private void setProgressListener(MediaHttpUploader uploader) {

        uploader.setDirectUploadEnabled(false);

        uploader.setChunkSize(MediaHttpUploader.MINIMUM_CHUNK_SIZE);

        uploader.setProgressListener(new CargaListener());
    }
}
