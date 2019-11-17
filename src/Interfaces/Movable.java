package Interfaces;

import Enumerations.DirectionTypes;

public interface Movable {
    void move(double speed, DirectionTypes dirType);

    void move(double speed, double rotationSpeed, double maxSpeed, DirectionTypes dirType);
}
