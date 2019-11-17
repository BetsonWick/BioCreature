package Engine;

import Interfaces.Drawable;

import java.util.Arrays;

public class Vector2 {
    private double x;
    private double y;
    private final int pointRad = 1;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void addVector(Vector2 vector) {
        setX(getX() + vector.getX());
        setY(getY() + vector.getY());
    }

    public void subVector(Vector2 vector) {
        setX(getX() - vector.getX());
        setY(getY() - vector.getY());
    }

    public void multiply(double scalar) {
        setX(getX() * scalar);
        setY(getY() * scalar);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getLength() {
        return java.lang.Math.sqrt(x * x + y * y);
    }

    public Vector2 getRotatedCopy(double angle) {
        return new Vector2(getX() * java.lang.Math.cos(angle), getY() * java.lang.Math.sin(angle));
    }

    @Override
    public String toString() {
        double[] pair = new double[]{getX(), getY()};
        return Arrays.toString(pair);
    }

}
