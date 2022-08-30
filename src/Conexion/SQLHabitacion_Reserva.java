package Conexion;

import CRUD.Habitacion;
import CRUD.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLHabitacion_Reserva {
    PreparedStatement ps;
   
    public void insertarHabitacionReserva(Habitacion habitacion, Reserva reserva)throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        ps = connection.prepareStatement("insert into HABITACION_RESERVA values(?,?,?,?)");
        ps.setInt(1, reserva.getIdReserva());
        ps.setInt(2, habitacion.getIdHotel());
        ps.setString(3, habitacion.getContinente());
        ps.setInt(4, habitacion.getNumeroHabitacion());
        ps.executeUpdate();
    }

    //public void eliminarHabitacionReserva(Habitacion habitacion, Reserva reserva)throws SQLException, ClassNotFoundException {
    public void eliminarHabitacionReserva(Reserva reserva)throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();

        //ps = connection.prepareStatement("delete from HABITACION_RESERVA where ID_RESERVA=? and ID_HOTEL=? and CONTINENTE=? and NUMEROHAB=?");
        ps = connection.prepareStatement("delete from HABITACION_RESERVA where ID_RESERVA=? and CONTINENTE=?");
        ps.setInt(1, reserva.getIdReserva());
        ps.setString(2, reserva.getContinente());
        ps.executeUpdate();
    }
}
