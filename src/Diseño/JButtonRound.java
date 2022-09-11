package Diseño;

import java.awt.Dimension;
import java.awt.Cursor;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JButtonRound extends JButton {

    public JButtonRound(JButton jBoton) {
        jBoton.setBorder(null);
        jBoton.setText("");
        jBoton.setSize(new Dimension(88, 24));
        jBoton.setBorderPainted(false);
        jBoton.setContentAreaFilled(false);
        jBoton.setFocusPainted(false);
        jBoton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void botonRegistrarAmarillo(JButton jBoton) {
        jBoton.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/botonRegistrar.png")))));
        jBoton.setDisabledIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/btnRegistroAzul.png")))));
        jBoton.setRolloverIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/btnOverRegistrar.png")))));
        jBoton.setPressedIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/btnPressRegistro.png")))));
    }

    public void botonRegistrarAzul(JButton jBoton) {
        jBoton.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/btnRegistroAzul.png")))));
        jBoton.setDisabledIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/botonRegistrar.png")))));
        jBoton.setRolloverIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/btnOverRegistroAzul.png")))));
        jBoton.setPressedIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/btnPressRegistroAzul.png")))));
    }

    public void botonInicioAmarillo(JButton jBoton) {
        jBoton.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/btnInicioAma.png")))));
        jBoton.setDisabledIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/btnInicio.png")))));
        jBoton.setRolloverIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/btnOverinicioAma.png")))));
        jBoton.setPressedIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/btnPressInicioAma.png")))));
    }

    public void botonContinuar(JButton jBoton) {
        jBoton.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/continuar.png")))));
        jBoton.setDisabledIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/continuar.png")))));
        jBoton.setRolloverIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/contover.png")))));
        jBoton.setPressedIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/contpress.png")))));
    }

    public void botonReserva(JButton jBoton) {
        jBoton.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/reserva.png")))));
        jBoton.setDisabledIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/reserva.png")))));
        jBoton.setRolloverIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/reserover.png")))));
        jBoton.setPressedIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/reserpress.png")))));
    }

    public void botonAtras(JButton jBoton) {
        jBoton.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/atras.png")))));
        jBoton.setDisabledIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/atras.png")))));
        jBoton.setRolloverIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/atrasover.png")))));
        jBoton.setPressedIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/atraspress.png")))));
    }

    public void botonCerrar(JButton jBoton) {
        jBoton.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/cerrar.png")))));
        jBoton.setDisabledIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/cerrar.png")))));
        jBoton.setRolloverIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/cerrarover.png")))));
        jBoton.setPressedIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/cerrarpress.png")))));
    }

    public void misReservas(JButton jBoton) {
        jBoton.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/btnMReserva_normal.png")))));
        jBoton.setDisabledIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/btnMReserva_normal.png")))));
        jBoton.setRolloverIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/mreservasover.png")))));
        jBoton.setPressedIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/mreservaspress.png")))));
    }

    public void modificarContrasenia(JButton jBoton) {
        jBoton.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/contraNormal.png")))));
        jBoton.setDisabledIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/contraNormal.png")))));
        jBoton.setRolloverIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/contraover.png")))));
        jBoton.setPressedIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/BotonesAccion/contrapress.png")))));
    }
}
