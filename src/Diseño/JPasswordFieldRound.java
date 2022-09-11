package Diseño;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class JPasswordFieldRound extends JPasswordField {
    private final Dimension dimension = new Dimension(278, 25);
    private final JCheckBox check = new JCheckBox();
    private final JLabel jLIcon = new JLabel(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Dialogo/icoBus.png")))));
    private final BorderLineRound border = new BorderLineRound();

    public JPasswordFieldRound(String placeHolder) {
        this.setOpaque(true);
        this.setBorder(border);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setHorizontalAlignment(CENTER);
        this.setText(placeHolder);
        this.setForeground(new Color(81, 81, 73));
        this.setFont(new Font("Open Sans", Font.PLAIN, 14));
        this.setBackground(new Color(219, 157, 121));
        this.setEchoChar('*');
        check.setOpaque(false);
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                setBorder(new BorderLineRound());
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBorder(border);
                setEchoChar('*');
                check.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/Dialogo/disable.png"))));
                check.setSelected(false);
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (String.valueOf(getPassword()).equals(placeHolder)) {
                    setText("");
                    setForeground(new Color(63, 63, 58));
                }
            }
        });
        this.setLayout(new AbsoluteLayout());
        this.add(check, new AbsoluteConstraints(250, 0, -1, -1));
        this.add(jLIcon, new AbsoluteConstraints(5, 3, -1, -1));
        check.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/Dialogo/disable.png"))));
        check.setFocusable(false);
        check.addMouseListener(getMouseAdapter());
        check.addActionListener(getActionListener());
    }

    private MouseAdapter getMouseAdapter() {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                check.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                check.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        };
    }

    private ActionListener getActionListener() {
        return e -> {
            if (check.isSelected()) {
                check.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/Dialogo/enable.png"))));
                this.setEchoChar((char) 0);
                this.requestFocus();
            } else {
                check.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/Dialogo/disable.png"))));
                this.setEchoChar('*');
            }
        };
    }
}
