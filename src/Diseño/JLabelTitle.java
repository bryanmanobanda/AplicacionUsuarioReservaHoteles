package Diseño;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class JLabelTitle extends JLabel{

  public JLabelTitle(String title, JLabel j, int tamanio) {
    j.setText(title);
    j.setFont(new Font("Roboto Medium", Font.PLAIN, tamanio));
    j.setForeground(new Color(11, 31, 76));
  }
}
