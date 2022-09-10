package Diseño;

import CRUD.Habitacion;

import java.awt.BorderLayout;

public class PanelDescripcionHabitacion extends PanelDescripcion {

    public PanelDescripcionHabitacion(Habitacion habitacion) {
        super();
        jLDescripcion.setText("<html>" + habitacion.getDescripcion() + "<br>" + "Número de camas: " +
                habitacion.getNumCamas() + "<br>" + " Número de baños: " + habitacion.getTipoHabitacion().getNumBanios()
                + "<br>" + "Capacidad: " + habitacion.getTipoHabitacion().getCapacidad() + "</html>");
        this.add(jPInformacion, BorderLayout.CENTER);
    }
}