package CRUD;

public class TipoHabitacion {
    private String nombreTipo;
    private int capacidad;
    private int numBanios;

    public TipoHabitacion(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public TipoHabitacion(String nombreTipo, int capacidad, int numBanios) {
        this.nombreTipo = nombreTipo;
        this.capacidad = capacidad;
        this.numBanios = numBanios;
    }


    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
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
