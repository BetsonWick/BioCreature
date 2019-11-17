package Engine;

import Interfaces.Collision;
import Interfaces.Drawable;
import org.newdawn.slick.Graphics;

public abstract class Shape implements Drawable, Collision {
    protected Vector2[] frame;
    protected Vector2 initCenter;
    protected Vector2 center;
    protected double area;
    protected double angle;

    public Vector2[] getFrame() {
        return frame;
    }

    public void setCenter(Vector2 center) {
        this.center = center;
    }

    public static void drawLine(Vector2 point1, Vector2 point2, Graphics graphics) {
        graphics.drawLine((float) point1.getX(), (float) point1.getY(),
                (float) point2.getX(), (float) point2.getY());
    }

    public Vector2 getCenter() {
        return center;
    }

    public double getArea() {
        return area;
    }

    public Vector2 getRotatedPointLocation(int index) {
        Vector2 result = new Vector2(frame[index].getX(), frame[index].getY());
        result.subVector(initCenter);
        result = Math.getNewPoint(result, angle);
        result.addVector(center);
        return result;
    }

    public Vector2 getPointLocation(int index) {
        Vector2 result = new Vector2(frame[index].getX() + center.getX(), frame[index].getY() + center.getY());
        result.subVector(initCenter);
        return result;
    }

    public void moveCenter(Vector2 move) {
        center.addVector(move);
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

}
