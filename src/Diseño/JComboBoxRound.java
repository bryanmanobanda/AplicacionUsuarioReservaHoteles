package Diseño;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JComboBox;

public class JComboBoxRound extends JComboBox {
    private final Dimension dimension = new Dimension(150, 25);
    private final BorderLineRound border = new BorderLineRound();

    public JComboBoxRound(JComboBox jComboBox) {
        jComboBox.setUI((JComboBoxUI.createUI(this)));
        jComboBox.setBorder(border);
        jComboBox.setPreferredSize(dimension);
        jComboBox.setFont(new Font("Open Sans", Font.PLAIN, 14));
        jComboBox.setForeground(new Color(81, 81, 73));
        jComboBox.setBackground(new Color(219, 157, 121));
        jComboBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                setBorder(new BorderLineRound());
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBorder(border);
            }
        });
    }
}