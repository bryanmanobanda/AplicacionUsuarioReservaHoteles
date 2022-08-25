package Diseño;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class JTextFieldRound extends JTextField implements MouseListener{
  private final Dimension d = new Dimension(278, 25);
  private final JLabel icon = new JLabel(new ImageIcon((getClass().getResource("/Assets/Dialogo/icoBus.png"))));
  private final BorderLineRound border = new BorderLineRound(new Color(219, 157, 121), true);
  String place;
  public JTextFieldRound(String placeHolder) {
    place = placeHolder;
    this.setOpaque(true);
    this.setBorder(border);
    this.setSize(d);
    this.setPreferredSize(d);
    this.setHorizontalAlignment(CENTER);
    this.setFont(new Font("Open Sans", Font.PLAIN, 14));
    this.setForeground(new Color(81,81,73));
    this.setBackground(new Color(219, 157, 121));
    this.setText(placeHolder);
    this.setLayout(new AbsoluteLayout());
    this.add(icon, new AbsoluteConstraints(5,3,-1, -1));
    
    this.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        txtFocusGained(e);
      }

      @Override
      public void focusLost(FocusEvent e) {
        txtFocusLost(e);
      }
    });
    addMouseListener(this);
  }
  
  private void txtFocusGained(FocusEvent evt){
    setBorder(new BorderLineRound(new Color(219, 157, 121), true));
  }
  
  private void txtFocusLost(FocusEvent evt){
    setBorder(border);
  }

  @Override
  public void mouseClicked(MouseEvent me) {
  }

  @Override
  public void mousePressed(MouseEvent me) {
    if(getText().equals(place)){
      setText("");
      setForeground(new Color(63,63,58));
    }
  }

  @Override
  public void mouseReleased(MouseEvent me) {
  }

  @Override
  public void mouseEntered(MouseEvent me) {
  }

  @Override
  public void mouseExited(MouseEvent me) {
  }
}
