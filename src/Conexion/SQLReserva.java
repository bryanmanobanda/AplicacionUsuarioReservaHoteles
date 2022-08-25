package Conexion;

import CRUD.Cliente;
import CRUD.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLReserva {
    PreparedStatement ps;
    ResultSet rs;
    SQLHabitacion conexHab;

    public void insertarReserva(Reserva reserva) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();

        ps = connection.prepareStatement("insert into RESERVA (CONTINENTE, ID_USUARIO, FECHA_INICIO, FECHA_FINAL, PRECIO) values(?,?,?,?,?) ");
        ps.setString(1, reserva.getContinente());
        ps.setInt(2, reserva.getIdUsuario());
        ps.setDate(3, reserva.getFechaInicio());
        ps.setDate(4, reserva.getFechaFin());
        ps.setDouble(5, reserva.getPrecioFinal());
        ps.executeUpdate();
    }

    public void modificarReserva(Reserva reserva) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        ps = connection.prepareStatement("update RESERVA set FECHA_INICIO=?, FECHA_FINAL=?, PRECIO=? ");
        ps.setDate(1, reserva.getFechaInicio());
        ps.setDate(2, reserva.getFechaFin());
        ps.setDouble(3, reserva.getPrecioFinal());
        ps.executeUpdate();
    }

    public void eliminarReserva(Reserva reserva) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();

        ps = connection.prepareStatement("delete from RESERVA where ID_RESERVA=? and CONTINENTE=? ");
        ps.setInt(1, reserva.getIdReserva());
        ps.setString(2, reserva.getContinente());
        ps.executeUpdate();
    }

    public ArrayList<Reserva> busquedaReservasPorCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        ArrayList<Reserva> reservas = new ArrayList<>();
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        SQLHabitacion sqlHabitacion = new SQLHabitacion();
        ps = connection.prepareStatement("select  * from RESERVA  where ID_USUARIO = ?");
        ps.setInt(1, cliente.getIdUsuario());
        rs = ps.executeQuery();
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

    public ArrayList<Reserva> buscarTopReserva(Cliente cliente) throws SQLException, ClassNotFoundException {
        ArrayList<Reserva> reservas = new ArrayList<>();
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        SQLHabitacion sqlHabitacion = new SQLHabitacion();
        ps = connection.prepareStatement("select ID_RESERVA, CONTINENTE, ID_USUARIO, FECHA_INICIO, FECHA_FINAL, PRECIO from RESERVA  where ID_USUARIO = ? order by ID_RESERVA desc  LIMIT 1");
        ps.setInt(1, cliente.getIdUsuario());
        rs = ps.executeQuery();
        while (rs.next()) {
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

    public ArrayList<Reserva> busquedaReservas() throws SQLException, ClassNotFoundException {
        ArrayList<Reserva> reservas = new ArrayList<>();
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();
        SQLHabitacion sqlHabitacion = new SQLHabitacion();
        ps = connection.prepareStatement("select * from RESERVA");
        rs = ps.executeQuery();
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

    public void buscarReserva(Reserva reserva) throws SQLException, ClassNotFoundException {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection connection = con.getConnection();

        ps = connection.prepareStatement("select * from RESERVA where ID_RESERVA=?");
        ps.setInt(1, reserva.getIdReserva());
        rs = ps.executeQuery();

        while (rs.next()){
            reserva.setContinente(rs.getString("CONTINENTE"));
            reserva.setIdUsuario(rs.getInt("ID_USUARIO"));
            reserva.setFechaInicio(rs.getDate("FECHA_INICIO"));
            reserva.setFechaFin(rs.getDate("FECHA_FINAL"));
            reserva.setPrecioFinal(rs.getDouble("PRECIO"));
        }
    }
}
