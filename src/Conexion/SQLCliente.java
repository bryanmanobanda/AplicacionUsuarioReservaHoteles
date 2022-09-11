package Conexion;

import CRUD.Cliente;
import java.sql.SQLException;

public  class SQLCliente extends SQL{

    public void registrarUsuario(Cliente cliente) throws SQLException{
        connection = getConnection();
        ps = connection.prepareStatement("insert into CLIENTE (NOMBRE, CORREO, CONTRASENIA, PAIS, FECHA_NAC) values(?,?,?,?,?)");
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getCorreo());
        ps.setString(3, cliente.getContrasenia());
        ps.setString(4, cliente.getPais());
        ps.setDate(5, cliente.getFechaNacimiento());
        ps.executeUpdate();
        connection.close();
    }

    public int verificarCorreo(String correo) throws SQLException{
        connection = getConnection();
        ps = connection.prepareStatement("select count(ID_USUARIO) from CLIENTE where CORREO=?");
        ps.setString(1, correo);
        rs = ps.executeQuery();
        connection.close();
        return rs.next()? rs.getInt(1) : 1;
    }

    public boolean iniciarSesion(Cliente cliente) throws SQLException, ClassNotFoundException {
        connection = getConnection();
        ps = connection.prepareStatement("select ID_USUARIO, NOMBRE, CORREO, CONTRASENIA, PAIS, FECHA_NAC from CLIENTE where CORREO=?");
        ps.setString(1, cliente.getCorreo());
        rs = ps.executeQuery();
        connection.close();

        if (rs.next()) {
            if (cliente.validarContrasenia(rs.getString("CONTRASENIA"))) {
                cliente.setIdUsuario(rs.getInt("ID_USUARIO"));
                cliente.setNombre(rs.getString("NOMBRE"));
                cliente.setPais(rs.getString("PAIS"));
                cliente.setFechaNacimiento(rs.getDate("FECHA_NAC"));
                return true;
            }
        }
        return false;
    }

    public void modificarContrasenia(Cliente cliente) throws SQLException, ClassNotFoundException {
        connection = getConnection();
        ps = connection.prepareStatement("update CLIENTE set contrasenia=? where ID_USUARIO=?");
        ps.setString(1, cliente.getContrasenia());
        ps.setInt(2, cliente.getIdUsuario());
        ps.executeUpdate();
        connection.close();
    }
}
