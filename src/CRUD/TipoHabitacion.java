package CRUD;

public class TipoHabitacion {
    private String nombreTipo;
    private int capacidad;
    private int numBanios;

    public TipoHabitacion(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }


    public String getNombreTipo() {
        return nombreTipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getNumBanios() {
        return numBanios;
    }

    public void setNumBanios(int numBanios) {
        this.numBanios = numBanios;
    }
}
