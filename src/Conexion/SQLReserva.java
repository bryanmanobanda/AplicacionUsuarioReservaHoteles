package Conexion;

import CRUD.Cliente;
import CRUD.Reserva;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLReserva extends SQL{

    public void insertarReserva(Reserva reserva) throws SQLException, ClassNotFoundException {
        connection = getConnection();

        ps = connection.prepareStatement("insert into RESERVA (CONTINENTE, ID_USUARIO, FECHA_INICIO, FECHA_FINAL, PRECIO) values(?,?,?,?,?) ");
        ps.setString(1, reserva.getContinente());
        ps.setInt(2, reserva.getIdUsuario());
        ps.setDate(3, reserva.getFechaInicio());
        ps.setDate(4, reserva.getFechaFin());
        ps.setDouble(5, reserva.getPrecioFinal());
        ps.executeUpdate();
        connection.close();
    }

    public void eliminarReserva(Reserva reserva) throws SQLException, ClassNotFoundException {
        connection = getConnection();

        ps = connection.prepareStatement("delete from RESERVA where ID_RESERVA=? and CONTINENTE=? ");
        ps.setInt(1, reserva.getIdReserva());
        ps.setString(2, reserva.getContinente());
        ps.executeUpdate();
        connection.close();
    }

    public ArrayList<Reserva> listarReservasPorCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        ArrayList<Reserva> reservas = new ArrayList<>();
        SQLHabitacion sqlHabitacion = new SQLHabitacion();
        connection = getConnection();
        ps = connection.prepareStatement("select  * from RESERVA  where ID_USUARIO = ? order by ID_RESERVA desc  LIMIT 1");
        ps.setInt(1, cliente.getIdUsuario());
        rs = ps.executeQuery();
        connection.close();
        while (rs.next()){
            Reserva reserva = new Reserva(rs.getInt("ID_RESERVA"));
            reserva.setContinente(rs.getString("CONTINENTE"));
            reserva.setFechaInicio(rs.getDate("FECHA_INICIO"));
            reserva.setFechaFin(rs.getDate("FECHA_FINAL"));
            reserva.setPrecioFinal(rs.getDouble("PRECIO"));
            reserva.setHabitaciones(sqlHabitacion.busquedaPorReserva(reserva));
            reservas.add(reserva);
        }
        return reservas;
    }
}
