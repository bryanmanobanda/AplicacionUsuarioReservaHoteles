package Conexion;

import CRUD.Administrador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLAdministrador {
    PreparedStatement ps;
    ResultSet rs;

    public boolean iniciarSesion(Administrador administrador) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        ps = connection.prepareStatement("select ID_ADMIN, CONTINENTE, ID_HOTEL, NOMBRE, CORREO, CONTRASENIA, TELEFONO from ADMINISTRADOR where CORREO=?");
        ps.setString(1, administrador.getCorreo());
        rs = ps.executeQuery();

        if (rs.next()) {
            if (administrador.getContrasenia().equals(rs.getString("CONTRASENIA"))) {
                administrador.setIdAdmin(rs.getInt("ID_ADMIN"));
                administrador.setContinente(rs.getString("CONTINENTE"));
                administrador.setIdAdmin(rs.getInt("ID_HOTEL"));
                administrador.setNombre(rs.getString("NOMBRE"));
                administrador.setTelefono(rs.getString("TELEFONO"));
                return true;
            }
            System.out.println("Contraseña incorrecta");
            return false;
        }
        System.out.println("Administrador no encontrado");
        return false;
    }

    public void modificarAdmin(Administrador administrador) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        ps = connection.prepareStatement("update ADMINISTRADOR set NOMBRE=?, CORREO=?, CONTRASENIA=?, TELEFONO=? where ID_ADMIN=?");
        ps.setString(1, administrador.getNombre());
        ps.setString(2, administrador.getCorreo());
        ps.setString(3, administrador.getContrasenia());
        ps.setString(4, administrador.getTelefono());
        ps.setInt(5, administrador.getIdAdmin());
        ps.executeUpdate();
    }
}
