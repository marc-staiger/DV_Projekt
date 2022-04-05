import java.awt.*;

/**
 * Master Mind
 * Author: Peter Mitchell (2021)
 *
 * SimpleTextButton class:
 * Extends the SimpleButton to overlay some text.
 */
public class SimpleTextButton extends SimpleButton {
    /**
     * Font to draw the text with.
     */
    private Font font;
    /**
     * Text to draw centred on the button.
     */
    private String text;
    /**
     * Colour to draw the text with.
     */
    private Color textColour;

    /**
     * Creates a simple button including some centred text with specified properties.
     *
     * @param x X coordinate.
     * @param y Y coordinate.
     * @param width Width of the drawn rectangle and hit box.
     * @param height Height of the drawn rectangle and hit box.
     * @param backgroundColour Colour to draw the background rectangle with.
     * @param draw Only draws the button if true.
     * @param actionCode A code to check for when isClicked was true to use for determining what should happen.
     * @param text Text to draw centred on the button.
     * @param textColour Colour to draw the text with.
     * @param font Font to draw the text with.
     */
    public SimpleTextButton(int x, int y, int width, int height, Color backgroundColour, boolean draw, int actionCode,
                            String text, Color textColour, Font font) {
        super(x, y, width, height, backgroundColour, draw, actionCode);
        this.text = text;
        this.textColour = textColour;
        this.font = font;
    }

    /**
     * Does nothing if draw is false.
     * Draws the background rectangle from the SimpleButton.
     * Then draws the specified string centred in the button.
     *
     * @param g Reference to the Graphics object for rendering.
     */
    @Override
    public void paint(Graphics g) {
        if(!draw) return;
        super.paint(g);
        g.setColor(textColour);
        g.setFont(font);
        int fontWidth = g.getFontMetrics().stringWidth(text);
        g.drawString(text,x+width/2-fontWidth/2,y+35);
    }
}
