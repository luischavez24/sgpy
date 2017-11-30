/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.documents.repository.drive;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lucho
 */
public abstract class DriveConstants {

    public static final Map<String, String> DRIVE_TYPES;

    static {
        DRIVE_TYPES = new HashMap<>();
        DRIVE_TYPES.put("WORD", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        DRIVE_TYPES.put("EXCEL", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        DRIVE_TYPES.put("PDF", "application/pdf");
    }

    public static final String APPLICATION_NAME = "SGPY";

    public static final String CARPETA_PROYECTO = "1lvGry_KT4q36_4Z_fIdny9jy64OeGmTV";
}
