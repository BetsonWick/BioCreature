package Engine;

import Interfaces.Collision;

public class Bound implements Collision {
    private Shape shape;

    public Bound(Shape shape) {
        this.shape = shape;
        shape.setAngle(0);
    }

    @Override
    public boolean checkCollision(Vector2 point) {
        return shape.checkCollision(point);
    }

    @Override
    public boolean checkCollision(Bound bound) {
        return false;
    }

    public void moveCenter(Vector2 move) {
        shape.moveCenter(move);
    }

    public Vector2[] getFrame() {
        return shape.getFrame();
    }

    public Vector2 getCenter() {
        return shape.getCenter();
    }

    public Shape getShape() {
        return shape;
    }

    public double getAngle() {
        return (shape.getAngle() + Math.PI * 2) % (Math.PI * 2);
    }

    public void setAngle(double angle) {
        shape.setAngle(angle);
    }

}
