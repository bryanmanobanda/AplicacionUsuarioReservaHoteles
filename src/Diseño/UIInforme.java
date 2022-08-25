package Diseño;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class UIInforme {
  UIManager UI;
  public UIInforme() {
    UI.put("OptionPane.background",new ColorUIResource(147,171,169));
    UI.put("Panel.background",new ColorUIResource(147,171,169));
    UI.put("text", new Color(11, 31, 76));
    UI.put("OptionPane.messageFont", new Font("Roboto Medium", Font.PLAIN, 14));
    //UI.put("OptionPane.okIcon", new ImageIcon((getClass().getResource("/Assets/BotonesAccion/continuar.png"))));
    UI.put("OptionPane.okButtonText", "Aceptar");
  }
}
