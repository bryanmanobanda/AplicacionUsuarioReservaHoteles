package Diseño;

import Conexion.SQLTipoHab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class ListaHabitaciones extends Lista {
    private final Color colorPie = new Color(195, 116, 94);
    private final Font fuenteTitulo = new Font("Open Sans Semibold", Font.BOLD, 18);
    private JComboBox<Object> jComboBox = new JComboBox<>();
    private JComboBoxRound jCbusqueda = new JComboBoxRound(jComboBox);
    public JPanel jPPie = new JPanel(new AbsoluteLayout());
    public JPanel jPbusqueda = new JPanel(new AbsoluteLayout());
    private Dimension dimension = new Dimension(1000, 50);
    private SQLTipoHab conexionTipoHabitacion = new SQLTipoHab();
    private JLabel jLTitulo = new JLabel();
    private ArrayList<CajaHabitacion> listaCajaHabitacion = new ArrayList<>();
    private ArrayList<String> listaTipoHabitacion = new ArrayList<>();

    public ListaHabitaciones() throws SQLException {
        super();
        jComboBox.setPreferredSize(new Dimension(300, 25));
        listaTipoHabitacion.add("Seleccione un tipo");
        listaTipoHabitacion.addAll(conexionTipoHabitacion.listarNombreTipos());
        jComboBox.setModel(new DefaultComboBoxModel<>(listaTipoHabitacion.toArray()));
        jPbusqueda.setBackground(ColorCuerpo);
        jPPie.setBackground(colorPie);
        jLTitulo.setFont(fuenteTitulo);
        jLTitulo.setForeground(Color.WHITE);
        jPbusqueda.setPreferredSize(dimension);
        jPPie.setPreferredSize(dimension);
        jPPie.add(jLTitulo, new AbsoluteConstraints(600, 14, -1, -1));
        jPbusqueda.add(jComboBox, new AbsoluteConstraints(350, 14, -1, -1));

        jComboBox.addItemListener(this);
        this.add(jPbusqueda, BorderLayout.NORTH);
        this.add(jPPie, BorderLayout.SOUTH);
    }

    public void agregarCajaHabitacion(CajaHabitacion caja) {
        listaCajaHabitacion.add(caja);
        jPanel.add(caja);
    }

    public void setjLTitulo(String jLTitulo) {
        this.jLTitulo.setText(jLTitulo);
    }

    public JPanel getjPPie() {
        return jPPie;
    }

    public void limpiarContenido() {
        super.limpiarContenido();
        jPPie.updateUI();
        jComboBox.removeAll();
        listaCajaHabitacion.clear();
        jPbusqueda.updateUI();
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        jComboBox.addItemListener(ie1 -> {
            jPanel.removeAll();
            if (jComboBox.getSelectedIndex() == 0) {
                for (CajaHabitacion cajaHabitacion : listaCajaHabitacion) {
                    jPanel.add(cajaHabitacion);
                }
            } else {
                String tipoSeleccionado = (String) jComboBox.getSelectedItem();
                for (CajaHabitacion cajaHabitacion : listaCajaHabitacion) {
                    if (cajaHabitacion.getHabitacionSeleccionada().getTipoHabitacion().getNombreTipo().equals(tipoSeleccionado)) {
                        jPanel.add(cajaHabitacion);
                    }
                }
            }
            jPanel.updateUI();
        });
    }
}