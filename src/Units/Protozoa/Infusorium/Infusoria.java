package Units.Protozoa.Infusorium;

import Engine.Bound;
import Enumerations.Characteristics;
import Enumerations.Units;
import Resources.UnitCharacteristics;
import Units.Protozoa.Protozoan;
import org.newdawn.slick.Graphics;

import java.util.HashMap;

public class Infusoria extends Protozoan {
    public Infusoria(Bound bound) {
        super(bound);
        HashMap<Characteristics, Double> infusoria = UnitCharacteristics.info.get(Units.INFUSORIA);
        maxSpeed = infusoria.get(Characteristics.MAX_SPEED);
        acceleration = infusoria.get(Characteristics.ACCELERATION);
        rotationSpeed = infusoria.get(Characteristics.ROTATION_SPEED);
    }

    @Override
    public void draw(Graphics graphics) {
        moveType.getBound().getShape().draw(graphics);
    }
}