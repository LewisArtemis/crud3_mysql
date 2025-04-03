/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud3_mysql;

import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author SENA
 */
public class CAlumnos {
    int codigo;
    String nombreAlumnos;
    String apellidoAlumnos;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreAlumnos() {
        return nombreAlumnos;
    }

    public void setNombreAlumnos(String nombreAlumnos) {
        this.nombreAlumnos = nombreAlumnos;
    }

    public String getApellidoAlumnos() {
        return apellidoAlumnos;
    }

    public void setApellidoAlumnos(String apellidoAlumnos) {
        this.apellidoAlumnos = apellidoAlumnos;
    }
    
    public void InsertarAlumno(JTextField paramNombres, JTextField paramApellidos) {
        
        setNombreAlumnos(paramNombres.getText());
        setApellidoAlumnos(paramApellidos.getText());
        
        CConexion obetoConexion = new CConexion();
        
        String consulta = "insert into Alumnos (nombre, apellido) values (?,?);";
        
        try {
            CallableStatement cs = obetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getNombreAlumnos());
            cs.setString(2, getApellidoAlumnos());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se inserto correctamente el alumno");
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "No se inserto correctamente el alumno, error: " + e.toString());
        }
    }
    
}
