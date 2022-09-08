package Conexion;

import CRUD.Habitacion;
import CRUD.Hotel;
import CRUD.Reserva;
import CRUD.TipoHabitacion;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLHabitacion extends SQL{
    SQLTipoHab tipoHab;

    public void modificarHabitacion(Habitacion habitacion) throws SQLException, ClassNotFoundException {
        connection = getConnection();

        ps = connection.prepareStatement("update HABITACION set NOMBRE_TIPO=?, DISPONIBILIDAD=?, DESCRIPCION=?, NUMCAMAS=?, PRECIO=? where ID_HOTEL=? and CONTINENTE=? and NUMEROHAB=?");
        ps.setString(1, habitacion.getTipoHabitacion().getNombreTipo());
        ps.setInt(2, habitacion.isDisponibilidad()? 1: 0);
        ps.setString(3, habitacion.getDescripcion());
        ps.setInt(4, habitacion.getNumCamas());
        ps.setDouble(5, habitacion.getPrecio());
        ps.setInt(6, habitacion.getIdHotel());
        ps.setString(7, habitacion.getContinente());
        ps.setInt(8, habitacion.getNumeroHabitacion());

        ps.executeUpdate();
        connection.close();
    }

    public ArrayList<Habitacion> busquedaPorHotel(Hotel hotel) throws ClassNotFoundException, SQLException {
        ArrayList<Habitacion> listaHabitacion = new ArrayList<>();
        tipoHab = new SQLTipoHab();
        connection = getConnection();
        ps = connection.prepareStatement("SELECT * FROM HABITACION WHERE ID_HOTEL = ? and CONTINENTE=? and DISPONIBILIDAD = 1");
        ps.setInt(1, hotel.getIdHotel());
        ps.setString(2, hotel.getContinente());
        return getHabitaciones(listaHabitacion);
    }

    public ArrayList<Habitacion> busquedaPorReserva(Reserva reserva) throws SQLException {
        ArrayList<Habitacion> listaHabitacion = new ArrayList<>();
        tipoHab = new SQLTipoHab();
        connection = getConnection();
        ps = connection.prepareStatement("Select h.* from HABITACION h, HABITACION_RESERVA hr where h.CONTINENTE = hr.CONTINENTE and h.ID_HOTEL = hr.ID_HOTEL and h.NUMEROHAB = hr.NUMEROHAB and hr.ID_RESERVA = ?"); //VISTA general
        ps.setInt(1, reserva.getIdReserva());
        return getHabitaciones(listaHabitacion);
    }

    private ArrayList<Habitacion> getHabitaciones(ArrayList<Habitacion> listaHabitacion) throws SQLException {
        rs = ps.executeQuery();
        connection.close();
        while (rs.next()) {
            Habitacion habitacion = new Habitacion(rs.getInt("ID_HOTEL"));
            habitacion.setContinente(rs.getString("CONTINENTE"));
            habitacion.setNumeroHabitacion(rs.getInt("NUMEROHAB"));
            TipoHabitacion tipoHabitacion = new TipoHabitacion(rs.getString("NOMBRE_TIPO"));
            tipoHab.buscarTipo(tipoHabitacion);
            habitacion.setTipoHabitacion(tipoHabitacion);
            habitacion.setDisponibilidad(rs.getInt("DISPONIBILIDAD") == 1);
            habitacion.setDescripcion(rs.getString("DESCRIPCION"));
            habitacion.setNumCamas(rs.getInt("NUMCAMAS"));
            habitacion.setPrecio(rs.getDouble("PRECIO"));
            listaHabitacion.add(habitacion);
        }
        return listaHabitacion;
    }
}
