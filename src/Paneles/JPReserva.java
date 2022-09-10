package Paneles;

import Diseño.CajaHabitacion;
import Diseño.JLabelTitle;
import Diseño.JTextCalendar;
import Diseño.JTextFieldRound;
import java.awt.BorderLayout;
import java.awt.Component;
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
  int tamText = 20, x = 220, y = 30, numHab=0;
  public Double precioHab = 0.0;
  GregorianCalendar inicio = new GregorianCalendar(Locale.US);
  GregorianCalendar finalr = new GregorianCalendar(2021, Calendar.SEPTEMBER,18);
  Dimension d = new Dimension(300, 25);
  Dimension d1 = new Dimension(150, 25);
  JScrollPane jsPanel = new JScrollPane();
  JLabelTitle jLTitulo, jLNombre, jLHabitaciones, jLPais, jLPrecio, jLFechaInicio;

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
    /*nombre.setEnabled(false);
    pais.setEnabled(false);
    habitacion.setEnabled(false);
    precio.setEnabled(false);*/
    ocultarEliementos();
    /*nombre.setPreferredSize(d);
    pais.setPreferredSize(d);
    habitacion.setPreferredSize(d1);
    precio.setPreferredSize(d1);*/
    dimensionarElemenyos();
    /*jLTitulo = new JLabelTitle("",  40);
    jLNombre = new JLabelTitle("Nombre",  tamText);
    jLPais = new JLabelTitle("País",  tamText); 
    jLFechaInicio = new JLabelTitle("Fecha Inicio",  tamText);
    jLHabitaciones = new JLabelTitle("Habitaciones",  tamText);
    jLPrecio = new JLabelTitle("Precio", tamText);
    calendar = new JTextCalendar(jDateInicio, inicio);
    calendarf = new JTextCalendar(jDateFinal, finalr);*/
    inicializarEliementos();
    calendar.getCalendar().setMinSelectableDate(dateFormat.parse("2022-09-09"));
    calendarf.getCalendar().setMinSelectableDate(dateFormat.parse("2022-09-10"));
    jLFondo.setSize(new Dimension(389, 457));
    Component jLFechaFinal = new JLabelTitle("Fecha Final", tamText );
    Informacion.add(jLFechaFinal, new AbsoluteConstraints(180+ x, 205+ y,-1, -1));
    Informacion.add(jLFondo, new AbsoluteConstraints(-10, -10 ,-1, -1));
    /*
    Informacion.add(jLTitulo, new AbsoluteConstraints(x, 20 ,-1, -1));
    Informacion.add(jLNombre, new AbsoluteConstraints(x, 70+ y,-1, -1));
    Informacion.add(nombre, new AbsoluteConstraints(x, 95+ y,-1, -1));
    Informacion.add(jLPais, new AbsoluteConstraints(x, 135+ y,-1, -1));
    Informacion.add(pais, new AbsoluteConstraints(x, 160+ y,-1, -1));
    Informacion.add(jLFechaInicio, new AbsoluteConstraints(x, 205+ y,-1, -1));
    Informacion.add(jDateInicio, new AbsoluteConstraints(x, 230+ y,-1, -1));
    Informacion.add(jDateFinal, new AbsoluteConstraints(180+ x, 230+ y,-1, -1));
    Informacion.add(jLHabitaciones, new AbsoluteConstraints(x, 270+ y,-1, -1));
    Informacion.add(habitacion, new AbsoluteConstraints(x, 295+ y,-1, -1));
    Informacion.add(jLPrecio, new AbsoluteConstraints(180 + x, 270+ y,-1, -1));
    Informacion.add(precio, new AbsoluteConstraints(180 + x, 295+ y,-1, -1));*/
    posicionarElementos();
    this.add(jsPanel, BorderLayout.WEST);
    jsPanel.getViewport().add(Habitacion);
  }
  
  public final void ocultarEliementos(){
    nombre.setEnabled(false);
    pais.setEnabled(false);
    habitacion.setEnabled(false);
    precio.setEnabled(false);
  }
  
  public final void dimensionarElemenyos(){
    nombre.setPreferredSize(d);
    pais.setPreferredSize(d);
    habitacion.setPreferredSize(d1);
    precio.setPreferredSize(d1); 
  }
  
   public final void inicializarEliementos(){
    jLTitulo = new JLabelTitle("",  40);
    jLNombre = new JLabelTitle("Nombre",  tamText);
    jLPais = new JLabelTitle("País",  tamText); 
    jLFechaInicio = new JLabelTitle("Fecha Inicio",  tamText);
    jLHabitaciones = new JLabelTitle("Habitaciones",  tamText);
    jLPrecio = new JLabelTitle("Precio", tamText);
    calendar = new JTextCalendar(jDateInicio, inicio);
    calendarf = new JTextCalendar(jDateFinal, finalr);
  }
  
  public final void posicionarElementos(){
      int posX[] = {0,0,0,0,0,0,0,180,0,0,180,180};
      int posY[] = {20,70,95,135,160,205,230,230,270,295,270,295};
      Component etiquetas[]={jLTitulo,jLNombre,nombre,jLPais,pais,jLFechaInicio,jDateInicio,jDateFinal,jLHabitaciones,habitacion,jLPrecio,precio};
      for (int i = 0; i < posX.length; i++) {
        Informacion.add(etiquetas[i], new AbsoluteConstraints(posX[i]+x,posY[i]+y,-1, -1)); 
      }
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
      precioHab += caja.get(i).getHabitacionSeleccionada().getPrecio();
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
    private javax.swing.JLabel jLFondo;
    // End of variables declaration//GEN-END:variables
}
