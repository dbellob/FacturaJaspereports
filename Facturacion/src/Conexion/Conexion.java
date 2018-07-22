/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Conexion {

    Connection conexion = null;

    public Connection Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/facturacion";
            String usuario = "root";
            String password = "root";
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión establecida....");
        } catch (ClassNotFoundException | SQLException e) {
            try {
                System.out.println("Error al conectar " + e);
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexion;
    }

    public Connection Desconectar() {
        try {
            conexion.close();
            System.out.println("Cerrando conexión...");

        } catch (SQLException ex) {

            System.out.println(ex);

        }
        conexion = null;
        return conexion;
    }

}
