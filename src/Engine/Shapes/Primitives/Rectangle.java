package Engine.Shapes.Primitives;

import Engine.Bound;
import Engine.Shape;
import Engine.Vector2;
import org.newdawn.slick.Graphics;

public class Rectangle extends Shape {
    public Rectangle(double x1, double y1, double x2, double y2) {
        frame = new Vector2[]{new Vector2(x1, y1), new Vector2(x2, y1),
                new Vector2(x2, y2), new Vector2(x1, y2)};
        center = new Vector2((x1 + x2) / 2, (y1 + y2) / 2);
        initCenter = new Vector2(center.getX(), center.getY());
        area = java.lang.Math.abs((x2 - x1) * (y2 - y1));
    }

    @Override
    public void draw(Graphics graphics) {
        int len = frame.length;
        Vector2 point1;
        Vector2 point2;
        for (int i = 0; i < len - 1; i++) {
            point1 = getPointLocation(i);
            point2 = getPointLocation(i + 1);
            drawLine(point1, point2, graphics);
        }
        drawLine(getPointLocation(0), getPointLocation(len - 1), graphics);
    }

    @Override
    public boolean checkCollision(Vector2 point) {
        return false;
    }


    @Override
    public boolean checkCollision(Bound bound) {
        return false;
    }
}
