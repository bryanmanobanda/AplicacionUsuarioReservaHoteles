package Diseño;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class JTextCalendar extends JTextField {
  private final Dimension d = new Dimension(150, 25);
  private final JLabel icon = new JLabel(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Dialogo/icoBus.png")))));
  private final BorderLineRound border = new BorderLineRound();
  public JDateChooser calendar = new JDateChooser();
  private final SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
  private JButton button;
  JLabel fecha;
  
  public JTextCalendar(JLabel j, GregorianCalendar gcal) {
    fecha = j;
    calendar.setCalendar(gcal);
    button = calendar.getCalendarButton();
    button.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Dialogo/enable.png")))));
    button.setOpaque(true);
    button.setBorder(null);
    button.setContentAreaFilled(false);
    button.setBorderPainted(false);
    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    j.setOpaque(true);
    j.setBorder(border);
    j.setEnabled(true);
    j.setSize(d);
    j.setText("");
    j.setPreferredSize(d);
    j.setHorizontalAlignment(CENTER);
    j.setFont(new Font("Open Sans", Font.PLAIN, 14));
    j.setForeground(new Color(81,81,73));
    j.setBackground(new Color(219, 157, 121));
    j.setLayout(new AbsoluteLayout());
    j.add(icon, new AbsoluteConstraints(5,3,-1, -1));
    j.add(button, new AbsoluteConstraints(125,3,-1, -1));   
    calendar.addPropertyChangeListener(new PropertyChangeListener() {
      @Override
      public void propertyChange(PropertyChangeEvent pce) {
        j.setText(formato.format(calendar.getDate()));
      }
    });
  }

  public JButton getButton() {
    return button;
  }

  public void setButton(JButton button) {
    this.button = button;
  } 

  public JLabel getFecha() {
    return fecha;
  }

  public void setFecha(JLabel fecha) {
    this.fecha = fecha;
  }

  public JDateChooser getCalendar() {
    return calendar;
  }

  public void setCalendar(JDateChooser calendar) {
    this.calendar = calendar;
  }
  
  
}
