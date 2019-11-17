package Engine.MovementTypes;

import Engine.Bound;
import Engine.Math;
import Engine.Vector2;
import Enumerations.DirectionTypes;

public class RotateAndMove extends DefaultMovement {

    public RotateAndMove(Bound bound) {
        this.bound = bound;
        currentSpeed = 0;
    }

    private double rotation(double angle, double speed) {
        double pi2 = Math.PI * 2;
        if (java.lang.Math.abs(angle - bound.getAngle()) < speed) {
            return 0;
        }
        if ((angle - bound.getAngle() + pi2) % pi2 < (bound.getAngle() - angle + pi2) % pi2) {
            return speed;
        }
        return -speed;
    }

    @Override
    public void move(double acceleration, double rotationSpeed, double maxSpeed, DirectionTypes dirType) {
        double angle = bound.getAngle();
        double cos = java.lang.Math.cos(angle);
        double sin = java.lang.Math.sin(angle);
        bound.moveCenter(new Vector2(cos * currentSpeed, -sin * currentSpeed));
        if (dirType != DirectionTypes.IDLE && currentSpeed < maxSpeed) {
            currentSpeed += acceleration;
        } else if (currentSpeed > 0) {
            currentSpeed -= Math.DENSITY;
            if (currentSpeed < 0) {
                currentSpeed = 0;
            }
        }
        double toRotate = toRotate(dirType);
        if (toRotate != -1) {
            bound.setAngle(angle + rotation(toRotate, rotationSpeed));
        }
    }

    @Override
    public void move(double speed, DirectionTypes dirType) {

    }
}
