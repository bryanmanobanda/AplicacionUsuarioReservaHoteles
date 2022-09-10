package Diseño;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public abstract class Caja extends JButton implements MouseListener {
    protected final Color colorPrincipal = new Color(219, 157, 121);
    protected final Color colorSecundario = new Color(153, 77, 60);
    protected final Color colorLinea = new Color(35, 31, 32);
    protected final Font fuenteTitulo = new Font("Open Sans Semibold", Font.BOLD, 18);
    protected final Dimension dimension = new Dimension(257, 142);
    protected JPanel jPTitulo = new JPanel(new BorderLayout());
    protected JPanel jPIcono = new JPanel(new BorderLayout());
    protected JLabel jLTitulo = new JLabel();
    protected JLabel jLIcono = new JLabel();
    protected PanelDescripcion jPInformacion;

    public Caja() {
        this.setBorder(BorderFactory.createLineBorder(colorLinea));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setBackground(colorPrincipal);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setOpaque(true);
        this.setText("");
        this.setLayout(new BorderLayout());

        jLTitulo.setFont(fuenteTitulo);
        jLTitulo.setForeground(Color.WHITE);
        jPTitulo.setBackground(colorPrincipal);
        jPTitulo.setSize(87, 15);
        jPTitulo.add(jLTitulo, BorderLayout.CENTER);
        jPIcono.setBackground(colorPrincipal);
        jPIcono.add(jLIcono, BorderLayout.CENTER);

        this.add(jPIcono, BorderLayout.WEST);
        this.add(jPTitulo, BorderLayout.NORTH);

        addMouseListener(this);
    }
}
