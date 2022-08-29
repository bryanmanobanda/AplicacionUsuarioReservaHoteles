package Interfaces;

import CRUD.Cliente;
import CRUD.Habitacion;
import CRUD.Hotel;
import CRUD.Reserva;
//import Conexion.ConexionBaseDatos;
import Conexion.SQLHabitacion;
import Conexion.SQLHabitacion_Reserva;
import Conexion.SQLHotel;
import Conexion.SQLReserva;
import Diseño.CajaHabitacion;
import Diseño.CajaHotel;
import Diseño.JButtonRound;
import Diseño.ListaHabitaciones;
import Diseño.ListaHoteles;
import Diseño.UIInforme;
import Paneles.JPIniciarSesion;
import Paneles.JPRegistrar;
import Paneles.JPReserva;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
///import java.sql.Connection;
import java.sql.Date;
//import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class PaginaPrincipal extends javax.swing.JFrame {
  ListaHoteles lista;
  ListaHabitaciones listaHab;
  JButton logo;
  int xMouse, yMouse, numeroHabitacion = 0,  c = -1;
  JButtonRound boton;
  JFAcceso acceso;
  JFReserva jfreservas;
  JPIniciarSesion inicio;
  JPRegistrar registro;
  Hotel hotelesc;
  Habitacion hab;
  JPReserva jpreserva;
  SQLHabitacion_Reserva habitacionRes = new SQLHabitacion_Reserva();
  CajaHotel hotelsel;
  CajaHabitacion cajaHab;
  SQLHotel conexHotel = new SQLHotel();
  UIInforme ui = new UIInforme();
  SQLHabitacion conexHabitacion = new SQLHabitacion();
  ArrayList<Hotel> listahotel;
  ArrayList<Reserva> listareserva = new ArrayList<>();
  String [] paises;
  ArrayList<Habitacion> listahabitacion, habitacionSelect;
  ArrayList<CajaHabitacion>habitacionreserva;
  JButton cont = new JButton();
  JButton iniciar = new JButton();
  JButton registrar = new JButton();
  JButton reservar = new JButton();
  JButton cerrarSesion = new JButton();
  JButton misReservas = new JButton();
  JButton atras = new JButton();
  SQLReserva reservarConex = new SQLReserva();
  Reserva reserva;
  Cliente cliente;
  public PaginaPrincipal() throws ClassNotFoundException, SQLException, ParseException {
    initComponents();
    setLocationRelativeTo(null);
    habitacionSelect = new ArrayList<>();
    boton = new JButtonRound(cont);
    logo = new JButton(new ImageIcon(getClass().getResource("/Assets/Logo/logo.png")));
    registro = new JPRegistrar();
    jpreserva = new JPReserva();
    lista = new ListaHoteles();
    inicio = new JPIniciarSesion();
    iniciar = inicio.getJBInicio();
    registrar = registro.getjBRegistro();
    habitacionreserva = new ArrayList<>();
    boton = new JButtonRound(reservar);
    boton = new JButtonRound(jbRegistrar);
    boton = new JButtonRound(JbIniciar);
    boton = new JButtonRound(cerrarSesion);
    boton = new JButtonRound(misReservas);
    boton = new JButtonRound(atras);
    this.setMinimumSize(new Dimension(1000,600));
    jPBarra.setPreferredSize(new Dimension(1000, 24));
    encabezado.setLayout(new AbsoluteLayout());
    encabezado.setBackground(new Color(252,195,95));
    boton.botonCerrar(cerrarSesion);
    boton.botonCerrar(misReservas);
    boton.botonReserva(reservar);
    boton.botonAtras(atras);
    boton.botonInicioAmarillo(JbIniciar);
    boton.botonRegistrarAzul(jbRegistrar);
    logo.setBorder(null);
    logo.setContentAreaFilled(false);
    encabezado.add(logo, new AbsoluteConstraints(15, 10, -1, -1));
    encabezado.add(jbRegistrar, new AbsoluteConstraints(800, 20, -1, -1));
    encabezado.add(JbIniciar, new AbsoluteConstraints(900, 20, -1, -1));
    contenido.add(lista, BorderLayout.CENTER);
    paises = conexHotel.busquedaPaises();
    cerrarSesion.setVisible(false);
    misReservas.setVisible(false);
    iniciar.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        super.mouseClicked(me);
        cliente = inicio.getCliente();
        if(cliente.getIdUsuario() != 0){
          acceso.dispose();
          jbRegistrar.setVisible(false);
          JbIniciar.setVisible(false);
          cerrarSesion.setVisible(true);
          misReservas.setVisible(true);
        }
      }
    });

    registrar.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        super.mouseClicked(me);
        if(registro.getCliente() != null && registro.getCliente().getIdUsuario() != 0 ){
          cliente = registro.getCliente();
          cerrarSesion.setVisible(true);
          misReservas.setVisible(true);
          acceso.dispose();
          jbRegistrar.setVisible(false);
          JbIniciar.setVisible(false);
          encabezado.validate();
        }
      }
    });
    
    reservar.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        super.mouseClicked(me);
        if(jpreserva.jDateFinal.getText().compareTo(jpreserva.jDateInicio.getText()) == 0 || jpreserva.jDateFinal.getText().compareTo(jpreserva.jDateInicio.getText()) == -1 || jpreserva.jDateFinal.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Escoja fechas validas", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/error.png"))));
        }else{
        for(int i = 0; i< habitacionreserva.size(); i++){
          habitacionSelect.add(habitacionreserva.get(i).getHabitacionselec());
        }
        reserva = new Reserva(hotelesc.getContinente(),cliente.getIdUsuario(),Date.valueOf(jpreserva.jDateInicio.getText()), Date.valueOf(jpreserva.jDateFinal.getText()), habitacionSelect,jpreserva.precioHab);
        reserva.cambiarEstado();
          for(int i = 0; i< habitacionSelect.size(); i++){
          try {
            conexHabitacion.modificarHabitacion(habitacionSelect.get(i));
          } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        try {
          reservarConex.insertarReserva(reserva);
          listareserva = reservarConex.buscarTopReserva(cliente);
          for(int i = 0; i< habitacionSelect.size(); i++){
            habitacionRes.insertarHabitacionReserva(habitacionSelect.get(i), listareserva.get(0));
          }
          JOptionPane.showMessageDialog(null, "Reserva realizada exitosamente", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/viajeEs.png"))));
        } catch (SQLException | ClassNotFoundException ex) {
          Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        contenido.add(lista, BorderLayout.CENTER);
        jpreserva.Informacion.setVisible(false);
        jpreserva.Habitacion.setVisible(false);
        jpreserva.setVisible(false);
        limpiar();
        try {
          agregarHotel();
        } catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
      }}
    });
    
    cerrarSesion.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        super.mouseClicked(me);
        JOptionPane.showMessageDialog(null, "Se ha cerrado la sesión", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/listo.png"))));
        jbRegistrar.setVisible(true);
        JbIniciar.setVisible(true);
        cerrarSesion.setVisible(false);
        misReservas.setVisible(false);
        cliente.setIdUsuario(0);
        limpiar();
        try {
          agregarHotel();
        } catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
});
    
    misReservas.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        super.mouseClicked(me);
        
        try {
        jfreservas = new JFReserva(){
          @Override
          public void dispose(){
            getFrame().setVisible(true);
            super.dispose();
          }
        };
          //inicio.add(iniciar,  new AbsoluteConstraints(30, 270, -1, -1));
          //registro.add(registrar, new AbsoluteConstraints(30, 330, -1, -1));
          //jfreservas.habilitarPanel(inicio, registro, "Registrar");
          jfreservas.ingreso(cliente);
          jfreservas.agregarReservas();
          jfreservas.setVisible(true);
          
          dispose();
         } catch (ParseException | SQLException | ClassNotFoundException ex) {
        Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
});    
    logo.setCursor(new Cursor(Cursor.HAND_CURSOR));
    logo.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        super.mouseClicked(me);
        limpiar();
        try {
          agregarHotel();
        } catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
});
    
    atras.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        super.mouseClicked(me);
        if(listaHab.isVisible()){
        limpiar();
        try {
          agregarHotel();
        } catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      if(jpreserva.isVisible()){
        jpreserva.Informacion.setVisible(false);
        jpreserva.Habitacion.setVisible(false);
        jpreserva.setVisible(false);
        contenido.add(listaHab, BorderLayout.CENTER);
        listaHab.setVisible(true);
        listaHab.panel.setVisible(true);
        listaHab.getPie().add(atras, new AbsoluteConstraints(800, 14, -1,-1));
        listaHab.pie.setVisible(true);
        listaHab.busque.setVisible(true);
        contenido.validate();
      }
    }
});
    encabezado.add(cerrarSesion, new AbsoluteConstraints(890, 20, -1, -1));
    encabezado.add(misReservas, new AbsoluteConstraints(750, 20, -1, -1));
    agregarHotel();
  }
    
  public void agregarHotel( ) throws ClassNotFoundException, SQLException{
    listaHab = new ListaHabitaciones();
    listahotel = conexHotel.busqueda();
    for (int i = 0; i < listahotel.size(); i++){
      hotelsel = new CajaHotel(listahotel.get(i)){
        @Override
        public void mouseClicked(MouseEvent me) {
          if(cliente != null && cliente.getIdUsuario() != 0){
          super.mouseClicked(me);
          try {
            hotelesc = super.getHotelSelec();
            listahabitacion = conexHabitacion.busquedaPorHotel(hotelesc);
            agregarHabitacion();
            contenido.add(listaHab, BorderLayout.CENTER);
            listaHab.setVisible(true);
            listaHab.panel.setVisible(true);
            listaHab.pie.setVisible(true);
            listaHab.busque.setVisible(true);
            lista.setVisible(false);
            contenido.validate();
          } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          }
          }else{
            JOptionPane.showMessageDialog(null, "Registre o inicie sesión", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/advertencia.png"))));
          }
        }
      };
      lista.arreglo(hotelsel);
    }
    lista.pais(paises);
    lista.setVisible(true);
    contenido.validate();
  }
  
  public void agregarHabitacion() throws ClassNotFoundException, SQLException{
    boton.botonContinuar(cont);
    cont.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae){
        if(habitacionreserva.size() != 0){
          jpreserva.Informacion.add(reservar,new AbsoluteConstraints(400, 370,-1, -1));
          contenido.add(jpreserva, BorderLayout.CENTER);
          jpreserva.getInformacion().add(atras, new AbsoluteConstraints(280, 370,-1,-1));
          jpreserva.setVisible(true);
          jpreserva.getHabitacion().setVisible(true);
          jpreserva.getInformacion().setVisible(true);
          listaHab.panel.setVisible(false);
          listaHab.pie.setVisible(false);
          listaHab.busque.setVisible(false);
          listaHab.setVisible(false);
          lista.setVisible(false);
          try {
            jpreserva.listarHabitaciones(habitacionreserva, hotelesc.getNombre(), cliente.getNombre(), cliente.getPais());
          } catch (ParseException ex) {
            Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          }
          contenido.validate();
        }else{
          JOptionPane.showMessageDialog(null, "Seleccione una o mas habitaciones", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/error.png"))));
        }
      }
    });
    for (int i = 0; i < listahabitacion.size(); i++){
      cajaHab = new CajaHabitacion(listahabitacion.get(i)){
        @Override
        public void mouseClicked(MouseEvent me) {
          super.mouseClicked(me);
          if(super.isFocusable()){
            super.setFocusable(false);
            super.setBackground(new Color(153, 77, 60));
            listaHab.setTitulo("Habitaciones: " + ++numeroHabitacion);
            habitacionreserva.add(super.getCaja());
          }else{
            super.setFocusable(true);
            listaHab.setTitulo("Habitaciones: " + --numeroHabitacion);
            habitacionreserva.remove(super.getCaja());
          }
        }
      };
      listaHab.arreglo(cajaHab);
    }
    listaHab.setTitulo("Habitaciones: " + numeroHabitacion);
    listaHab.getPie().add(cont, new AbsoluteConstraints(900, 14, -1,-1));
    listaHab.getPie().add(atras, new AbsoluteConstraints(800, 14, -1,-1));
  }
  
  private JFrame getFrame(){
    return this;
  }
  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPBarra = new javax.swing.JPanel();
    jPCerrar = new javax.swing.JPanel();
    jlCerrar = new javax.swing.JLabel();
    encabezado = new javax.swing.JPanel();
    JbIniciar = new javax.swing.JButton();
    jbRegistrar = new javax.swing.JButton();
    contenido = new javax.swing.JPanel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setUndecorated(true);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPBarra.setBackground(new java.awt.Color(255, 255, 255));
    jPBarra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
      public void mouseDragged(java.awt.event.MouseEvent evt) {
        jPBarraMouseDragged(evt);
      }
    });
    jPBarra.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mousePressed(java.awt.event.MouseEvent evt) {
        jPBarraMousePressed(evt);
      }
    });
    jPBarra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPCerrar.setBackground(new java.awt.Color(255, 255, 255));
    jPCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jPCerrarMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jPCerrarMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        jPCerrarMouseExited(evt);
      }
    });
    jPCerrar.setLayout(new java.awt.BorderLayout());

    jlCerrar.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
    jlCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jlCerrar.setText("X");
    jlCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jPCerrar.add(jlCerrar, java.awt.BorderLayout.CENTER);

    jPBarra.add(jPCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 30, 24));

    getContentPane().add(jPBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

    encabezado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    JbIniciar.setText("jButton1");
    JbIniciar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        JbIniciarActionPerformed(evt);
      }
    });
    encabezado.add(JbIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, -1, -1));

    jbRegistrar.setText("jButton2");
    jbRegistrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbRegistrarActionPerformed(evt);
      }
    });
    encabezado.add(jbRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

    getContentPane().add(encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 24, 1000, 60));

    contenido.setLayout(new java.awt.BorderLayout());
    getContentPane().add(contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 84, 1000, 516));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jPCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPCerrarMouseClicked
    dispose();
  }//GEN-LAST:event_jPCerrarMouseClicked

  private void jPCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPCerrarMouseEntered
    jPCerrar.setBackground(new Color(219, 67, 57));
    jlCerrar.setForeground(Color.white);
  }//GEN-LAST:event_jPCerrarMouseEntered

  private void jPCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPCerrarMouseExited
    jPCerrar.setBackground(Color.white);
    jlCerrar.setForeground(Color.black);
  }//GEN-LAST:event_jPCerrarMouseExited

  private void jPBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPBarraMouseDragged
    int x = evt.getXOnScreen();
    int y = evt.getYOnScreen();
    this.setLocation(x - xMouse, y - yMouse );

  }//GEN-LAST:event_jPBarraMouseDragged

  private void jPBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPBarraMousePressed
    xMouse = evt.getX();
    yMouse = evt.getY();
  }//GEN-LAST:event_jPBarraMousePressed

  private void jbRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarActionPerformed
    try {
      acceso = new JFAcceso(){
        @Override
        public void dispose(){
          getFrame().setVisible(true);
          super.dispose();
        }
      };
        inicio.add(iniciar,  new AbsoluteConstraints(30, 270, -1, -1));
        registro.add(registrar, new AbsoluteConstraints(30, 330, -1, -1));
        acceso.habilitarPanel(inicio, registro, "Registrar");
        acceso.setVisible(true);
        dispose();
       } catch (ParseException ex) {
      Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
  }//GEN-LAST:event_jbRegistrarActionPerformed

  private void JbIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbIniciarActionPerformed
    try {
      acceso = new JFAcceso(){
      @Override
      public void dispose(){
        getFrame().setVisible(true);
        super.dispose();
      }
    };
      inicio.add(iniciar,  new AbsoluteConstraints(30, 270, -1, -1));
      registro.add(registrar, new AbsoluteConstraints(30, 330, -1, -1));
        acceso.habilitarPanel(inicio, registro, "Inicio");
        acceso.setVisible(true);
        dispose();
    } catch (ParseException ex) {
      Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_JbIniciarActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          new PaginaPrincipal().setVisible(true);
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
          Logger.getLogger(PaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton JbIniciar;
  private javax.swing.JPanel contenido;
  private javax.swing.JPanel encabezado;
  private javax.swing.JPanel jPBarra;
  private javax.swing.JPanel jPCerrar;
  private javax.swing.JButton jbRegistrar;
  private javax.swing.JLabel jlCerrar;
  // End of variables declaration//GEN-END:variables
  public void limpiar(){
    habitacionreserva.clear();
    listahotel.clear();
    lista.limpiar();
    listareserva.clear();
    habitacionSelect.clear();
    numeroHabitacion = 0;
    jpreserva.limpieza();
    numeroHabitacion = 0;
    listaHab.limpiar();
    listaHab.panel.setVisible(false);
    listaHab.pie.setVisible(false);
    listaHab.busque.setVisible(false);
    listaHab.setVisible(false);
    jpreserva.setVisible(false);
    jpreserva.Habitacion.setVisible(false);
    jpreserva.Informacion.setVisible(false);
    listaHab.updateUI();
    contenido.validate();
  }
}
