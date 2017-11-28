/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.documents.repository.drive;

import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener;
import edu.unmsm.sistemas.sgpy.documents.model.Progreso;
import edu.unmsm.sistemas.sgpy.documents.repository.DAOConnection;
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author lucho
 */
public class CargaListener implements MediaHttpUploaderProgressListener {
    
    private final static Log LOG = LogFactory.getLog(CargaListener.class);
    
    @Override
    public void progressChanged(MediaHttpUploader uploader) throws IOException {
       switch (uploader.getUploadState()) {
        case INITIATION_STARTED:
          LOG.info("Initiation Started");
          break;
        case INITIATION_COMPLETE:
           LOG.info("Initiation Completed");
          break;
        case MEDIA_IN_PROGRESS:
            Progreso.getInstance().setProgreso(uploader.getProgress());
          break;
        case MEDIA_COMPLETE:
           LOG.info("Upload Completed!");
          break;
      }
    }
    
}
