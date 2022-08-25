package Paneles;

import CRUD.Cliente;
import Conexion.CifrarContrasenia;
import Conexion.SQLCliente;
import Diseño.JButtonRound;
import Diseño.JComboBoxRound;
import Diseño.JLabelTitle;
import Diseño.JPasswordFieldRound;
import Diseño.JTextCalendar;
import Diseño.JTextFieldRound;
import Diseño.UIInforme;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class JPRegistrar extends javax.swing.JPanel {
  SQLCliente registro;
  Cliente cliente;
  UIInforme inf = new UIInforme();
  JTextFieldRound jtNombre, jtCorreo;
  JPasswordFieldRound jtPass;
  CifrarContrasenia cifrado;
  JButtonRound btnRegistro;
  JLabelTitle jLT;
  JTextCalendar calendar;
  JComboBoxRound combo;
  JButton jBRegistro = new JButton();;
  int tamText = 17;
  GregorianCalendar c = new GregorianCalendar(1951, Calendar.JANUARY,01);
  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  Date max = new Date();
  public JPRegistrar() throws ParseException {
    initComponents();
    calendar = new JTextCalendar(jTFecha, c);
    calendar.getCalendar().setMaxSelectableDate(dateFormat.parse("2003-12-31"));
    calendar.getCalendar().setMinSelectableDate(dateFormat.parse("1951-01-01"));
    combo = new JComboBoxRound(jCBPaises);
    jLT = new JLabelTitle("Registrarme", jLTitulo, 30);
    jLT = new JLabelTitle("Nombre", jLNombre, tamText);
    jLT = new JLabelTitle("Correo", jLCorreo, tamText);
    jLT = new JLabelTitle("Contraseña", jLPass,  tamText);
    jLT = new JLabelTitle("País", jLPais, tamText);
    jLT = new JLabelTitle("Fecha Nacimiento", jLFecha, tamText);
    jtNombre = new JTextFieldRound("Ingrese su nombre");
    jtCorreo = new JTextFieldRound("Ingrese un correo");
    jtPass = new JPasswordFieldRound("Password");
    btnRegistro = new JButtonRound(jBRegistro);
    btnRegistro.botonRegistrarAmarillo(jBRegistro);
    registro = new SQLCliente();
    this.add(jLTitulo, new AbsoluteConstraints(10, 20,-1, -1));
    this.add(jLNombre, new AbsoluteConstraints(30, 70,-1, -1));
    this.add(jtNombre, new AbsoluteConstraints(30, 90,-1, -1));
    this.add(jLCorreo, new AbsoluteConstraints(30, 135,-1, -1));
    this.add(jtCorreo, new AbsoluteConstraints(30, 155,-1, -1));
    this.add(jLPass, new AbsoluteConstraints(30, 200,-1, -1));
    this.add(jtPass, new AbsoluteConstraints(30, 220,-1, -1));
    this.add(jLFecha, new AbsoluteConstraints(30, 265,-1, -1));
    this.add(jTFecha, new AbsoluteConstraints(30, 285,-1, -1));
    this.add(jLPais, new AbsoluteConstraints(200, 265,-1, -1));
    this.add(jCBPaises, new AbsoluteConstraints(200, 285,-1, -1));
    jBRegistro.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        super.mouseClicked(me);
        String pass = String.valueOf(jtPass.getPassword());
        Date fecha = new Date();
        if(jtNombre.getText().equals("Ingrese su nombre") || jtNombre.getText().isEmpty() || jCBPaises.getSelectedIndex() == 0 ||
         String.valueOf(jtPass.getPassword()).isEmpty() || String.valueOf(jtPass.getPassword()).equals("P@ssw0rd") ||
         jtCorreo.getText().equals("Ingrese un correo") || jtCorreo.getText().isEmpty() || jTFecha.getText().isEmpty()){
         JOptionPane.showMessageDialog(null, "Ingrese datos validos", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/error.png"))));
        }else{
          fecha =  java.sql.Date.valueOf(jTFecha.getText());
          cliente = new Cliente(jtNombre.getText(),jtCorreo.getText(), cifrado.md5(pass),jCBPaises.getSelectedItem().toString(), (java.sql.Date) fecha);
          try {
            if(registro.verificarUsuario(cliente.getCorreo()) == 0) {
              registro.registrarUsuario(cliente);
              registro.iniciarSesion(cliente);
              JOptionPane.showMessageDialog(null, "Usuario registrado", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/exitoEs.png"))));
            }else{
              JOptionPane.showMessageDialog(null, "Correo ya registrado", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/advertencia.png"))));
              cliente.setIdUsuario(0);
            }
          }catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(JPRegistrar.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
      }
      
});
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public JButton getjBRegistro() {
    return jBRegistro;
  }

  public void setjBRegistro(JButton jBRegistro) {
    this.jBRegistro = jBRegistro;
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jCBPaises = new javax.swing.JComboBox<>();
    jLTitulo = new javax.swing.JLabel();
    jPLinea = new javax.swing.JPanel();
    jLNombre = new javax.swing.JLabel();
    jLCorreo = new javax.swing.JLabel();
    jLPass = new javax.swing.JLabel();
    jLPais = new javax.swing.JLabel();
    jLFecha = new javax.swing.JLabel();
    jTFecha = new javax.swing.JLabel();

    setBackground(new java.awt.Color(147, 171, 169));
    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        formMouseClicked(evt);
      }
    });
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jCBPaises.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Afganistán", "Alemania", "Andorra", "Arabia Saudita", "Argelia", "Argentina", "Armenia", "Australia", "Austria", "Bahamas", "Bélgica", "Bolivia", "Bosnia", "Brasil", "Camerún", "Canadá", "Catar", "Chile", "China", "Colombia", "Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca", "Ecuador", "Egipto", "El Salvador", "Emiratos Árabes Unidos", "Eslovaquia", "Eslovenia", "España", "Estados Unidos", "Estonia", "Etiopía", "Filipinas", "Finlandia", "Francia", "Grecia", "Guatemala", "Haití", "Honduras", "Hungría", "India", "Indonesia", "Irak", "Irán", "Irlanda", "Israel", "Italia", "Jamaica", "Japón", "Luxemburgo", "Madagascar", "Malasia", "Marruecos", "México", "Mónacol", "Nicaragua", "Nigeria", "Noruega", "Nueva Zelanda", "Países Bajos", "Pakistán", "Panamá", "Paraguay", "Perú", "Polonia", "Portugal", "Reino Unido", "República Centroafricana", "República Checa", "República Dominicana", "Rumanía", "Rusia", "Senegal", "Singapur", "Siria", "Sudáfrica", "Sudán", "Sudán del Sur", "Suecia", "Suiza", "Tailandia", "Tanzania", "Turquía", "Ucrania", "Uruguay", "Venezuela", "Vietnam" }));
    add(jCBPaises, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, -1));

    jLTitulo.setText("jLabel1");
    add(jLTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

    jPLinea.setBackground(new java.awt.Color(153, 153, 153));
    add(jPLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 205, 1));

    jLNombre.setText("jLabel2");
    add(jLNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

    jLCorreo.setText("jLabel3");
    add(jLCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

    jLPass.setText("jLabel4");
    add(jLPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

    jLPais.setText("jLabel5");
    add(jLPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, -1, -1));

    jLFecha.setText("jLabel6");
    add(jLFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

    jTFecha.setText("jLabel1");
    add(jTFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));
  }// </editor-fold>//GEN-END:initComponents

  private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    if(String.valueOf(jtPass.getPassword()).isEmpty()){
      jtPass.setText("Password");
      jtPass.setForeground(new Color(63,63,58));
    }

    if(jtCorreo.getText().isEmpty()){
      jtCorreo.setText("Ingrese un correo");
      jtCorreo.setForeground(new Color(81,81,73));
    } 

    if(jtNombre.getText().isEmpty()){
      jtNombre.setText("Ingrese su nombre");
      jtNombre.setForeground(new Color(81,81,73));
    } 
  }//GEN-LAST:event_formMouseClicked


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox<String> jCBPaises;
  private javax.swing.JLabel jLCorreo;
  private javax.swing.JLabel jLFecha;
  private javax.swing.JLabel jLNombre;
  private javax.swing.JLabel jLPais;
  private javax.swing.JLabel jLPass;
  private javax.swing.JLabel jLTitulo;
  private javax.swing.JPanel jPLinea;
  private javax.swing.JLabel jTFecha;
  // End of variables declaration//GEN-END:variables
}
