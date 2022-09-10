package Diseño;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;

public abstract class Lista extends JPanel implements ItemListener {
    protected final Color ColorCuerpo = new Color(147,171,169);
    protected JScrollPane jSPanel = new JScrollPane();
    public JPanel jPanel = new JPanel(new GridLayout(0, 3, 30, 30));

    public Lista() {
        jSPanel.setBackground(ColorCuerpo);
        jSPanel.setBorder(null);
        jPanel.setBackground(ColorCuerpo);
        jSPanel.getViewport().add(jPanel);
        this.setBackground(ColorCuerpo);
        this.setLayout(new BorderLayout());
        this.add(jSPanel, BorderLayout.CENTER);
    }

    public void limpiarContenido(){
        jPanel.removeAll();
        jPanel.updateUI();
    }
}