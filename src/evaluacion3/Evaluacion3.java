/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion3;

import sql.conexion;
import vista.Consultas;

/**
 *
 * @author Duoc UC
 */
public class Evaluacion3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        conexion.getConexion();
        
        new Controlador(new Consultas() ).iniciar();
    
    }
    
}
