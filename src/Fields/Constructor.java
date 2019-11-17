package Fields;

import Engine.Shape;
import Engine.Shapes.Primitives.Circle;
import Engine.Vector2;
import Interfaces.Drawable;
import Interfaces.IsInitialized;
import Interfaces.Updatable;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import java.util.ArrayList;

public class Constructor implements Drawable, Updatable, IsInitialized {
    ArrayList<Circle> cellBorder;
    private final double CIRCLE_RADIUS = 4;

    private void drawBorder(Graphics graphics) {
        int size = cellBorder.size();
        if (size == 0) {
            return;
        }
        Circle prevPoint = cellBorder.get(0);
        if (size == 1) {
            prevPoint.draw(graphics);
            return;
        }
        Circle curPoint;
        prevPoint.draw(graphics);
        for (int i = 1; i < size - 1; i++) {
            curPoint = cellBorder.get(i);
            Shape.drawLine(prevPoint.getCenter(), curPoint.getCenter(), graphics);
            prevPoint = curPoint;
            prevPoint.draw(graphics);
        }
        Shape.drawLine(cellBorder.get(0).getCenter(),
                cellBorder.get(size - 2).getCenter(), graphics);
        cellBorder.get(size - 1).draw(graphics);
    }

    @Override
    public void init(GameContainer gmc) {
        cellBorder = new ArrayList<>();
    }

    @Override
    public void draw(Graphics graphics) {
        drawBorder(graphics);
    }

    @Override
    public void update(GameContainer gmc) {
        Input input = gmc.getInput();
        if (input.isKeyDown(Input.KEY_LSHIFT)) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                cellBorder.add(new Circle(input.getMouseX(), input.getMouseY(), CIRCLE_RADIUS));
            }
        }
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            for (Circle circle : cellBorder) {
                if (circle.checkCollision(new Vector2(input.getMouseX(), input.getMouseY()))) {
                    circle.setCenter(new Vector2(input.getMouseX(), input.getMouseY()));
                }
            }
        }
    }

    public void clearBorder() {
        cellBorder.clear();
    }

    public Vector2[] getBorder() {
        Vector2[] border = new Vector2[cellBorder.size()];
        for (int i = 0; i < cellBorder.size(); i++) {
            Vector2 point = cellBorder.get(i).getCenter();
            border[i] = new Vector2(point.getX(), point.getY());
        }
        return border;
    }
}
