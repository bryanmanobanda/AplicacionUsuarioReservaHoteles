package Diseño;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class JLabelTitle extends JLabel {

    public JLabelTitle(String title, int tamanio) {
        setText(title);
        setFont(new Font("Roboto Medium", Font.PLAIN, tamanio));
        setForeground(new Color(11, 31, 76));
    }
}
