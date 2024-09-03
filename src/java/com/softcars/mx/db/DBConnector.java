package com.softcars.mx.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author DarkAlekxx20
 * @Desc: Clase para realizar la conexion a base de datos en la nube
 * @Date: 03/09/2024
 */
public class DBConnector {

    Connection conn;

    public Connection open() {
        String className = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/softcars?useSSL=false&"
                + "allowPublicKeyRetrieval=true&"
                + "useUnicode=true&characterEncoding=utf-8";
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception Controlada");
            }
        }
    }
}
