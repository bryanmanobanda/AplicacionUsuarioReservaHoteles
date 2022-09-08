package Conexion;

import CRUD.Hotel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLHotel extends SQL{
    ResultSet rs1;

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
    //TODO: REFACTOR CON PAGINAPRINCIPAL
    public String[] busquedaPaises() throws SQLException {
        int i = 0;
        String[] paises;
        connection = getConnection();
        ps = connection.prepareStatement("SELECT DISTINCT(PAIS) FROM HOTEL");
        rs = ps.executeQuery();

        ps = connection.prepareStatement("SELECT COUNT(DISTINCT(PAIS)) AS N FROM HOTEL");
        rs1 = ps.executeQuery();
        connection.close();
        rs1.next();
        paises = new String[rs1.getInt("N") + 1];

        paises[0] = "Seleccione un pais";
        i++;
        while (rs.next()) {
            paises[i] = rs.getString("PAIS");
            i++;
        }
        return paises;
    }
}