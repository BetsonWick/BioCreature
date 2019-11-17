package Engine.MovementTypes;

import Engine.Bound;
import Engine.Vector2;
import Enumerations.DirectionTypes;

public class FourDirections extends DefaultMovement {
    private final double sin45;

    public FourDirections(Bound bound) {
        this.bound = bound;
        sin45 = Math.sin(Math.PI / 4);
        currentSpeed = 0;
    }

    @Override
    public void move(double speed, DirectionTypes dirType) {
        Vector2 toMove = new Vector2(0, 0);
        if (dirType == DirectionTypes.UP) {
            toMove.addVector(new Vector2(0, -speed));
        }
        if (dirType == DirectionTypes.DOWN) {
            toMove.addVector(new Vector2(0, speed));
        }
        if (dirType == DirectionTypes.LEFT) {
            toMove.addVector(new Vector2(-speed, 0));
        }
        if (dirType == DirectionTypes.RIGHT) {
            toMove.addVector(new Vector2(speed, 0));
        }
        if (dirType == DirectionTypes.UP_RIGHT) {
            toMove.addVector(new Vector2(speed * sin45, -speed * sin45));
        }
        if (dirType == DirectionTypes.UP_LEFT) {
            toMove.addVector(new Vector2(-speed * sin45, -speed * sin45));
        }
        if (dirType == DirectionTypes.DOWN_LEFT) {
            toMove.addVector(new Vector2(-speed * sin45, speed * sin45));
        }
        if (dirType == DirectionTypes.DOWN_RIGHT) {
            toMove.addVector(new Vector2(speed * sin45, speed * sin45));
        }
        bound.moveCenter(toMove);
    }

    @Override
    public void move(double speed, double rotationSpeed, double maxSpeed, DirectionTypes dirType) {

    }

}
