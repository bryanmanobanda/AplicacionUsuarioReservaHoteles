package CRUD;

import java.sql.Date;
import java.util.ArrayList;

public class Cliente {
    private int idUsuario;
    private String nombre;
    private String correo;
    private String contrasenia;
    private String pais;
    private Date fechaNacimiento;
    private ArrayList<Reserva> reservas;

    public Cliente(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Cliente(String nombre, String correo, String contrasenia, String pais, Date fechaNacimiento) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente() {

    }

    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public void quitarReserva(int idReserva) {
        Reserva aux = reservas.get(buscarReserva(idReserva));
        this.reservas.remove(aux);
    }

    public void quitarReserva(Reserva reserva){
        this.reservas.remove(reserva);
    }

    public int buscarReserva(int idReserva) {
        for (Reserva reserva : this.reservas) {
            if (reserva.getIdReserva() == idReserva) {
                return reservas.indexOf(reserva);
            }
        }
        System.out.println("No existe tal reserva");
        return -1;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
}
