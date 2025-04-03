/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud3_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author SENA
 */
public class CConexion {
    Connection conectar = null;
    
    String usuario = "root";
    String contrasenia = "12345";
    String bd = "dbescuela";
    String ip = "localhost";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexion() {
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
            
            JOptionPane.showConfirmDialog(null, "La conexion se realizo con exito");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos" + e.toString());
        }
        return conectar;
    }
}
