package Engine.Shapes.Complex;

import Engine.Bound;
import Engine.Math;
import Engine.Shape;
import Engine.Vector2;
import org.newdawn.slick.Graphics;

public class ComplexShape extends Shape {
    public ComplexShape(Vector2[] frame, Vector2 center) {
        this.frame = frame;
        initCenter = center;
        setCenter(new Vector2(center.getX(), center.getY()));
        angle = 0;
    }

    @Override
    public boolean checkCollision(Vector2 point) {
        int length = frame.length;
        if (length == 0) {
            return false;
        }
        double area = 0;
        Vector2 prevPoint = getPointLocation(0);
        Vector2 curPoint;
        for (int i = 1; i < length; i++) {
            curPoint = getPointLocation(i);
            area += Math.triangleArea(prevPoint, point, curPoint);
            prevPoint = curPoint;
        }
        prevPoint = getPointLocation(0);
        curPoint = getPointLocation(length - 1);
        area += Math.triangleArea(prevPoint, point, curPoint);
        return java.lang.Math.abs(getArea() - area) < Math.INFELICITY;
    }

    @Override
    public boolean checkCollision(Bound bound) {
        return false;
    }


    @Override
    public void draw(Graphics graphics) {
        int len = frame.length;
        Vector2 point1;
        Vector2 point2;
        for (int i = 0; i < len - 1; i++) {
            point1 = getRotatedPointLocation(i);
            point2 = getRotatedPointLocation(i + 1);
            drawLine(point1, point2, graphics);
        }
        drawLine(getRotatedPointLocation(0), getRotatedPointLocation(len - 1), graphics);
    }
}
