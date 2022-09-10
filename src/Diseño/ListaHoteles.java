package Diseño;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Conexion.SQLHotel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class ListaHoteles extends Lista {
    private JComboBox<Object> jComboBox = new JComboBox<>();
    private JComboBoxRound jCBusqueda = new JComboBoxRound(jComboBox);
    public JPanel JPBusqueda = new JPanel(new AbsoluteLayout());
    private ArrayList<CajaHotel> listaCajaHotel = new ArrayList<>();
    public ArrayList<String> listaPaises = new ArrayList<>();
    private SQLHotel conexionHotel = new SQLHotel();

    public ListaHoteles() throws SQLException {
        super();
        listaPaises.add("Seleccione un país");
        listaPaises.addAll(conexionHotel.listarPaises());
        jComboBox.setModel(new DefaultComboBoxModel<>(listaPaises.toArray()));
        jComboBox.setPreferredSize(new Dimension(300, 25));
        JPBusqueda.setBackground(ColorCuerpo);
        JPBusqueda.setPreferredSize(new Dimension(1000, 50));
        JPBusqueda.add(jComboBox, new AbsoluteConstraints(350, 14, -1, -1));
        jComboBox.addItemListener(this);
        this.add(JPBusqueda, BorderLayout.NORTH);
    }

    public void agregarCajaHotel(CajaHotel caja) {
        listaCajaHotel.add(caja);
        jPanel.add(caja);
    }

    public void limpiarContenido() {
        super.limpiarContenido();
        jComboBox.removeAll();
        listaCajaHotel.clear();
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        jComboBox.addItemListener(ie1 -> {
            jPanel.removeAll();
            if (jComboBox.getSelectedIndex() == 0) {
                for (CajaHotel cajaHotel : listaCajaHotel) {
                    jPanel.add(cajaHotel);
                }
            } else {
                String paisSeleccionado = (String) jComboBox.getSelectedItem();
                for (CajaHotel cajaHotel : listaCajaHotel) {
                    if (cajaHotel.getHotelSeleccionado().getPais().equals(paisSeleccionado)) {
                        jPanel.add(cajaHotel);
                    }
                }
            }
            jPanel.updateUI();
        });
    }
}