package Diseño;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class JTextCalendar extends JTextField {
    private final Dimension dimension = new Dimension(150, 25);
    private final JLabel jLIcon = new JLabel(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Dialogo/icoBus.png")))));
    private final BorderLineRound border = new BorderLineRound();
    private JDateChooser calendar = new JDateChooser();
    private final SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    private JButton button;
    protected JLabel jLFecha;

    public JTextCalendar(JLabel jLabel, GregorianCalendar gregorianCalendar) {
        jLFecha = jLabel;
        calendar.setCalendar(gregorianCalendar);
        button = calendar.getCalendarButton();
        button.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Dialogo/enable.png")))));
        button.setOpaque(true);
        button.setBorder(null);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel.setOpaque(true);
        jLabel.setBorder(border);
        jLabel.setEnabled(true);
        jLabel.setSize(dimension);
        jLabel.setText("");
        jLabel.setPreferredSize(dimension);
        jLabel.setHorizontalAlignment(CENTER);
        jLabel.setFont(new Font("Open Sans", Font.PLAIN, 14));
        jLabel.setForeground(new Color(81, 81, 73));
        jLabel.setBackground(new Color(219, 157, 121));
        jLabel.setLayout(new AbsoluteLayout());
        jLabel.add(jLIcon, new AbsoluteConstraints(5, 3, -1, -1));
        jLabel.add(button, new AbsoluteConstraints(125, 3, -1, -1));
        calendar.addPropertyChangeListener(pce -> jLabel.setText(formato.format(calendar.getDate())));
    }

    public JDateChooser getCalendar() {
        return calendar;
    }
}
