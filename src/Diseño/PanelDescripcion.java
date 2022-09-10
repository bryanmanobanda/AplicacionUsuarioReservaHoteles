package Diseño;

import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;

public abstract class PanelDescripcion extends JPanel {
    protected final Font fuenteTitulo = new Font("Open Sans", Font.BOLD, 13);
    protected final Font fuenteSubtitulo = new Font("Segoe UI Semibold", Font.PLAIN, 12);
    protected final Color colorPrincipal = new Color(219, 157, 121);
    protected JLabel jLUbicacion = new JLabel();
    protected JLabel jLDescripcion = new JLabel();
    protected JPanel jPInformacion = new JPanel(new BorderLayout());
    protected JPanel jPIcono = new JPanel(new AbsoluteLayout());

    public PanelDescripcion() {
        this.setLayout(new BorderLayout());
        jLUbicacion.setFont(fuenteTitulo);
        jLDescripcion.setFont(fuenteSubtitulo);
        jLUbicacion.setBorder(null);
        jLDescripcion.setVerticalAlignment(SwingConstants.TOP);
        jPIcono.setBackground(colorPrincipal);
        jPInformacion.setBackground(colorPrincipal);
        jPInformacion.add(jLUbicacion, BorderLayout.NORTH);
        jPInformacion.add(jLDescripcion, BorderLayout.CENTER);
    }

    public JPanel getjPInformacion() {
        return jPInformacion;
    }

    public JPanel getjPIcono() {
        return jPIcono;
    }
}