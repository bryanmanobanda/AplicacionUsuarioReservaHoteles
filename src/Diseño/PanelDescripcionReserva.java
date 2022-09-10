package Diseño;

import CRUD.Reserva;

import java.awt.BorderLayout;

public class PanelDescripcionReserva extends PanelDescripcion {

    public PanelDescripcionReserva(Reserva reserva) {
        super();
        jLUbicacion.setText(reserva.getContinente());
        jLDescripcion.setText("<html>" + "Fecha inicio: " + reserva.getFechaInicio().toString() + "<br>" + "Fecha fin: "
                + reserva.getFechaFin().toString() + "<br>" + "Precio total: $" + reserva.getPrecioFinal() + "</html>");
        this.add(jPInformacion, BorderLayout.CENTER);
    }
}