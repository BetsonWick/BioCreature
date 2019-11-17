package Units;

import Engine.Bound;
import Engine.MovementTypes.DefaultMovement;
import Interfaces.Behaviour;
import Interfaces.Collision;
import Interfaces.Drawable;

public abstract class Unit implements Behaviour, Drawable, Collision {
    protected DefaultMovement moveType;
    protected double acceleration;
    protected double rotationSpeed;
    protected double maxSpeed;
}
