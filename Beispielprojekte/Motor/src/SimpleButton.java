import java.awt.*;

/**
 * Master Mind
 * Author: Peter Mitchell (2021)
 *
 * SimpleButton class:
 * Defines a simple rectangle based button that can be drawn with a background,
 * with a method to check if the button has been clicked based on an x and y coordinate.
 */
public class SimpleButton {
    /**
     * X coordinate.
     */
    protected int x;
    /**
     * Y coordinate.
     */
    protected int y;
    /**
     * Width of the drawn rectangle and hit box.
     */
    protected int width;
    /**
     * Height of the drawn rectangle and hit box.
     */
    protected int height;
    /**
     * Colour to draw the background rectangle with.
     */
    protected Color backgroundColour;
    /**
     * Only draws the button if true.
     */
    protected boolean draw;
    /**
     * A code to check for when isClicked was true to use for determining what should happen.
     */
    protected int actionCode;

    /**
     * Creates a simple button ready to use with the specified properties.
     *
     * @param x X coordinate.
     * @param y Y coordinate.
     * @param width Width of the drawn rectangle and hit box.
     * @param height Height of the drawn rectangle and hit box.
     * @param backgroundColour Colour to draw the background rectangle with.
     * @param draw Only draws the button if true.
     * @param actionCode A code to check for when isClicked was true to use for determining what should happen.
     */
    public SimpleButton(int x, int y, int width, int height, Color backgroundColour, boolean draw, int actionCode) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.backgroundColour = backgroundColour;
        this.draw = draw;
        this.actionCode = actionCode;
    }

    /**
     * Tests if the specified mouse coordinate is inside the bounds of this button.
     *
     * @param mouseX X coordinate of the mouse.
     * @param mouseY Y coordinate of the mouse.
     * @return True of the coordinate is inside the hit box of this button.
     */
    public boolean isClicked(int mouseX, int mouseY) {
        return !(mouseX < x || mouseY < y || mouseX > x+width || mouseY > y + height);
    }

    /**
     * Gets the custom result code to inform some custom action when clicked.
     *
     * @return The custom result code stored in the button.
     */
    public int getActionCode() {
        return actionCode;
    }

    /**
     * Does nothing if draw is false.
     * Draws the rectangle with properties specified in the class.
     *
     * @param g Reference to the Graphics object for rendering.
     */
    public void paint(Graphics g) {
        if(!draw) return;
        g.setColor(backgroundColour);
        g.fillRect(x, y, width, height);
    }
}
