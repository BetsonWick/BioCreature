package Engine;

import static java.lang.Math.*;

public class Math{
    public static final double INFELICITY = 0.5;
    public static final double DENSITY = 0.01;
    public static final double PI = 3.141592653589793;

    public static double triangleArea(Vector2 p1, Vector2 p2, Vector2 p3) {
        Vector2 side1 = new Vector2(p2.getX(), p2.getY());
        Vector2 side2 = new Vector2(p3.getX(), p3.getY());
        side1.subVector(p1);
        side2.subVector(p1);
        double len1 = side1.getLength();
        double len2 = side2.getLength();
        double angleProduct = scalarProduct(side1, side2) / (len1 * len2);
        angleProduct = sqrt(1 - angleProduct * angleProduct);
        return len1 * len2 * angleProduct / 2;
    }

    public static Vector2 getNewPoint(Vector2 old, double angle) {
        double cos = cos(angle);
        double sin = sin(angle);
        double tan = tan(angle);
        double newX = (old.getX() + old.getY() * tan) / (cos + sin * tan);
        double newY = (old.getY() - newX * sin) / cos;
        return new Vector2(newX, newY);
    }

    public static double scalarProduct(Vector2 v1, Vector2 v2) {
        return v1.getX() * v2.getX() + v1.getY() * v2.getY();
    }
}
