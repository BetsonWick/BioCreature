package Engine;

import Enumerations.DirectionTypes;
import org.newdawn.slick.Input;

public class InputSolver {
    public static DirectionTypes getDir4(Input input) {
        if (input.isKeyDown(Input.KEY_W)) {
            if (input.isKeyDown(Input.KEY_D)) {
                return DirectionTypes.UP_RIGHT;
            }
            if (input.isKeyDown(Input.KEY_A)) {
                return DirectionTypes.UP_LEFT;
            }
            return DirectionTypes.UP;
        }
        if (input.isKeyDown(Input.KEY_S)) {
            if (input.isKeyDown(Input.KEY_D)) {
                return DirectionTypes.DOWN_RIGHT;
            }
            if (input.isKeyDown(Input.KEY_A)) {
                return DirectionTypes.DOWN_LEFT;
            }
            return DirectionTypes.DOWN;
        }
        if (input.isKeyDown(Input.KEY_D)) {
            return DirectionTypes.RIGHT;
        }

        if (input.isKeyDown(Input.KEY_A)) {
            return DirectionTypes.LEFT;
        }
        return DirectionTypes.IDLE;
    }

}
