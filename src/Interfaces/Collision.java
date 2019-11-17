package Interfaces;

import Engine.Bound;
import Engine.Vector2;

public interface Collision {
    boolean checkCollision(Vector2 point);

    boolean checkCollision(Bound bound);
}
