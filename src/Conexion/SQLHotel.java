package Conexion;

import CRUD.Hotel;

import java.sql.SQLException;
import java.util.ArrayList;

public class SQLHotel extends SQL {

    public ArrayList<Hotel> listarHoteles() throws SQLException {
        ArrayList<Hotel> listahotel = new ArrayList<>();
        connection = getConnection();
        ps = connection.prepareStatement("SELECT * FROM HOTEL");
        rs = ps.executeQuery();
        connection.close();
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

    public ArrayList<String> listarPaises() throws SQLException {
        ArrayList<String> paises = new ArrayList<>();
        connection = getConnection();
        ps = connection.prepareStatement("SELECT DISTINCT(PAIS) FROM HOTEL");
        rs = ps.executeQuery();
        connection.close();
        while (rs.next()) {
            paises.add(rs.getString("PAIS"));
        }
        return paises;
    }
}