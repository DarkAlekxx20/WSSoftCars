package com.softcars.mx.core;

import com.softcars.mx.db.DBConnector;
import com.softcars.mx.model.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author DarkAlekxx20
 * @Desc: Clase controladora de procesos para login, creacion de usuarios y
 * modificacion de informacion del usuario
 * @Date: 03/09/2024
 */
public class UsuarioController {

    public Usuario login(String username, String password) throws Exception {
        DBConnector dbConnector = new DBConnector();
        Connection conn = dbConnector.open();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Usuario u = null;
        try {
            String sql = "SELECT * FROM softcars.usuarios u WHERE u.username = ? AND u.password = ?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                u = (fill(rs));
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
            rs.close();
            pstmt.close();
            dbConnector.close();
        }
        return u;
    }

    public boolean sigin(Usuario us) throws Exception {
        boolean r = false;
        DBConnector dbConnector = new DBConnector();
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = dbConnector.open();
            conn.setAutoCommit(false);
            String sql = "call softcars.sp_insertUser(?,?,?);";
            cstmt = conn.prepareCall(sql);
            cstmt.setString(1, us.getUsername());
            cstmt.setString(2, us.getPassword());
            cstmt.setInt(3, us.getEstatus());
            int rowsAffected = cstmt.executeUpdate();
            if (rowsAffected > 0) {
                conn.commit();
                r = true;
            } else {
                conn.rollback();
            }
        } catch (Exception ex) {
            if (conn != null) {
                conn.rollback();
            }
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (Exception e) {
                    Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            dbConnector.close();
        }
        return r;
    }

    public List<Usuario> getAll(String filtro) throws Exception {
        DBConnector dbConnector = new DBConnector();
        Connection conn = dbConnector.open();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM softcars.usuarios;";
            pstmt = conn.prepareCall(sql);
            while (rs.next()) {
                usuarios.add(fill(rs));
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rs.close();
            pstmt.close();
            dbConnector.close();
            conn.close();
        }
        return usuarios;
    }

    private Usuario fill(ResultSet rs) throws Exception {
        Usuario u = new Usuario();
        u.setIdUsuario(rs.getInt("idUsuario"));
        u.setUsername(rs.getString("username"));
        u.setPassword(rs.getString("password"));
        u.setEstatus(rs.getInt("estatus"));
        return u;
    }
}
