package Diseño;

import CRUD.Hotel;

import java.awt.*;
import java.awt.event.MouseEvent;

public class CajaHotel extends Caja {
    private Hotel hotelSeleccionado;

    public CajaHotel(Hotel hotel) {
        super();
        hotelSeleccionado = hotel;
        jPInformacion = new PanelDescripcionHotel(hotel);
        jLTitulo.setText(hotel.getNombre());
        jLIcono.setIcon(hotel.getIcono());

        this.add(jPInformacion, BorderLayout.CENTER);
    }

    public Hotel getHotelSeleccionado() {
        return hotelSeleccionado;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        jPTitulo.setBackground(colorSecundario);
        jPIcono.setBackground(colorSecundario);
        jPInformacion.setBackground(colorSecundario);
        jPInformacion.getjPInformacion().setBackground(colorSecundario);
        jPInformacion.getjPIcono().setBackground(colorSecundario);
    }

    @Override
    public void mouseExited(MouseEvent me) {
        jPInformacion.setBackground(colorPrincipal);
        jPInformacion.getjPInformacion().setBackground(colorPrincipal);
        jPInformacion.getjPIcono().setBackground(colorPrincipal);
        jPIcono.setBackground(colorPrincipal);
        jPTitulo.setBackground(colorPrincipal);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }
}