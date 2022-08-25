package CRUD;

import java.sql.Date;
import java.util.ArrayList;

public class Reserva {
    private int idReserva;
    private String continente;
    private int idUsuario;
    private Date fechaInicio;
    private Date fechaFin;
    private ArrayList<Habitacion> habitaciones;
    private double precioFinal;

    public Reserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Reserva(int idReserva, String continente, int idUsuario, Date fechaInicio, Date fechaFin, double precioFinal) {
        this.idReserva = idReserva;
        this.continente = continente;
        this.idUsuario = idUsuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioFinal = precioFinal;
    }

    public Reserva(String continente, int idUsuario, Date fechaInicio, Date fechaFin, ArrayList<Habitacion> habitaciones, double precioFinal) {
      this.continente = continente;
      this.idUsuario = idUsuario;
      this.fechaInicio = fechaInicio;
      this.fechaFin = fechaFin;
      this.habitaciones = habitaciones;
      this.precioFinal = precioFinal;
    }
    
    public void cambiarEstado(){
      for(int i = 0; i < this.habitaciones.size();i++)
        this.habitaciones.get(i).setDisponibilidad(false);
    }

    public void agregarHabitacion(Habitacion nuevaHabitacion){
        this.habitaciones.add(nuevaHabitacion);
    }

    public void removerHabiracion(Habitacion removerHabitacion){
        if (!this.habitaciones.removeIf(habitacion -> habitacion.equals(removerHabitacion))) {
            System.out.println("No hay habitacion");
        }
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
