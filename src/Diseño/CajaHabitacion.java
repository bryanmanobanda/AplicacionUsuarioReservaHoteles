package Diseño;

import CRUD.Habitacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class CajaHabitacion extends Caja {
    private JLabel jLhabitacion = new JLabel();
    private JLabel jLprecio = new JLabel();
    private Habitacion habitacionSeleccionada;

    public CajaHabitacion(Habitacion habitacion) {
        super();
        habitacionSeleccionada = habitacion;
        jPInformacion = new PanelDescripcionHabitacion(habitacion);
        jLhabitacion.setFont(fuenteTitulo);
        jLhabitacion.setForeground(Color.WHITE);
        jLhabitacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLprecio.setFont(fuenteTitulo);
        jLprecio.setForeground(Color.WHITE);
        jLTitulo.setText(habitacion.getTipoHabitacion().getNombreTipo());
        jLprecio.setText("$" + habitacion.getPrecio());
        jLhabitacion.setText("" + habitacion.getNumeroHabitacion());
        jPTitulo.add(jLTitulo, BorderLayout.WEST);
        jPTitulo.add(jLprecio, BorderLayout.EAST);
        jPTitulo.add(jLhabitacion, BorderLayout.CENTER);
        jLIcono.setIcon(habitacion.getTipoHabitacion().getIcono());

        this.add(jPInformacion, BorderLayout.CENTER);
    }

    public Habitacion getHabitacionSeleccionada() {
        return habitacionSeleccionada;
    }

    public CajaHabitacion getCaja() {
        return this;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (this.isFocusable()) {
            jPTitulo.setBackground(colorSecundario);
            jPIcono.setBackground(colorSecundario);
            jPInformacion.setBackground(colorSecundario);
            jPInformacion.getjPInformacion().setBackground(colorSecundario);
            jPInformacion.getjPIcono().setBackground(colorSecundario);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (this.isFocusable()) {
            jPInformacion.setBackground(colorPrincipal);
            jPInformacion.getjPInformacion().setBackground(colorPrincipal);
            jPInformacion.getjPIcono().setBackground(colorPrincipal);
            jPIcono.setBackground(colorPrincipal);
            jPTitulo.setBackground(colorPrincipal);
        }
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