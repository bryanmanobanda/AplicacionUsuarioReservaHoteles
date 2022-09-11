package Diseño;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class UIInforme {

    public UIInforme() {
        UIManager.put("OptionPane.background", new ColorUIResource(147, 171, 169));
        UIManager.put("Panel.background", new ColorUIResource(147, 171, 169));
        UIManager.put("text", new Color(11, 31, 76));
        UIManager.put("OptionPane.messageFont", new Font("Roboto Medium", Font.PLAIN, 14));
        UIManager.put("OptionPane.okButtonText", "Aceptar");
    }
}
