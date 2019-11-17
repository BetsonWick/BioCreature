import Engine.Bound;
import Engine.InputSolver;
import Engine.Shapes.Complex.ComplexShape;
import Engine.Vector2;
import Enumerations.DirectionTypes;
import Enumerations.States;
import Fields.Constructor;
import Units.Protozoa.Infusorium.Infusoria;
import Units.Protozoa.Protozoan;
import org.newdawn.slick.*;

public class Main extends BasicGame {
    private Constructor constructor;
    Protozoan infusoria;
    Vector2 point;
    States state;

    public Main(String title) {
        super(title);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer agc = new AppGameContainer(new Main("Window"));
        agc.setTargetFrameRate(64);
        agc.setShowFPS(false);
        agc.start();
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        constructor = new Constructor();
        infusoria = new Infusoria(new Bound(new ComplexShape(new Vector2[]{new Vector2(100, 100), new Vector2(110, 100),
                new Vector2(100, 110), new Vector2(110, 110)}, new Vector2(105, 105))));
        state = States.CONSTRUCTOR;
        switch (state.ordinal()) {
            case 0:
                break;
            case 1:
                constructor.init(gameContainer);
                break;
        }
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        switch (state.ordinal()) {
            case 0:
                break;
            case 1:
                constructor.update(gameContainer);
                break;
        }
        DirectionTypes type = InputSolver.getDir4(gameContainer.getInput());
        if (infusoria != null) {
            infusoria.behave(type);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        if (infusoria != null) {
            infusoria.draw(graphics);
        }
        switch (state.ordinal()) {
            case 0:
                break;
            case 1:
                constructor.draw(graphics);
                break;
        }
    }
}
