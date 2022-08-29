package Interfaces;

import Diseño.JButtonRound;
import Paneles.JPIniciarSesion;
import Paneles.JPRegistrar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JFAcceso extends javax.swing.JFrame implements  ActionListener{
  JPIniciarSesion inicio;
  JPRegistrar registro;
  JButtonRound uiBoton;
  int xMouse, yMouse;
  public JFAcceso() throws ParseException {
    initComponents();
    uiBoton = new JButtonRound(jBRegistro);
    uiBoton.botonRegistrarAmarillo(jBRegistro);
    uiBoton = new JButtonRound(jBInicio);
    uiBoton.botonInicioAmarillo(jBInicio);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
  }
  
  private void deshabilitarBoton(){
    if(inicio.isVisible()){
      jBInicio.setEnabled(false);
      jBRegistro.setEnabled(true);
    }else if(registro.isVisible()){
      jBRegistro.setEnabled(false);
      jBInicio.setEnabled(true);
    }
  }
  
  public void habilitarPanel(JPIniciarSesion inicio1, JPRegistrar registro1, String nombre){
    inicio = inicio1;
    registro = registro1;
    if("Inicio".equals(nombre)){
      jPEntorno.add(inicio);
      inicio.setVisible(true);
      registro.setVisible(false);
      deshabilitarBoton();
    }else{
      jPEntorno.add(registro);
      inicio.setVisible(false);
      registro.setVisible(true);
      deshabilitarBoton();
    }
    jBRegistro.addActionListener(this);
    jBInicio.addActionListener(this);
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPEntorno = new javax.swing.JPanel();
        jPLateral = new javax.swing.JPanel();
        jBLogo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPEncabezado = new javax.swing.JPanel();
        jBInicio = new javax.swing.JButton();
        jBRegistro = new javax.swing.JButton();
        jPBarra = new javax.swing.JPanel();
        jPCerrar = new javax.swing.JPanel();
        jlCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(147, 171, 169));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPEntorno.setPreferredSize(new java.awt.Dimension(390, 417));
        jPEntorno.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPEntorno, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 64, 389, 417));

        jPLateral.setBackground(new java.awt.Color(252, 195, 95));
        jPLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Logo/logoAcceso.png"))); // NOI18N
        jBLogo.setBorderPainted(false);
        jBLogo.setContentAreaFilled(false);
        jBLogo.setFocusPainted(false);
        jPLateral.add(jBLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Logo/eslogan.png"))); // NOI18N
        jPLateral.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        getContentPane().add(jPLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 24, 240, 457));

        jPEncabezado.setBackground(new java.awt.Color(147, 171, 169));
        jPEncabezado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBInicio.setBackground(new java.awt.Color(147, 171, 169));
        jBInicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBInicio.setForeground(new java.awt.Color(11, 31, 76));
        jBInicio.setText("Iniciar Sesión");
        jPEncabezado.add(jBInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jBRegistro.setText("Registrarse");
        jBRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPEncabezado.add(jBRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        getContentPane().add(jPEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 24, 389, 40));

        jPBarra.setBackground(new java.awt.Color(255, 255, 255));
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

        jPBarra.add(jPCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 30, 24));

        getContentPane().add(jPBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 629, 24));

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
      java.util.logging.Logger.getLogger(JFAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(JFAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(JFAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(JFAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          new JFAcceso().setVisible(true);
        } catch (ParseException ex) {
          Logger.getLogger(JFAcceso.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBInicio;
    private javax.swing.JButton jBLogo;
    private javax.swing.JButton jBRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPBarra;
    private javax.swing.JPanel jPCerrar;
    private javax.swing.JPanel jPEncabezado;
    private javax.swing.JPanel jPEntorno;
    private javax.swing.JPanel jPLateral;
    private javax.swing.JLabel jlCerrar;
    // End of variables declaration//GEN-END:variables

  @Override
  public void actionPerformed(ActionEvent ae) {
    Object evt = ae.getSource();
    if(evt.equals(jBInicio)){
      registro.setVisible(false);
      inicio.setVisible(true);
      jPEntorno.add(inicio);
      jPEntorno.validate();
      deshabilitarBoton();
    }
    
    if(evt.equals(jBRegistro)){
      registro.setVisible(true);
      inicio.setVisible(false);
      jPEntorno.add(registro);
      jPEntorno.validate();
      deshabilitarBoton();
    }
  }
}
