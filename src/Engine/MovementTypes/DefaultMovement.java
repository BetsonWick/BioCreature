package Engine.MovementTypes;

import Engine.Bound;
import Enumerations.DirectionTypes;
import Interfaces.Movable;

public abstract class DefaultMovement implements Movable {
    protected Bound bound;
    protected double currentSpeed;

    public Bound getBound() {
        return bound;
    }

    public static double toRotate(DirectionTypes dirType) {
        double toRotate = -1;
        double piDiv2 = Math.PI / 2;
        if (dirType == DirectionTypes.UP) {
            toRotate = piDiv2;
        }
        if (dirType == DirectionTypes.DOWN) {
            toRotate = piDiv2 * 3;
        }
        if (dirType == DirectionTypes.LEFT) {
            toRotate = piDiv2 * 2;
        }
        if (dirType == DirectionTypes.RIGHT) {
            toRotate = 0;
        }
        if (dirType == DirectionTypes.UP_RIGHT) {
            toRotate = piDiv2 / 2;
        }
        if (dirType == DirectionTypes.UP_LEFT) {
            toRotate = piDiv2 * 1.5;
        }
        if (dirType == DirectionTypes.DOWN_LEFT) {
            toRotate = piDiv2 * 2.5;
        }
        if (dirType == DirectionTypes.DOWN_RIGHT) {
            toRotate = piDiv2 * 3.5;
        }
        return toRotate;
    }
}
