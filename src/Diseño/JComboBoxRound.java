package Diseño;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JComboBox;

public class JComboBoxRound extends JComboBox {
private final Dimension d = new Dimension(150, 25);
  private final BorderLineRound border = new BorderLineRound(new Color(219, 157, 121), true);
  public JTextFieldRound combo;
  
  public JComboBoxRound(JComboBox j) {
    j.setUI((JComboBoxUI.createUI(this)));
    j.setBorder(border);
    j.setPreferredSize(d);
    j.setFont(new Font("Open Sans", Font.PLAIN, 14));
    j.setForeground(new Color(81,81,73));
    j.setBackground(new Color(219, 157, 121));
    j.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        txtFocusGained(e);
      }

      @Override
      public void focusLost(FocusEvent e) {
        txtFocusLost(e);
      }
    }); 
  }

  private void txtFocusGained(FocusEvent evt){
    setBorder(new BorderLineRound(new Color(218, 157, 121), true));
  }
  
  private void txtFocusLost(FocusEvent evt){
    setBorder(border);
  }
}
