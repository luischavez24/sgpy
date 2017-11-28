/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Persona.crudmvc;

import edu.unmsm.sistemas.sgpy.Persona.menuPrincipales.OpcionesPrincipal;

/**
 *
 * @author CARLOS
 */
public class principal {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".endsWith(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        OpcionesPrincipal pri=new OpcionesPrincipal();
        pri.setLocationRelativeTo(null);
        pri.setVisible(true);    
    }
}
