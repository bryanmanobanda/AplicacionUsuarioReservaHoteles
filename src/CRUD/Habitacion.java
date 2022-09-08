package CRUD;

public class Habitacion {
    private int idHotel;
    private String continente;
    private int numeroHabitacion;
    private TipoHabitacion tipoHabitacion;
    private boolean disponibilidad;
    private String descripcion;
    private int numCamas;
    private double precio;

    public Habitacion(int idHotel, String continente, int numeroHabitacion) {
        this.idHotel = idHotel;
        this.continente = continente;
        this.numeroHabitacion = numeroHabitacion;
    }

    public Habitacion(int idHotel, String continente, int numeroHabitacion, TipoHabitacion tipoHabitacion, boolean disponibilidad, String descripcion, int numCamas, double precio) {
        this.idHotel = idHotel;
        this.continente = continente;
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.disponibilidad = disponibilidad;
        this.descripcion = descripcion;
        this.numCamas = numCamas;
        this.precio = precio;
    }

    public Habitacion(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(int numCamas) {
        this.numCamas = numCamas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }
}
