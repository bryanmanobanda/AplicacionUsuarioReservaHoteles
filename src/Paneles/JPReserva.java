package Paneles;

import Diseño.CajaHabitacion;
import Diseño.JLabelTitle;
import Diseño.JTextCalendar;
import Diseño.JTextFieldRound;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class JPReserva extends javax.swing.JPanel {
  public JTextFieldRound nombre, pais, habitacion, precio;
  JTextCalendar calendar, calendarf;
  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  JLabelTitle jLT;
  int tamText = 20, x = 220, y = 30, numHab=0;
  public Double precioHab = 0.0;
  GregorianCalendar inicio = new GregorianCalendar(Locale.US);
  GregorianCalendar finalr = new GregorianCalendar(2021, Calendar.SEPTEMBER,18);
  Dimension d = new Dimension(300, 25);
  Dimension d1 = new Dimension(150, 25);
  JScrollPane jsPanel = new JScrollPane();

  public JPReserva() throws ParseException {
    initComponents();
    Habitacion.setLayout(new GridLayout(0, 1, 10, 30));
    jsPanel.setPreferredSize(new Dimension(300, 457));
    Informacion.setPreferredSize(new Dimension(389, 457));
    nombre = new JTextFieldRound(""){
      @Override
      public void mousePressed(MouseEvent me) {
      }
    };
    pais = new JTextFieldRound(""){
      @Override
      public void mousePressed(MouseEvent me) {
      }
    };
    habitacion = new JTextFieldRound(""+numHab){
      @Override
      public void mousePressed(MouseEvent me) {
      }
    };
    precio = new JTextFieldRound("$"+ precioHab){
      @Override
      public void mousePressed(MouseEvent me) {
      }
    };
    nombre.setEnabled(false);
    pais.setEnabled(false);
    habitacion.setEnabled(false);
    precio.setEnabled(false);
    nombre.setPreferredSize(d);
    pais.setPreferredSize(d);
    habitacion.setPreferredSize(d1);
    precio.setPreferredSize(d1);
    jLT = new JLabelTitle("", jLTitulo, 40);
    jLT = new JLabelTitle("Nombre", jLNombre, tamText);
    jLT = new JLabelTitle("País", jLPais, tamText); 
    jLT = new JLabelTitle("Fecha Inicio", jLFechaInicio,  tamText);
    jLT = new JLabelTitle("Fecha Final", jLFechaFinal,tamText );
    jLT = new JLabelTitle("Habitaciones", jLHabitaciones, tamText);
    jLT = new JLabelTitle("Precio", jLPrecio, tamText);
    calendar = new JTextCalendar(jDateInicio, inicio);
    calendarf = new JTextCalendar(jDateFinal, finalr);
    calendar.getCalendar().setMinSelectableDate(dateFormat.parse("2021-09-17"));
    calendarf.getCalendar().setMinSelectableDate(dateFormat.parse("2021-09-18"));
    jLFondo.setSize(new Dimension(389, 457));
    Informacion.add(jLFondo, new AbsoluteConstraints(-10, -10 ,-1, -1));
    Informacion.add(jLTitulo, new AbsoluteConstraints(x, 20 ,-1, -1));
    Informacion.add(jLNombre, new AbsoluteConstraints(x, 70+ y,-1, -1));
    Informacion.add(nombre, new AbsoluteConstraints(x, 95+ y,-1, -1));
    Informacion.add(jLPais, new AbsoluteConstraints(x, 135+ y,-1, -1));
    Informacion.add(pais, new AbsoluteConstraints(x, 160+ y,-1, -1));
    Informacion.add(jLFechaInicio, new AbsoluteConstraints(x, 205+ y,-1, -1));
    Informacion.add(jDateInicio, new AbsoluteConstraints(x, 230+ y,-1, -1));
    Informacion.add(jLFechaFinal, new AbsoluteConstraints(180+ x, 205+ y,-1, -1));
    Informacion.add(jDateFinal, new AbsoluteConstraints(180+ x, 230+ y,-1, -1));
    Informacion.add(jLHabitaciones, new AbsoluteConstraints(x, 270+ y,-1, -1));
    Informacion.add(habitacion, new AbsoluteConstraints(x, 295+ y,-1, -1));
    Informacion.add(jLPrecio, new AbsoluteConstraints(180 + x, 270+ y,-1, -1));
    Informacion.add(precio, new AbsoluteConstraints(180 + x, 295+ y,-1, -1));
    this.add(jsPanel, BorderLayout.WEST);
    jsPanel.getViewport().add(Habitacion);
  }
  
  public void limpieza(){
    nombre.setText("");
    pais.setText("");
    habitacion.setText("");
    precio.setText("");
    precioHab = 0.0;
    Habitacion.removeAll();
    Habitacion.updateUI();
  }

  public void listarHabitaciones(ArrayList<CajaHabitacion> caja, String nombreHotel, String nombreCliente, String clientePais) throws ParseException{
    numHab = caja.size();
    precioHab = 0.0;
    for(int i = 0; i < numHab;i++){
      Habitacion.add(caja.get(i));
      precioHab += caja.get(i).getHabitacionselec().getPrecio();
    }
    nombre.setText(nombreCliente);
    pais.setText(clientePais);
    habitacion.setText(""+numHab);
    precio.setText(String.valueOf(precioHab));
    jLTitulo.setText(nombreHotel);
  }
  
  public void setjDateFinal(JLabel jDateFinal) {
    this.jDateFinal = jDateFinal;
  }

  public JPanel getHabitacion() {
    return Habitacion;
  }

  public void setHabitacion(JPanel Habitacion) {
    this.Habitacion = Habitacion;
  }

  public JPanel getInformacion() {
    return Informacion;
  }

  public void setInformacion(JPanel Informacion) {
    this.Informacion = Informacion;
  }

  public JLabel getjDateInicio() {
    return jDateInicio;
  }

  public void setjDateInicio(JLabel jDateInicio) {
    this.jDateInicio = jDateInicio;
  }
  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    Habitacion = new javax.swing.JPanel();
    Informacion = new javax.swing.JPanel();
    jDateInicio = new javax.swing.JLabel();
    jDateFinal = new javax.swing.JLabel();
    jLNombre = new javax.swing.JLabel();
    jLPais = new javax.swing.JLabel();
    jLFechaInicio = new javax.swing.JLabel();
    jLFechaFinal = new javax.swing.JLabel();
    jLHabitaciones = new javax.swing.JLabel();
    jLPrecio = new javax.swing.JLabel();
    jLTitulo = new javax.swing.JLabel();
    jLFondo = new javax.swing.JLabel();

    setLayout(new java.awt.BorderLayout());

    Habitacion.setBackground(new java.awt.Color(147, 171, 169));
    Habitacion.setAutoscrolls(true);
    Habitacion.setMinimumSize(new java.awt.Dimension(250, 250));
    Habitacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    add(Habitacion, java.awt.BorderLayout.WEST);

    Informacion.setBackground(new java.awt.Color(147, 171, 169));
    Informacion.setEnabled(false);
    Informacion.setFocusable(false);
    Informacion.setPreferredSize(new java.awt.Dimension(200, 200));
    Informacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jDateInicio.setText("jLabel1");
    Informacion.add(jDateInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 61, -1, -1));

    jDateFinal.setText("jLabel2");
    Informacion.add(jDateFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 81, -1, -1));

    jLNombre.setText("jLabel1");
    Informacion.add(jLNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 19, -1, -1));

    jLPais.setText("jLabel2");
    Informacion.add(jLPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 19, -1, -1));

    jLFechaInicio.setText("jLabel3");
    Informacion.add(jLFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 19, -1, -1));

    jLFechaFinal.setText("jLabel4");
    Informacion.add(jLFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 19, -1, -1));

    jLHabitaciones.setText("jLabel5");
    Informacion.add(jLHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 27, -1, -1));

    jLPrecio.setText("jLabel6");
    Informacion.add(jLPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 39, -1, -1));

    jLTitulo.setText("jLabel7");
    Informacion.add(jLTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 39, -1, -1));

    jLFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Logo/Fondo.png"))); // NOI18N
    jLFondo.setFocusable(false);
    jLFondo.setRequestFocusEnabled(false);
    jLFondo.setVerifyInputWhenFocusTarget(false);
    Informacion.add(jLFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 0, 310, -1));

    add(Informacion, java.awt.BorderLayout.CENTER);
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  public javax.swing.JPanel Habitacion;
  public javax.swing.JPanel Informacion;
  public javax.swing.JLabel jDateFinal;
  public javax.swing.JLabel jDateInicio;
  private javax.swing.JLabel jLFechaFinal;
  private javax.swing.JLabel jLFechaInicio;
  private javax.swing.JLabel jLFondo;
  private javax.swing.JLabel jLHabitaciones;
  private javax.swing.JLabel jLNombre;
  private javax.swing.JLabel jLPais;
  private javax.swing.JLabel jLPrecio;
  private javax.swing.JLabel jLTitulo;
  // End of variables declaration//GEN-END:variables
}