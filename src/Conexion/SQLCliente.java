package Conexion;

import CRUD.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public  class SQLCliente {
    PreparedStatement ps;
    ResultSet rs;

    public void registrarUsuario(Cliente cliente) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        ps = connection.prepareStatement("insert into CLIENTE (NOMBRE, CORREO, CONTRASENIA, PAIS, FECHA_NAC) values(?,?,?,?,?)");
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getCorreo());
        ps.setString(3, cliente.getContrasenia());
        ps.setString(4, cliente.getPais());
        ps.setDate(5, cliente.getFechaNacimiento());
        ps.executeUpdate();
    }

    public int verificarUsuario(String correo) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        ps = connection.prepareStatement("select count(ID_USUARIO) from CLIENTE where CORREO=?");
        ps.setString(1, correo);
        rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        }
        return 1;
    }

    public boolean iniciarSesion(Cliente cliente) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        ps = connection.prepareStatement("select ID_USUARIO, NOMBRE, CORREO, CONTRASENIA, PAIS, FECHA_NAC from CLIENTE where CORREO=?");
        ps.setString(1, cliente.getCorreo());
        rs = ps.executeQuery();

        if (rs.next()) {
            if (cliente.getContrasenia().equals(rs.getString("CONTRASENIA"))) {
                cliente.setIdUsuario(rs.getInt("ID_USUARIO"));
                cliente.setNombre(rs.getString("NOMBRE"));
                cliente.setPais(rs.getString("PAIS"));
                cliente.setFechaNacimiento(rs.getDate("FECHA_NAC"));
                return true;
            }
            System.out.println("Contraseña incorrecta");
            return false;
        }
        System.out.println("Usuario no encontrado");
        return false;
    }

    public void modificarUsuario(Cliente cliente) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        ps = connection.prepareStatement("update CLIENTE set NOMBRE=?, CORREO=?, PAIS=?, FECHA_NAC=? where ID_USUARIO=?");
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getCorreo());
        ps.setString(3, cliente.getPais());
        ps.setDate(4, cliente.getFechaNacimiento());
        ps.setInt(5, cliente.getIdUsuario());
        ps.executeUpdate();
    }

    public void eliminarUsuario(Cliente cliente) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        ps = connection.prepareStatement("delete from CLIENTE where ID_USUARIO=?");
        ps.setInt(1, cliente.getIdUsuario());
        ps.executeUpdate();
    }

    public ArrayList<Cliente> busquedaUsuarios() throws SQLException, ClassNotFoundException {
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();

        ps = connection.prepareStatement("select * from CLIENTE");
        rs = ps.executeQuery();
        while (rs.next()){
            Cliente cliente = new Cliente();
            cliente.setIdUsuario(rs.getInt("ID_USUARIO"));
            cliente.setNombre(rs.getString("NOMBRE"));
            cliente.setCorreo(rs.getString("CORREO"));
            cliente.setContrasenia(rs.getString("CONTRASENIA"));
            cliente.setPais(rs.getString("PAIS"));
            cliente.setFechaNacimiento(rs.getDate("FECHA_NAC"));
            listaCliente.add(cliente);
        }
        return listaCliente;
    }

    public void buscarUsuario(Cliente cliente) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();

        ps = connection.prepareStatement("select * from CLIENTE where ID_USUARIO=?");
        ps.setInt(1, cliente.getIdUsuario());
        rs = ps.executeQuery();

        while (rs.next()){
            cliente.setNombre(rs.getString("NOMBRE"));
            cliente.setCorreo(rs.getString("CORREO"));
            cliente.setContrasenia(rs.getString("CONTRASENIA"));
            cliente.setPais(rs.getString("PAIS"));
            cliente.setFechaNacimiento(rs.getDate("FECHA_NAC"));
        }
    }
}
