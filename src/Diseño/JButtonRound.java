package Diseño;

import java.awt.Dimension;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JButtonRound extends JButton{
  public JButtonRound(JButton jBoton) {
    jBoton.setBorder(null);
    jBoton.setText("");
    jBoton.setSize(new Dimension(88,24));
    jBoton.setBorderPainted(false);
    jBoton.setContentAreaFilled(false);
    jBoton.setFocusPainted(false);
    jBoton.setCursor(new Cursor(Cursor.HAND_CURSOR));
  }
  
  public void botonRegistrarAmarillo(JButton jBoton){
    jBoton.setIcon(new ImageIcon((getClass().getResource("/Assets/botonRegistrar.png"))));
    jBoton.setDisabledIcon(new ImageIcon((getClass().getResource("/Assets/btnRegistroAzul.png"))));
    jBoton.setRolloverIcon(new ImageIcon((getClass().getResource("/Assets/btnOverRegistrar.png"))));
    jBoton.setPressedIcon(new ImageIcon((getClass().getResource("/Assets/btnPressRegistro.png"))));
  }
  
  public void botonRegistrarAzul(JButton jBoton){
    jBoton.setIcon(new ImageIcon((getClass().getResource("/Assets/btnRegistroAzul.png"))));
    jBoton.setDisabledIcon(new ImageIcon((getClass().getResource("/Assets/botonRegistrar.png"))));
    jBoton.setRolloverIcon(new ImageIcon((getClass().getResource("/Assets/btnOverRegistroAzul.png"))));
    jBoton.setPressedIcon(new ImageIcon((getClass().getResource("/Assets/btnPressRegistroAzul.png"))));
  }
  
  public void botonInicioAmarillo(JButton jBoton){
    jBoton.setIcon(new ImageIcon((getClass().getResource("/Assets/btnInicioAma.png"))));
    jBoton.setDisabledIcon(new ImageIcon((getClass().getResource("/Assets/btnInicio.png"))));
    jBoton.setRolloverIcon(new ImageIcon((getClass().getResource("/Assets/btnOverinicioAma.png"))));
    jBoton.setPressedIcon(new ImageIcon((getClass().getResource("/Assets/btnPressInicioAma.png"))));    
  }
  
  public void botonInicioAzul(JButton jBoton){
    jBoton.setIcon(new ImageIcon((getClass().getResource("/Assets/btnInicio.png"))));
    jBoton.setDisabledIcon(new ImageIcon((getClass().getResource("/Assets/btnInicioAma.png"))));
    jBoton.setRolloverIcon(new ImageIcon((getClass().getResource("/Assets/btnOverinicio.png"))));
    jBoton.setPressedIcon(new ImageIcon((getClass().getResource("/Assets/btnPressInicio.png"))));    
  }
  
  public void botonInsertar(JButton jBoton){
    jBoton.setIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/insertar.png"))));
    jBoton.setDisabledIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/insertar.png"))));
    jBoton.setRolloverIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/insertover.png"))));
    jBoton.setPressedIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/insertpress.png"))));    
  }
  
  public void botonActualizar(JButton jBoton){
    jBoton.setIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/actualizar.png"))));
    jBoton.setDisabledIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/actualizar.png"))));
    jBoton.setRolloverIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/actover.png"))));
    jBoton.setPressedIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/actpress.png"))));    
  }
  
  public void botonEliminar(JButton jBoton){
    jBoton.setIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/eliminar.png"))));
    jBoton.setDisabledIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/eliminar.png"))));
    jBoton.setRolloverIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/elimover.png"))));
    jBoton.setPressedIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/elimpress.png"))));    
  }
  
  public void botonContinuar(JButton jBoton){
    jBoton.setIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/continuar.png"))));
    jBoton.setDisabledIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/continuar.png"))));
    jBoton.setRolloverIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/contover.png"))));
    jBoton.setPressedIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/contpress.png"))));    
  }
  
  public void botonReserva(JButton jBoton){
    jBoton.setIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/reserva.png"))));
    jBoton.setDisabledIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/reserva.png"))));
    jBoton.setRolloverIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/reserover.png"))));
    jBoton.setPressedIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/reserpress.png"))));    
  }
  
  public void botonAtras(JButton jBoton){
    jBoton.setIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/atras.png"))));
    jBoton.setDisabledIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/atras.png"))));
    jBoton.setRolloverIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/atrasover.png"))));
    jBoton.setPressedIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/atraspress.png"))));    
  }
  
  public void botonCerrar(JButton jBoton){
    jBoton.setIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/cerrar.png"))));
    jBoton.setDisabledIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/cerrar.png"))));
    jBoton.setRolloverIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/cerrarover.png"))));
    jBoton.setPressedIcon(new ImageIcon((getClass().getResource("/Assets/BotonesAccion/cerrarpress.png"))));    
  }
}
