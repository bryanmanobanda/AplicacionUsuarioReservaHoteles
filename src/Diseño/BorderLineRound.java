package Diseño;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;

public class BorderLineRound extends AbstractBorder {
    private RenderingHints antiliasing;
    private Graphics2D g2d;

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        this.antiliasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.g2d = (Graphics2D) g;
        this.g2d.setColor(c.getParent().getBackground());
        fillG2D(x, y, width, height);
    }

    private void fillG2D(int x, int y, int width, int height) {
        Path2D path = new Path2D.Float(Path2D.WIND_EVEN_ODD);
        this.g2d.addRenderingHints(antiliasing);
        path.append(new RoundRectangle2D.Float(x, y, width, height, 30, height), false);
        path.append(new RoundRectangle2D.Float(x - 1, y - 1, width + 2, height + 2, .2f, .2f), false);
        this.g2d.fill(path);
    }
}
