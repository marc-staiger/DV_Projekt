import java.awt.*;

/**
 * Master Mind
 * Author: Peter Mitchell (2021)
 *
 * Stores and draws a combination of colours.
 */
public class PuzzleCombination {
    /**
     * The height and width of each individual puzzle item.
     */
    public static final int CELL_SIZE = 40;
    /**
     * List of the colours to use for visualising the pattern.
     */
    private static final Color[] ID_TO_COLOUR = { Color.WHITE, Color.BLACK, Color.RED, Color.ORANGE, Color.BLUE, Color.GREEN };
    /**
     * Number of colours available to be used by other classes.
     */
    public static final int NUMBER_OF_COLOURS = ID_TO_COLOUR.length;
    /**
     * The number of elements in the combination.
     */
    public static int COMBINATION_LENGTH = 4;
    /**
     * Constant panel width calculated from the combination length and the cell size.
     */
    public static final int PANEL_WIDTH = COMBINATION_LENGTH * CELL_SIZE;
    /**
     * The combination stored in this puzzle.
     */
    private int[] combination;
    /**
     * Drawing offset on the horizontal axis.
     */
    private int xOffset;
    /**
     * Drawing offset on the vertical axis.
     */
    private int yOffset;

    /**
     * Creates a puzzle combination object with the specified settings.
     *
     * @param combination The combination to store in this puzzle combination.
     * @param xOffset Drawing offset on the horizontal axis.
     * @param yOffset Drawing offset on the vertical axis.
     */
    public PuzzleCombination(int[] combination, int xOffset, int yOffset) {
        this.combination = combination;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    /**
     * Copy constructor to duplicate an existing puzzle.
     *
     * @param puzzleCombination PuzzleCombination to copy.
     */
    public PuzzleCombination(PuzzleCombination puzzleCombination) {
        this.combination = new int[puzzleCombination.combination.length];
        for(int i = 0; i < combination.length; i++) {
            combination[i] = puzzleCombination.combination[i];
        }
        this.xOffset = puzzleCombination.xOffset;
        this.yOffset = puzzleCombination.yOffset;
    }

    /**
     * Iterates through the colours by cycling up or down.
     *
     * @param position The position in the combination to modify.
     * @param cycleUp Cycle up if true, cycle down if false.
     */
    public void cycleCombination(int position, boolean cycleUp) {
        if(cycleUp) {
            combination[position]++;
            combination[position] = combination[position] % NUMBER_OF_COLOURS;
        } else {
            combination[position]--;
            if(combination[position] < 0)
                combination[position] = NUMBER_OF_COLOURS - 1;
        }
    }

    /**
     * Moves the vertical position for drawing.
     *
     * @param yOffset The vertical offset to draw at.
     */
    public void setYOffset(int yOffset) {
        this.yOffset = yOffset;
    }

    /**
     * Gets the combination stored for comparison.
     *
     * @return The combination stored in this attempt.
     */
    public int[] getCombination() {
        return combination;
    }

    /**
     * Draws the coloured ovals to represent the combination stored.
     *
     * @param g Reference to the Graphics object for rendering.
     */
    public void paint(Graphics g) {
        for(int i = 0; i < combination.length; i++) {
            g.setColor(ID_TO_COLOUR[combination[i]]);
            g.fillOval(xOffset+i*CELL_SIZE,yOffset,CELL_SIZE,CELL_SIZE);
        }
    }
}
