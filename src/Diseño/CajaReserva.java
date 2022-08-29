package Diseño;

import CRUD.Hotel;
import CRUD.Reserva;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CajaReserva extends JButton implements MouseListener, ActionListener{
  private final Color principal = new Color(219, 157, 121);
  private final Color secundario = new Color(153, 77, 60);
  private final Color linea = new Color(35, 31, 32);
  private final Font Ftitulo = new Font("Open Sans Semibold", Font.BOLD, 18);
  private final Dimension d = new Dimension(257, 142);
  JPanel JPTitulo = new JPanel(new BorderLayout());
  JPanel JPIcono = new JPanel(new BorderLayout());
  JLabel titulo= new JLabel();
  JLabel icon = new JLabel();
  DescReservaPanel informacion;
  Reserva reservaSelec;
  
  public CajaReserva() {}
  
  public CajaReserva(Reserva reserva) {
    reservaSelec = reserva;
    informacion = new DescReservaPanel(reserva);
    this.setBorder( BorderFactory.createLineBorder(linea));
    this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.setBackground(principal);
    this.setSize(d);
    this.setPreferredSize(d);
    this.setOpaque(true);
    this.setText("");
    this.setLayout(new BorderLayout());
    titulo.setFont(Ftitulo);
    titulo.setForeground(Color.WHITE);
    JPTitulo.setBackground(principal);
    titulo.setText("Número de Reserva: " + String.valueOf(reserva.getIdReserva()));
    JPTitulo.setSize(87,15);
    JPTitulo.add(titulo, BorderLayout.CENTER);
    JPIcono.setBackground(principal);
    icon.setIcon(new ImageIcon((getClass().getResource("/Assets/Dialogo/reserva.png"))));
    JPIcono.add(icon, BorderLayout.CENTER);
    this.add(JPIcono, BorderLayout.WEST);
    this.add(informacion, BorderLayout.CENTER);
    this.add(JPTitulo, BorderLayout.NORTH);
    addMouseListener(this);
    addActionListener(this);
  }
  
 /*
  public Hotel getHotelSelec() {
    return hotelSelec;
  }

  public void setHotelSelec(Hotel hotelSelec) {
    this.hotelSelec = hotelSelec;
  }
*/
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
    JPTitulo.setBackground(secundario);
    JPIcono.setBackground(secundario);
    informacion.setBackground(secundario);
    informacion.getInformacion().setBackground(secundario);
    informacion.getPicon().setBackground(secundario);
  }

  @Override
  public void mouseExited(MouseEvent me) {
    informacion.setBackground(principal);
    informacion.getInformacion().setBackground(principal);
    informacion.getPicon().setBackground(principal);
    JPIcono.setBackground(principal);
    JPTitulo.setBackground(principal);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
  }
}
