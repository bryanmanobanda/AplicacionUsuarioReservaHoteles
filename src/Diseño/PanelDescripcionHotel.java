package Diseño;

import CRUD.Hotel;

import java.awt.BorderLayout;

public class PanelDescripcionHotel extends PanelDescripcion {

    public PanelDescripcionHotel(Hotel hotel) {
        super();
        jLUbicacion.setText(hotel.getPais() + " - " + hotel.getCiudad());
        jLDescripcion.setText("<html>" + hotel.getDescripcion() + "<br>" + hotel.getCorreo() + "<br>" + hotel.getTelefono() + "</html>");
        this.add(jPInformacion, BorderLayout.CENTER);
    }
}