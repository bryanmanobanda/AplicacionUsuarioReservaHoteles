package Paneles;

import CRUD.Cliente;
import Conexion.CifrarContrasenia;
import Conexion.SQLCliente;
import Diseño.JButtonRound;
import Diseño.JLabelTitle;
import Diseño.JPasswordFieldRound;
import Diseño.JTextFieldRound;

import java.awt.Color;
import java.awt.Component;
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
    JTextFieldRound jTCorreo;
    JPasswordFieldRound jtPass;

    JButton JBInicio;
    JLabelTitle jnombreApp, jCorreo, jContrasenia;
    int tamText = 20;

    public JPIniciarSesion() {
        initComponents();
        crearElementos();
        agregarElementos();

        JBInicio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                String pass = String.valueOf(jtPass.getPassword());
                cliente = new Cliente(jTCorreo.getText(), CifrarContrasenia.md5(pass));
                try {
                    if (inicio.iniciarSesion(cliente)) {
                        JOptionPane.showMessageDialog(null, "Inicio de sesión correcto", "", JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/listo.png"))));
                    } else {
                        JOptionPane.showMessageDialog(null, "Correo o contraseñas incorrectos", "", JOptionPane.PLAIN_MESSAGE, new ImageIcon((getClass().getResource("/Assets/Dialogo/error.png"))));
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(JPIniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public final void crearElementos() {
        jTCorreo = new JTextFieldRound("Ingrese su correo");
        jnombreApp = new JLabelTitle("Iniciar en Moon", 30);
        jCorreo = new JLabelTitle("Correo", tamText);
        jContrasenia = new JLabelTitle("Contraseña", tamText);
        JBInicio = new JButton();
        btninicio = new JButtonRound(JBInicio);
        btninicio.botonInicioAmarillo(JBInicio);
        jtPass = new JPasswordFieldRound("Password");
        inicio = new SQLCliente();
    }

    public final void agregarElementos() {
        int posX[] = {10, 30, 30, 30, 30};
        int posY[] = {70, 120, 145, 195, 220};
        Component etiquetas[] = {jnombreApp, jCorreo, jTCorreo, jContrasenia, jtPass};
        for (int i = 0; i < posX.length; i++) {
            this.add(etiquetas[i], new AbsoluteConstraints(posX[i], posY[i], -1, -1));
        }
    }

    public JButton getJBInicio() {
        return JBInicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPLinea = new javax.swing.JPanel();

        setBackground(new java.awt.Color(147, 171, 169));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPLinea.setBackground(new java.awt.Color(153, 153, 153));
        add(jPLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 205, 1));
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (String.valueOf(jtPass.getPassword()).isEmpty()) {
            jtPass.setText("Password");
            jtPass.setForeground(new Color(63, 63, 58));
        }

        if (jTCorreo.getText().isEmpty()) {
            jTCorreo.setText("Ingrese su correo");
            jTCorreo.setForeground(new Color(81, 81, 73));
        }
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPLinea;
    // End of variables declaration//GEN-END:variables
}
