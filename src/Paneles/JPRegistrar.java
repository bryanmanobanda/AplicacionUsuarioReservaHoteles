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
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class JPRegistrar extends javax.swing.JPanel {
  SQLCliente registro;
  Cliente cliente;
  JTextFieldRound jtNombre, jtCorreo;
  JPasswordFieldRound jtPass;
  JButtonRound btnRegistro;
  JTextCalendar calendar;
  JButton jBRegistro = new JButton();
  int tamText = 17;
  GregorianCalendar c = new GregorianCalendar(1951, Calendar.JANUARY, 1);
  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  JLabelTitle jLTitulo, jLNombre, jLCorreo, jLPass, jLPais, jLFecha;
  
public JPRegistrar() throws ParseException {
    initComponents();
    inicializarElementos();
    agregarElementosRegistrar();
    btnRegistro.botonRegistrarAmarillo(jBRegistro);
    calendar.getCalendar().setMaxSelectableDate(dateFormat.parse("2003-12-31"));
    calendar.getCalendar().setMinSelectableDate(dateFormat.parse("1951-01-01"));
    
    jBRegistro.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent me) {
        super.mouseClicked(me);
        String pass = String.valueOf(jtPass.getPassword());
        java.sql.Date fecha;
        if(entradaDatosErroneo()){
            JOptionPane.showMessageDialog(null, "Ingrese datos validos", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Dialogo/error.png")))));
        }else{
            fecha =  java.sql.Date.valueOf(jTFecha.getText());
            cliente = new Cliente(jtNombre.getText(),jtCorreo.getText(), CifrarContrasenia.md5(pass), Objects.requireNonNull(jCBPaises.getSelectedItem()).toString(), fecha);
            try {
                validarCorreo();
            }catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(JPRegistrar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    });
}
  
  public final void inicializarElementos(){
    calendar = new JTextCalendar(jTFecha, c);
    new JComboBoxRound(jCBPaises); //No borrar xq da formato al combo
    jLTitulo= new JLabelTitle("Registrarme",  30);
    jLNombre = new JLabelTitle("Nombre",  tamText);
    jLCorreo = new JLabelTitle("Correo", tamText);
    jLPass = new JLabelTitle("Contraseña", tamText);
    jLPais = new JLabelTitle("País", tamText);
    jLFecha = new JLabelTitle("Fecha Nacimiento", tamText);
    jtNombre = new JTextFieldRound("Ingrese su nombre");
    jtCorreo = new JTextFieldRound("Ingrese un correo");
    jtPass = new JPasswordFieldRound("Password");
    btnRegistro = new JButtonRound(jBRegistro);
    registro = new SQLCliente();
    
  }
  
  public final void agregarElementosRegistrar(){
      /*this.add(jLTitulo, new AbsoluteConstraints(10, 20,-1, -1));
    this.add(jLNombre, new AbsoluteConstraints(30, 70,-1, -1));
    this.add(jtNombre, new AbsoluteConstraints(30, 90,-1, -1));
    this.add(jLCorreo, new AbsoluteConstraints(30, 135,-1, -1));
    this.add(jtCorreo, new AbsoluteConstraints(30, 155,-1, -1));
    this.add(jLPass, new AbsoluteConstraints(30, 200,-1, -1));
    this.add(jtPass, new AbsoluteConstraints(30, 220,-1, -1));
    this.add(jLFecha, new AbsoluteConstraints(30, 265,-1, -1));
    this.add(jTFecha, new AbsoluteConstraints(30, 285,-1, -1));
    this.add(jLPais, new AbsoluteConstraints(200, 265,-1, -1));
    this.add(jCBPaises, new AbsoluteConstraints(200, 285,-1, -1));*/
      int posX[] = {10,30,30,30,30,30,30,30,30,200,200};
      int posY[] = {20,70,90,135,155,200,220,265,285,265,285};
      Component etiquetas[]={jLTitulo,jLNombre,jtNombre,jLCorreo,jtCorreo,jLPass,jtPass,jLFecha,jTFecha,jLPais,jCBPaises};
      for (int i = 0; i < posX.length; i++) {
        this.add(etiquetas[i], new AbsoluteConstraints(posX[i],posY[i],-1, -1)); 
      }
  }
  
  public final boolean entradaDatosErroneo(){
      boolean salida = false;
      if(jtNombre.getText().equals("Ingrese su nombre") || jtNombre.getText().isEmpty() || jCBPaises.getSelectedIndex() == 0 ||
         String.valueOf(jtPass.getPassword()).isEmpty() || String.valueOf(jtPass.getPassword()).equals("P@ssw0rd") ||
         jtCorreo.getText().equals("Ingrese un correo") || jtCorreo.getText().isEmpty() || jTFecha.getText().isEmpty()){
         salida=true;
        }
      return  salida;
  }
  
  public final void validarCorreo() throws SQLException, ClassNotFoundException{
        if(registro.verificarCorreo(cliente.getCorreo()) == 0) {
            registro.registrarUsuario(cliente);
            registro.iniciarSesion(cliente);
            JOptionPane.showMessageDialog(null, "Usuario registrado", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Dialogo/exitoEs.png")))));
        }else{
            JOptionPane.showMessageDialog(null, "Correo ya registrado", "",JOptionPane.PLAIN_MESSAGE, new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Dialogo/advertencia.png")))));
            cliente.setIdUsuario(0);
        }
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
        jPLinea = new javax.swing.JPanel();
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

        jPLinea.setBackground(new java.awt.Color(153, 153, 153));
        add(jPLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 205, 1));

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
    private javax.swing.JPanel jPLinea;
    private javax.swing.JLabel jTFecha;
    // End of variables declaration//GEN-END:variables
}
