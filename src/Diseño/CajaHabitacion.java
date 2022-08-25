package Diseño;

import CRUD.Habitacion;
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

public class CajaHabitacion extends JButton implements MouseListener, ActionListener{
  private final Color principal = new Color(219, 157, 121);
  private final Color secundario = new Color(153, 77, 60);
  private final Color linea = new Color(35, 31, 32);
  private final Font Ftitulo = new Font("Open Sans Semibold", Font.BOLD, 18);
  private final Dimension d = new Dimension(257, 142);
  JPanel JPTitulo = new JPanel(new BorderLayout());
  JPanel JPIcono = new JPanel(new BorderLayout());
  JLabel titulo= new JLabel();
  JLabel hab= new JLabel();
  JLabel prec= new JLabel();
  JLabel icon = new JLabel();
  DescHabitacionPanel informacion;
  Habitacion habitacionselec;

  public CajaHabitacion(Habitacion habitacion) {
    habitacionselec = habitacion;
    informacion = new DescHabitacionPanel(habitacion);
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
    hab.setFont(Ftitulo);
    hab.setForeground(Color.WHITE);
    hab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    prec.setFont(Ftitulo);
    prec.setForeground(Color.WHITE);
    JPTitulo.setBackground(principal);
    titulo.setText(habitacion.getTipoHabitacion().getNombreTipo());
    prec.setText("$"+habitacion.getPrecio());
    hab.setText(""+habitacion.getNumeroHabitacion());
    JPTitulo.setSize(87,15);
    JPTitulo.add(titulo, BorderLayout.WEST);
    JPTitulo.add(prec, BorderLayout.EAST);
    JPTitulo.add(hab, BorderLayout.CENTER);
    JPIcono.setBackground(principal);
    icon.setIcon(cambiarIcon(habitacion.getTipoHabitacion().getNombreTipo()));
    JPIcono.add(icon, BorderLayout.CENTER);
    this.add(JPIcono, BorderLayout.WEST);
    this.add(informacion, BorderLayout.CENTER);
    this.add(JPTitulo, BorderLayout.NORTH);
    addMouseListener(this);
    addActionListener(this);
  }
  
  public Icon cambiarIcon(String tipo){
    Icon hotelicono = null;
    switch(tipo){
      case "TWIN":
        hotelicono = new ImageIcon((getClass().getResource("/Assets/Habitacion/Twin.png")));
        return hotelicono;
      case "DOBLE":
        hotelicono = new ImageIcon((getClass().getResource("/Assets/Habitacion/Doble.png")));
        return hotelicono;
      case "INDIVIDUAL":
        hotelicono = new ImageIcon((getClass().getResource("/Assets/Habitacion/Individual.png")));
        return hotelicono;
      case "TRIPLE":
        hotelicono = new ImageIcon((getClass().getResource("/Assets/Habitacion/Triple.png")));
        return hotelicono;
      case "CUADRUPLE":
        hotelicono = new ImageIcon((getClass().getResource("/Assets/Habitacion/Cuadruple.png")));
        return hotelicono;
      case "MATRIMONIAL":
        hotelicono = new ImageIcon((getClass().getResource("/Assets/Habitacion/Matrimonial.png")));
        return hotelicono;
      case "FAMILIAR":
        hotelicono = new ImageIcon((getClass().getResource("/Assets/Habitacion/Familiar.png")));
        return hotelicono;
      case "SUITE PRINCIPAL":
        hotelicono = new ImageIcon((getClass().getResource("/Assets/Habitacion/Suite.png")));
        return hotelicono;
    }
    return hotelicono;
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
    if(this.isFocusable()){
      JPTitulo.setBackground(secundario);
      JPIcono.setBackground(secundario);
      informacion.setBackground(secundario);
      informacion.getInformacion().setBackground(secundario);
      informacion.getPicon().setBackground(secundario);
    }
  }

  @Override
  public void mouseExited(MouseEvent me) {
    if(this.isFocusable()){
      informacion.setBackground(principal);
      informacion.getInformacion().setBackground(principal);
      informacion.getPicon().setBackground(principal);
      JPIcono.setBackground(principal);
      JPTitulo.setBackground(principal);
    }
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
  }

  public Habitacion getHabitacionselec() {
    return habitacionselec;
  }

  public void setHabitacionselec(Habitacion habitacionselec) {
    this.habitacionselec = habitacionselec;
  }

  public CajaHabitacion getCaja(){
    return this;
  }
  
}
