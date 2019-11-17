package Units.Protozoa;

import Engine.Bound;
import Engine.MovementTypes.RotateAndMove;
import Engine.Vector2;
import Enumerations.DirectionTypes;
import Parts.Structures.Cell;
import Units.Unit;
import org.newdawn.slick.Graphics;

public class Protozoan extends Unit {
    Cell cell;

    public Protozoan(Bound bound) {
        this.moveType = new RotateAndMove(bound);
    }

    @Override
    public void behave() {

    }

    @Override
    public void behave(DirectionTypes dirType) {
        moveType.move(acceleration, rotationSpeed, maxSpeed, dirType);
    }

    @Override
    public boolean checkCollision(Vector2 point) {
        return false;
    }

    @Override
    public boolean checkCollision(Bound bound) {
        return false;
    }

    @Override
    public void draw(Graphics graphics) {

    }
}
