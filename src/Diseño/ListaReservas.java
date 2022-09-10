package Diseño;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

public class ListaReservas extends Lista {
    private ArrayList<CajaReserva> listaCajaReserva = new ArrayList<>();

    public ListaReservas() {
        super();
        jPanel = new JPanel(new GridLayout(0, 1, 30, 30));
        jPanel.setBackground(ColorCuerpo);
        jSPanel.getViewport().add(jPanel);
    }

    public void agregarCajaReserva(CajaReserva caja) {
        listaCajaReserva.add(caja);
        jPanel.add(caja);
    }

    public void limpiarContenido() {
        super.limpiarContenido();
        listaCajaReserva.clear();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }
}