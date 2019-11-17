package Engine.Shapes.Primitives;

import Engine.Bound;
import Engine.Shape;
import Engine.Vector2;
import org.newdawn.slick.Graphics;

public class Circle extends Shape {
    private double radius;

    public Circle(double x1, double y1, double x2, double y2) {
        this(x1, y1, new Vector2(x2 - x1, y2 - y1).getLength());
    }

    public Circle(double x1, double y1, double radius) {
        frame = new Vector2[]{new Vector2(x1, y1)};
        center = new Vector2(x1, y1);
        initCenter = new Vector2(center.getX(), center.getY());
        area = Math.PI * radius * radius;
        this.radius = radius;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.fillOval((float) (center.getX() - radius), (float) (center.getY() - radius),
                (float) radius * 2, (float) radius * 2);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean checkCollision(Vector2 point) {
        Vector2 dist = new Vector2(point.getX() - center.getX(), point.getY() - center.getY());
        return dist.getLength() < radius;
    }

    @Override
    public boolean checkCollision(Bound bound) {
        return false;
    }

}
