package Paneles;

import CRUD.Cliente;
import Conexion.CifrarContrasenia;
import Conexion.SQLCliente;
import Diseño.JButtonRound;
import Diseño.JLabelTitle;
import Diseño.JPasswordFieldRound;
import Diseño.JTextFieldRound;
import Diseño.UIInforme;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class JPIniciarSesion extends javax.swing.JPanel {
  SQLCliente inicio;
  Cliente cliente;
  JButtonRound btninicio;
  CifrarContrasenia cifrado;
  JTextFieldRound jTCorreo;
  JPasswordFieldRound jtPass;
  JLabelTitle jLT;
  JButton JBInicio;
  UIInforme ui = new UIInforme();
  int tamText = 20;
  public JPIniciarSesion() {
    initComponents();
    jTCorreo = new JTextFieldRound("Ingrese su correo");
    jLT = new JLabelTitle("Iniciar en Moon", jLEncabezado, 30);
    jLT = new JLabelTitle("Correo",jLCorreo, tamText);
    jLT = new JLabelTitle("Contraseña", jLPass, tamText);
    JBInicio = new JButton();
    btninicio = new JButtonRound(JBInicio);
    btninicio.botonInicioAmarillo(JBInicio);
    jtPass = new JPasswordFieldRound("Password");
    inicio = new SQLCliente();
    this.add(jLEncabezado, new AbsoluteConstraints(10, 70,-1, -1));
    this.add(jLCorreo, new AbsoluteConstraints(30, 120,-1, -1));
    this.add(jTCorreo, new AbsoluteConstraints(30, 145,-1, -1));
    this.add(jLPass, new AbsoluteConstraints(30, 195,-1, -1));
    this.add(jtPass, new AbsoluteConstraints(30, 220,-1, -1));
    JBInicio.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        super.mouseClicked(me);
        String pass = String.valueOf(jtPass.getPassword());
          cliente = new Cliente(jTCorreo.getText(), cifrado.md5(pass));
          try {
          if(inicio.iniciarSesion(cliente)){
              JOptionPane.showMessageDialog(null, "Inicio de sesión correcto", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/listo.png"))));
            }else{
              JOptionPane.showMessageDialog(null, "Correo o contraseñas incorrectos", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/error.png"))));
          }
          } catch (SQLException | ClassNotFoundException ex) {
          Logger.getLogger(JPIniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    });
  }

  public JButton getJBInicio() {
    return JBInicio;
  }

  public void setJBInicio(JButton JBInicio) {
    this.JBInicio = JBInicio;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLEncabezado = new javax.swing.JLabel();
    jPLinea = new javax.swing.JPanel();
    jLCorreo = new javax.swing.JLabel();
    jLPass = new javax.swing.JLabel();

    setBackground(new java.awt.Color(147, 171, 169));
    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        formMouseClicked(evt);
      }
    });
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLEncabezado.setFont(new java.awt.Font("Roboto Medium", 0, 30)); // NOI18N
    jLEncabezado.setForeground(new java.awt.Color(11, 31, 76));
    jLEncabezado.setText("Iniciar en Moon");
    add(jLEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

    jPLinea.setBackground(new java.awt.Color(153, 153, 153));
    add(jPLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 205, 1));

    jLCorreo.setText("jLabel1");
    add(jLCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

    jLPass.setText("jLabel2");
    add(jLPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));
  }// </editor-fold>//GEN-END:initComponents

  private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    if(String.valueOf(jtPass.getPassword()).isEmpty()){
      jtPass.setText("Password");
      jtPass.setForeground(new Color(63,63,58));
    }
    
    if(jTCorreo.getText().isEmpty()){
      jTCorreo.setText("Ingrese su correo");
      jTCorreo.setForeground(new Color(81,81,73));
    }
  }//GEN-LAST:event_formMouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLCorreo;
  private javax.swing.JLabel jLEncabezado;
  private javax.swing.JLabel jLPass;
  private javax.swing.JPanel jPLinea;
  // End of variables declaration//GEN-END:variables
}
