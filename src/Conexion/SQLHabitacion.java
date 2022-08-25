package Conexion;

import CRUD.Habitacion;
import CRUD.Hotel;
import CRUD.Reserva;
import CRUD.TipoHabitacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLHabitacion {
    PreparedStatement ps;
    ResultSet rs;
    SQLTipoHab tipoHab;

    public void insertarHabitacion(Habitacion habitacion) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        ps = connection.prepareStatement("insert into HABITACION values(?, ?, ?, ?, ?, ?, ?, ?)"); //Vista Habitacion o tablas por separado
        ps.setInt(1, habitacion.getIdHotel());
        ps.setString(2, habitacion.getContinente());
        ps.setInt(3, habitacion.getNumeroHabitacion());
        ps.setString(4, habitacion.getTipoHabitacion().getNombreTipo());
        ps.setInt(5, habitacion.isDisponibilidad()? 1:0);
        ps.setString(6, habitacion.getDescripcion());
        ps.setInt(7, habitacion.getNumCamas());
        ps.setDouble(8, habitacion.getPrecio());
        ps.executeUpdate();
    }

    public void modificarHabitacion(Habitacion habitacion) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();

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
    }

    public void eliminarHabitacion(Habitacion habitacion) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();

        ps = connection.prepareStatement("delete from HABITACION where ID_HOTEL=? and CONTINENTE=? and NUMEROHAB=?");
        ps.setInt(1, habitacion.getIdHotel());
        ps.setString(2, habitacion.getContinente());
        ps.setInt(3, habitacion.getNumeroHabitacion());
        ps.executeUpdate();
    }

    public void buscarHabitacion(Habitacion habitacion) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        
        ps = connection.prepareStatement("select * from HABITACION where ID_HOTEL=? and CONTINENTE=? and NUMEROHAB=?");
        ps.setInt(1, habitacion.getIdHotel());
        ps.setString(2, habitacion.getContinente());
        ps.setInt(3, habitacion.getNumeroHabitacion());

        rs = ps.executeQuery();
        while (rs.next()){
            habitacion.setNumeroHabitacion(rs.getInt("NUMEROHAB"));
            TipoHabitacion tipoHabitacion = new TipoHabitacion(rs.getString("NOMBRE_TIPO"));
            tipoHab.buscarTipo(tipoHabitacion);
            habitacion.setTipoHabitacion(tipoHabitacion);
            habitacion.setDisponibilidad(rs.getInt("DISPONIBILIDAD") == 1);
            habitacion.setDescripcion(rs.getString("DESCRIPCION"));
            habitacion.setNumCamas(rs.getInt("NUMCAMAS"));
            habitacion.setPrecio(rs.getDouble("PRECIO"));
        }
    }

    public ArrayList<Habitacion> busquedaPorHotel(Hotel hotel) throws ClassNotFoundException, SQLException {
        ArrayList<Habitacion> listaHabitacion = new ArrayList<>();
        tipoHab = new SQLTipoHab();
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        ps = connection.prepareStatement("SELECT * FROM HABITACION WHERE ID_HOTEL = ? and CONTINENTE=? and DISPONIBILIDAD = 1");
        ps.setInt(1, hotel.getIdHotel());
        ps.setString(2, hotel.getContinente());
        rs = ps.executeQuery();
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

    public ArrayList<Habitacion> busquedaPorReserva(Reserva reserva) throws SQLException, ClassNotFoundException {
        ArrayList<Habitacion> listaHabitacion = new ArrayList<>();
        tipoHab = new SQLTipoHab();
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        ps = connection.prepareStatement("Select h.* from HABITACION h, HABITACION_RESERVA hr where h.CONTINENTE = hr.CONTINENTE and h.ID_HOTEL = hr.ID_HOTEL and h.NUMEROHAB = hr.NUMEROHAB and hr.ID_RESERVA = ?"); //VISTA general
        ps.setInt(1, reserva.getIdReserva());
        rs = ps.executeQuery();
        while (rs.next()){
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

    public ArrayList<Habitacion> busquedaHabitaciones() throws SQLException, ClassNotFoundException {
        ArrayList<Habitacion> listaHabitacion = new ArrayList<>();
        tipoHab = new SQLTipoHab();
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        ps = connection.prepareStatement("Select * from HABITACION"); //VISTA general
        rs = ps.executeQuery();
        while (rs.next()){
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
