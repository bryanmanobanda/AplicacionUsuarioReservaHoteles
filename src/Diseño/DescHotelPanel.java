package Diseño;

import CRUD.Hotel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class DescHotelPanel extends JPanel {
  private final Font titulo = new Font("Open Sans", Font.BOLD, 13);
  private final Font subtitulo = new Font("Segoe UI Semibold", Font.PLAIN, 12);
  private final Color principal = new Color(219, 157, 121);
  JLabel ubicacion = new JLabel();
  JLabel descripcion = new JLabel();
  JPanel informacion = new JPanel(new BorderLayout());
  JPanel picon = new JPanel(new AbsoluteLayout());
  public DescHotelPanel(Hotel hotel) {
    this.setLayout(new BorderLayout());
    ubicacion.setFont(titulo);
    descripcion.setFont(subtitulo);
    ubicacion.setBorder(null);
    descripcion.setVerticalAlignment(SwingConstants.TOP);
    picon.setBackground(principal);
    informacion.setBackground(principal);
    ubicacion.setText(hotel.getPais() + " - " + hotel.getCiudad());
    descripcion.setText("<html>"+hotel.getDescripcion()+"<br>"+hotel.getCorreo()+"<br>"+hotel.getTelefono()+"</html>");
    informacion.add(ubicacion, BorderLayout.NORTH);
    informacion.add(descripcion, BorderLayout.CENTER);
    this.add(informacion, BorderLayout.CENTER);
  }

  public JLabel getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(JLabel ubicacion) {
    this.ubicacion = ubicacion;
  }

  public JLabel getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(JLabel descripcion) {
    this.descripcion = descripcion;
  }

  public JPanel getInformacion() {
    return informacion;
  }

  public void setInformacion(JPanel informacion) {
    this.informacion = informacion;
  }

  public Font getTitulo() {
    return titulo;
  }

  public JPanel getPicon() {
    return picon;
  }

  public void setPicon(JPanel picon) {
    this.picon = picon;
  }
}
