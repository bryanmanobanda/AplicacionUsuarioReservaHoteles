package CRUD;

import javax.swing.*;
import java.util.Objects;

public class TipoHabitacion {
    private String nombreTipo;
    private int capacidad;
    private int numBanios;
    private Icon icono;

    public TipoHabitacion(String nombreTipo) {
        this.nombreTipo = nombreTipo;
        setIcono();
    }

    //TODO: REFACTOR
    private void setIcono() {
        switch (nombreTipo) {
            case "TWIN" -> icono = new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Habitacion/Twin.png"))));
            case "DOBLE" -> icono = new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Habitacion/Doble.png"))));
            case "INDIVIDUAL" -> icono = new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Habitacion/Individual.png"))));
            case "TRIPLE" -> icono = new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Habitacion/Triple.png"))));
            case "CUADRUPLE" -> icono = new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Habitacion/Cuadruple.png"))));
            case "MATRIMONIAL" -> icono = new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Habitacion/Matrimonial.png"))));
            case "FAMILIAR" -> icono = new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Habitacion/Familiar.png"))));
            case "SUITE PRINCIPAL" -> icono = new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Habitacion/Suite.png"))));
        }
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

    public Icon getIcono() {
        return icono;
    }
}
