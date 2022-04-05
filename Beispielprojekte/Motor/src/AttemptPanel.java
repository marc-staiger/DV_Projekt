import java.awt.*;

/**
 * Master Mind
 * Author: Peter Mitchell (2021)
 *
 * AttemptPanel class:
 * Contains a single line consisting of the attempt number,
 * the attempt for this line, and results to show how the attempt was scored.
 */
public class AttemptPanel {
    /**
     * Constant to define the padding at the beginning of the panel to fit the attempt number.
     */
    public static final int TEXT_OFFSET_WIDTH = 50;
    /**
     * Font for drawing the attempt number.
     */
    private static final Font font = new Font("Arial", Font.BOLD, 40);
    /**
     * Constant width of the panel for use by other interface elements.
     */
    public static final int PANEL_WIDTH = TEXT_OFFSET_WIDTH + PuzzleCombination.PANEL_WIDTH + ResultPanel.PANEL_WIDTH;

    /**
     * The data representation of this attempt.
     */
    private PuzzleCombination puzzleCombination;
    /**
     * Status of the puzzle combination.
     */
    private ResultPanel resultPanel;
    /**
     * Number shown for the attempt number of this panel.
     */
    private String attemptNumber;
    /**
     * Vertical offset for drawing elements.
     */
    private int yOffset;

    /**
     * Create the panel with all elements ready to be drawn and used.
     *
     * @param puzzleCombination Data representation for this attempt.
     * @param attemptNumber The number of this attempt.
     * @param solution The solution for doing validation in the resultPanel.
     * @param yOffset Vertical offset for drawing.
     */
    public AttemptPanel(PuzzleCombination puzzleCombination, int attemptNumber, PuzzleCombination solution, int yOffset) {
        this.puzzleCombination = puzzleCombination;
        puzzleCombination.setYOffset(yOffset);
        resultPanel = new ResultPanel(puzzleCombination, solution,
                                TEXT_OFFSET_WIDTH+PuzzleCombination.PANEL_WIDTH, yOffset);
        this.attemptNumber = String.valueOf(attemptNumber);
        this.yOffset = yOffset;
    }

    /**
     * Shorter constructor to be used when there is no previous attempt so that it defaults to
     * attempt number 1, and combination set to 0 for all elements.
     *
     * @param solution The solution for this puzzle.
     * @param yOffset The vertical offset for drawing.
     */
    public AttemptPanel(PuzzleCombination solution, int yOffset) {
        this(new PuzzleCombination(new int[PuzzleCombination.COMBINATION_LENGTH], TEXT_OFFSET_WIDTH, yOffset),
                1, solution, yOffset);
    }

    /**
     * Cycles the puzzle combination at the specified index by one,
     * and then validates the result in the result panel.
     *
     * @param index Index to cycle to the next position.
     */
    public void cycleCombination(int index, boolean cycleUp) {
        puzzleCombination.cycleCombination(index, cycleUp);
        resultPanel.validateAttempt();
    }

    /**
     * Gets a reference to the puzzle combination for this attempt.
     *
     * @return The puzzle data representation.
     */
    public PuzzleCombination getPuzzleCombination() {
        return puzzleCombination;
    }

    /**
     * Changes the vertical offset by shifting it up by CELL_SIZE.
     */
    public void moveUp() {
        yOffset -= PuzzleCombination.CELL_SIZE;
        puzzleCombination.setYOffset(yOffset);
        resultPanel.setYOffset(yOffset);
    }

    /**
     * Tests if the game has been won.
     *
     * @return True if the game has been won.
     */
    public boolean getIsVictory() {
        return resultPanel.getIsVictory();
    }

    /**
     * Draws the number, puzzle combination, and result data.
     *
     * @param g Reference to the Graphics object for rendering.
     */
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(attemptNumber,5,yOffset+35);
        puzzleCombination.paint(g);
        resultPanel.paint(g);
    }
}
