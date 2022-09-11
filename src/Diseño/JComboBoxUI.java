package Diseño;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Objects;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class JComboBoxUI extends BasicComboBoxUI {
    private Color colorFondo = new Color(219, 157, 121);
    private Color colorLista = new Color(147, 171, 169);

    public static ComboBoxUI createUI(JComponent comp) {
        return new JComboBoxUI();
    }

    @Override
    protected JButton createArrowButton() {
        JButton jbn = new JButton();
        jbn.setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Dialogo/enable.png")))));
        jbn.setOpaque(true);
        jbn.setBorder(null);
        jbn.setContentAreaFilled(false);
        jbn.setBorderPainted(false);
        jbn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return jbn;
    }

    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
        g.setColor(colorFondo);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    @Override
    protected ListCellRenderer createRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                list.setSelectionBackground(colorLista);
                list.setBackground(colorFondo);
                list.setFont(new Font("Open Sans", Font.PLAIN, 14));
                list.setForeground(new Color(81, 81, 73));
                if (index == -1) {
                    setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("/Assets/Dialogo/icoBus.png")))));
                }
                return this;
            }
        };
    }
}