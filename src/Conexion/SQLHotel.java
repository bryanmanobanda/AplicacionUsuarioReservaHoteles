package Conexion;

import CRUD.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLHotel {
    PreparedStatement ps;
    ResultSet rs, rs1;

    public void insertarHotel(Hotel hotel) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();

        ps = connection.prepareStatement("insert into HOTEL values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
        ps.setInt(1, hotel.getIdHotel());
        ps.setString(2, hotel.getContinente());
        ps.setString(3, hotel.getNombre());
        ps.setString(4, hotel.getDescripcion());
        ps.setInt(5, hotel.getPrestigio());
        ps.setString(6, hotel.getCorreo());
        ps.setString(7, hotel.getTelefono());
        ps.setString(8, hotel.getPais());
        ps.setString(9, hotel.getCiudad());
        ps.executeUpdate();
    }

    public void actualizarHotel(Hotel hotel) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();

        ps = connection.prepareStatement("update HOTEL set  NOMBRE=?, DESCRIPCION=?, PRESTIGIO=?, CORREO=?, TELEFONO=?, PAIS=?, CIUDAD=? where ID_HOTEL=? and CONTINENTE=?");
        ps.setString(1, hotel.getNombre());
        ps.setString(2, hotel.getDescripcion());
        ps.setInt(3, hotel.getPrestigio());
        ps.setString(4, hotel.getCorreo());
        ps.setString(5, hotel.getTelefono());
        ps.setString(6, hotel.getPais());
        ps.setString(7, hotel.getCiudad());

        ps.setInt(8, hotel.getIdHotel());
        ps.setString(9, hotel.getContinente());

        ps.executeUpdate();
    }

    public void eliminarHotel(Hotel hotel) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();

        ps = connection.prepareStatement("delete from HOTEL where ID_HOTEL=? and CONTINENTE=?");
        ps.setInt(1, hotel.getIdHotel());
        ps.setString(2, hotel.getContinente());
    }

    public void buscarHotel(Hotel hotel) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();

        ps = connection.prepareStatement("select * from HOTEL where ID_HOTEL=? and CONTINENTE=?");
        ps.setInt(1, hotel.getIdHotel());
        ps.setString(2, hotel.getContinente());

        rs = ps.executeQuery();
        while (rs.next()) {
            hotel.setNombre(rs.getString("NOMBRE"));
            hotel.setDescripcion(rs.getString("DESCRIPCION"));
            hotel.setPrestigio(rs.getInt("PRESTIGIO"));
            hotel.setCorreo(rs.getString("CORREO"));
            hotel.setTelefono(rs.getString("TELEFONO"));
            hotel.setPais(rs.getString("PAIS"));
            hotel.setCiudad(rs.getString("CIUDAD"));
        }
    }

    public ArrayList<Hotel> busqueda() throws ClassNotFoundException, SQLException {
        ArrayList<Hotel> listahotel = new ArrayList<>();
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        ps = connection.prepareStatement("SELECT * FROM HOTEL");
        rs = ps.executeQuery();
        while (rs.next()) {
            Hotel hotel = new Hotel();
            hotel.setIdHotel(rs.getInt("ID_HOTEL"));
            hotel.setContinente(rs.getString("CONTINENTE"));
            hotel.setNombre(rs.getString("NOMBRE"));
            hotel.setDescripcion(rs.getString("DESCRIPCION"));
            hotel.setPrestigio(rs.getInt("PRESTIGIO"));
            hotel.setCorreo(rs.getString("CORREO"));
            hotel.setTelefono(rs.getString("TELEFONO"));
            hotel.setPais(rs.getString("PAIS"));
            hotel.setCiudad(rs.getString("CIUDAD"));
            listahotel.add(hotel);
        }
        return listahotel;
    }
    
    public String[] busquedaPaises() throws ClassNotFoundException, SQLException {
      int i = 0;  
      String[] paises;
      ConexionBaseDatos con = new ConexionBaseDatos();
      Connection connection = con.getConnection();
      ps = connection.prepareStatement("SELECT DISTINCT(PAIS) FROM HOTEL");
      rs = ps.executeQuery();
      
      ps = connection.prepareStatement("SELECT COUNT(DISTINCT(PAIS)) AS N FROM HOTEL");
      rs1 = ps.executeQuery();
      
      rs1.next();
      paises = new String[rs1.getInt("N")+1];
      
      paises[0] = "Seleccione un pais";
        i++;
      while (rs.next()) {
        paises[i] = rs.getString("PAIS");
        i++;
      }
      return paises;
    }
}