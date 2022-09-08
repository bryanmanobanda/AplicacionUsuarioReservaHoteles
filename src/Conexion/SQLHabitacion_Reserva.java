package Conexion;

import CRUD.Habitacion;
import CRUD.Reserva;
import java.sql.SQLException;

public class SQLHabitacion_Reserva extends SQL {

    public void insertarHabitacionReserva(Habitacion habitacion, Reserva reserva) throws SQLException, ClassNotFoundException {
        connection = getConnection();
        ps = connection.prepareStatement("insert into HABITACION_RESERVA values(?,?,?,?)");
        ps.setInt(1, reserva.getIdReserva());
        ps.setInt(2, habitacion.getIdHotel());
        ps.setString(3, habitacion.getContinente());
        ps.setInt(4, habitacion.getNumeroHabitacion());
        ps.executeUpdate();
        connection.close();
    }

    public void eliminarHabitacionReserva(Reserva reserva) throws SQLException, ClassNotFoundException {
        connection = getConnection();
        ps = connection.prepareStatement("delete from HABITACION_RESERVA where ID_RESERVA=? and CONTINENTE=?");
        ps.setInt(1, reserva.getIdReserva());
        ps.setString(2, reserva.getContinente());
        ps.executeUpdate();
        connection.close();
    }
}
