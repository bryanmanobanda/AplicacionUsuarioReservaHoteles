package Diseño;

import CRUD.Reserva;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.util.Objects;
import javax.swing.ImageIcon;

public class CajaReserva extends Caja {
    private Reserva reservaSelecccionada;

    public CajaReserva(Reserva reserva) {
        super();
        reservaSelecccionada = reserva;
        jPInformacion = new PanelDescripcionReserva(reserva);
        jLTitulo.setText("Número de Reserva: " + reserva.getIdReserva());
        jLIcono.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Dialogo/reservado.png")))));

        this.add(jPInformacion, BorderLayout.CENTER);
    }

    public Reserva getreservaSelec() {
        return reservaSelecccionada;
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
}