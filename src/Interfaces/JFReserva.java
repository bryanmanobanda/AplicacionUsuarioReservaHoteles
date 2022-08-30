package Interfaces;

import CRUD.Cliente;
import CRUD.Reserva;
import Conexion.CifrarContrasenia;
import Conexion.SQLCliente;
import Conexion.SQLHabitacion_Reserva;
import Conexion.SQLReserva;
import Diseño.CajaReserva;
import Diseño.JButtonRound;
import Diseño.JLabelTitle;
import Diseño.JTextFieldRound;
import Diseño.ListaReservas;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class JFReserva extends javax.swing.JFrame{
    int respuesta, xMouse, yMouse, tamText = 20, x =20, y = 10 ;
    Cliente cliente;
    CajaReserva reservaSel;
    CifrarContrasenia cifrado;
    ListaReservas listaReserva1;
    JButtonRound boton;
    JLabelTitle titulo;
    Reserva reservaEliminar;
    ArrayList<Reserva> listaReserva;
    JTextFieldRound tnombre, tcorreo, tpais, tfechaNac;
    Dimension dimensionCuadro = new Dimension(210, 25);
    SQLReserva conexReserva = new SQLReserva();
    SQLHabitacion_Reserva conexHabitacionReserva = new SQLHabitacion_Reserva();
    SQLCliente conexCliente = new SQLCliente();
  public JFReserva() throws ParseException, ClassNotFoundException, SQLException {
    initComponents();
    titulo = new JLabelTitle("Nombre", nombre, tamText);
    titulo = new JLabelTitle("Correo", correo, tamText);
    titulo = new JLabelTitle("País", pais, tamText);
    titulo = new JLabelTitle("Fecha Nacimiento", fechaNac, tamText);
    boton = new JButtonRound(jBCambiarPassword);
    tnombre = new JTextFieldRound("");
    tcorreo = new JTextFieldRound("");
    tpais = new JTextFieldRound("");
    tfechaNac = new JTextFieldRound("");
    tnombre.setEnabled(false);
    tcorreo.setEnabled(false);
    tpais.setEnabled(false);
    tfechaNac.setEnabled(false);
    tnombre.setPreferredSize(dimensionCuadro);
    tcorreo.setPreferredSize(dimensionCuadro);
    tpais.setPreferredSize(dimensionCuadro);
    tfechaNac.setPreferredSize(dimensionCuadro);
    boton.modificarContrasenia(jBCambiarPassword);
    jPLateral.add(nombre, new AbsoluteConstraints(x, 200 + y,-1, -1));
    jPLateral.add(tnombre, new AbsoluteConstraints(x, 225 + y,-1, -1));
    jPLateral.add(correo, new AbsoluteConstraints(x, 255 + y,-1, -1));
    jPLateral.add(tcorreo, new AbsoluteConstraints(x, 280 + y,-1, -1));
    jPLateral.add(pais, new AbsoluteConstraints(x, 310 + y,-1, -1));
    jPLateral.add(tpais, new AbsoluteConstraints(x, 335 + y,-1, -1));
    jPLateral.add(fechaNac, new AbsoluteConstraints(x, 365 + y,-1, -1));
    jPLateral.add(tfechaNac, new AbsoluteConstraints(x, 390 + y,-1, -1));
    jPLateral.add(jBCambiarPassword, new AbsoluteConstraints(x+40, 420 + y,-1, -1));
    listaReserva1 = new ListaReservas();
    jPEntorno.add(listaReserva1, BorderLayout.CENTER);
    jPEntorno.validate();
    this.setResizable(false);
    this.setLocationRelativeTo(null);
  }
  
  public void agregarReservas( ) throws ClassNotFoundException, SQLException{
    listaReserva = conexReserva.busquedaReservasPorCliente(cliente);
    for (int i = 0; i < listaReserva.size(); i++){
      reservaSel = new CajaReserva(listaReserva.get(i)){
        @Override
        public void mouseClicked(MouseEvent me) {
            respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la reserva?","",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE,new ImageIcon((getClass().getResource("/Assets/Dialogo/advertencia.png"))));
            if(respuesta == 0 ){
                super.mouseClicked(me);
                try {
                    reservaEliminar = super.getreservaSelec();
                    conexHabitacionReserva.eliminarHabitacionReserva(reservaEliminar);
                    conexReserva.eliminarReserva(reservaEliminar);
                    listaReserva1.limpiar();
                    agregarReservas();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(JFReserva.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Reservada eliminada", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/exitoEs.png"))));
            }
        }
      };
      listaReserva1.arreglo(reservaSel);
    }
    jPEntorno.validate();
  }
  
  public void ingreso(Cliente clienteConect){
    cliente = clienteConect;
    tnombre.setText(cliente.getNombre());
    tcorreo.setText(cliente.getCorreo());
    tpais.setText(cliente.getPais());
    tfechaNac.setText(cliente.getFechaNacimiento().toString());
  }
  
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPEntorno = new javax.swing.JPanel();
        jPLateral = new javax.swing.JPanel();
        jBLogo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        correo = new javax.swing.JLabel();
        fechaNac = new javax.swing.JLabel();
        pais = new javax.swing.JLabel();
        jBCambiarPassword = new javax.swing.JButton();
        jPBarra = new javax.swing.JPanel();
        jlCerrar = new javax.swing.JLabel();
        jPCerrar = new javax.swing.JPanel();
        jPEncabezado = new javax.swing.JPanel();
        jLEncabezado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(147, 171, 169));
        setMinimumSize(new java.awt.Dimension(629, 481));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPEntorno.setPreferredSize(new java.awt.Dimension(390, 417));
        jPEntorno.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPEntorno, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 64, 389, 417));

        jPLateral.setBackground(new java.awt.Color(252, 195, 95));
        jPLateral.setMinimumSize(new java.awt.Dimension(199, 200));
        jPLateral.setPreferredSize(new java.awt.Dimension(199, 200));
        jPLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Logo/logoAdmin.png"))); // NOI18N
        jBLogo.setBorderPainted(false);
        jBLogo.setContentAreaFilled(false);
        jBLogo.setFocusPainted(false);
        jPLateral.add(jBLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Dialogo/Usuarioper.png"))); // NOI18N
        jPLateral.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 107, 83));

        nombre.setText("jLabel2");
        jPLateral.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        correo.setText("jLabel3");
        jPLateral.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        fechaNac.setText("jLabel4");
        jPLateral.add(fechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        pais.setText("jLabel4");
        jPLateral.add(pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jBCambiarPassword.setText("jButton1");
        jBCambiarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCambiarPasswordActionPerformed(evt);
            }
        });
        jPLateral.add(jBCambiarPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));

        getContentPane().add(jPLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 24, 240, 457));

        jPBarra.setBackground(new java.awt.Color(255, 255, 255));
        jPBarra.setMinimumSize(new java.awt.Dimension(630, 24));
        jPBarra.setPreferredSize(new java.awt.Dimension(630, 24));
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

        jlCerrar.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jlCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCerrar.setText("X");
        jlCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPBarra.add(jlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 30, 24));

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
        jPBarra.add(jPCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 30, 24));

        getContentPane().add(jPBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 629, 24));

        jPEncabezado.setBackground(new java.awt.Color(147, 171, 169));
        jPEncabezado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLEncabezado.setFont(new java.awt.Font("Roboto Medium", 0, 30)); // NOI18N
        jLEncabezado.setForeground(new java.awt.Color(11, 31, 76));
        jLEncabezado.setText("Mis Reservas");
        jPEncabezado.add(jLEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        getContentPane().add(jPEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 24, 389, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void jPBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPBarraMousePressed
    xMouse = evt.getX();
    yMouse = evt.getY();
  }//GEN-LAST:event_jPBarraMousePressed

  private void jPBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPBarraMouseDragged
    int x = evt.getXOnScreen();
    int y = evt.getYOnScreen();
    this.setLocation(x - xMouse, y - yMouse );
  }//GEN-LAST:event_jPBarraMouseDragged

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

    private void jBCambiarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCambiarPasswordActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea cambiar la contraseña?","",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE,new ImageIcon((getClass().getResource("/Assets/Dialogo/advertencia.png"))));
        Object anteriorO;
        String anterior;
        if(resp == 0 ){
            while(true){
                anteriorO = JOptionPane.showInputDialog(null, "Ingrese la contraseña anterior", "", JOptionPane.QUESTION_MESSAGE,new ImageIcon((getClass().getResource("/Assets/Dialogo/advertencia.png"))),null,DISPOSE_ON_CLOSE);
                if(anteriorO != null){
                    anterior = (String) anteriorO;
                    if(cliente.getContrasenia().equals(cifrado.md5(anterior))){
                        anteriorO = JOptionPane.showInputDialog(null, "Ingrese la contraseña nueva", "", JOptionPane.ERROR_MESSAGE,new ImageIcon((getClass().getResource("/Assets/Dialogo/advertencia.png"))),null,DISPOSE_ON_CLOSE);
                        if(anteriorO != null){
                            String nueva = (String)  anteriorO;
                            cliente.setContrasenia(cifrado.md5(nueva));
                            try {
                                conexCliente.modificarContrasenia(cliente);
                            } catch (SQLException | ClassNotFoundException ex) {
                                Logger.getLogger(JFReserva.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            JOptionPane.showMessageDialog(null, "Contraseña cambiada exitosamente", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/listo.png"))));
                            break;
                        }else{
                            JOptionPane.showMessageDialog(null, "Contraseña no cambiada", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/error.png"))));
                            break;
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Contraseña ingresada no valida", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/error.png"))));
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Contraseña no cambiada", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/error.png"))));
                    break;
                }
            }
        }
    }//GEN-LAST:event_jBCambiarPasswordActionPerformed

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
      java.util.logging.Logger.getLogger(JFReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(JFReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(JFReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(JFReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          new JFReserva().setVisible(true);
        } catch (ParseException | ClassNotFoundException | SQLException ex) {
          Logger.getLogger(JFReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel correo;
    private javax.swing.JLabel fechaNac;
    private javax.swing.JButton jBCambiarPassword;
    private javax.swing.JButton jBLogo;
    private javax.swing.JLabel jLEncabezado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPBarra;
    private javax.swing.JPanel jPCerrar;
    private javax.swing.JPanel jPEncabezado;
    private javax.swing.JPanel jPEntorno;
    private javax.swing.JPanel jPLateral;
    private javax.swing.JLabel jlCerrar;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel pais;
    // End of variables declaration//GEN-END:variables
}