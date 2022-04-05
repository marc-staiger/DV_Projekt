import java.awt.*;

/**
 * Master Mind
 * Author: Peter Mitchell (2021)
 *
 * ResultPanel class:
 * Shows the state of the associated puzzle attempt as a pair of
 * strings including the number of combination positions with the
 * correct colour and pos, and those with a correct colour, but in
 * a wrong pos.
 */
public class ResultPanel {
    /**
     * Constant width of the panel used for sizing calculations in other classes.
     */
    public static final int PANEL_WIDTH = 300;

    /**
     * The attempt associated with this result panel.
     */
    private PuzzleCombination puzzleAttempt;
    /**
     * Reference to the solution for comparison.
     */
    private PuzzleCombination solution;
    /**
     * Used to notify if the puzzle combination was correct after validation.
     */
    private boolean victory = false;
    /**
     * Position to offset strings for drawing.
     */
    private int xOffset;
    /**
     * Position to offset strings for drawing.
     */
    private int yOffset;
    /**
     * Font for drawing the two messages.
     */
    private Font font = new Font("Arial", Font.BOLD, 20);
    /**
     * Message for showing the correct pos and colour.
     */
    private String correctPosAndColourStr = "Correct Colour and Pos: ";
    /**
     * Message for showing the correct colour, but wrong pos.
     */
    private String correctColourWrongPosStr = "Correct Colour Wrong Pos: ";
    /**
     * The number of combination positions that have both correct position and colour.
     */
    private int correctPosAndColour = 0;
    /**
     * The number of combination positions that have a correct colour, but is in the wrong position.
     */
    private int correctColourWrongPos = 0;

    /**
     * Stores all the provided data and validates the puzzle to generate result outputs.
     *
     * @param puzzleAttempt Reference to the puzzle attempt to show results for.
     * @param solution Reference to the solution for validating the attempt.
     * @param xOffset X coordinate to offset strings with.
     * @param yOffset Y coordinate to offset strings with.
     */
    public ResultPanel(PuzzleCombination puzzleAttempt, PuzzleCombination solution, int xOffset, int yOffset) {
        this.puzzleAttempt = puzzleAttempt;
        this.solution = solution;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        validateAttempt();
    }

    /**
     * Sets the Y coordinate offset for drawing the strings.
     *
     * @param yOffset The new offset to set this panel to for vertical drawing.
     */
    public void setYOffset(int yOffset) {
        this.yOffset = yOffset;
    }

    /**
     * Validates the puzzle combination against the solution to check the
     * quantity of correct position and colour, and the quantity of
     * correct colour, but wrong position.
     */
    public void validateAttempt() {
        // Assume the attempt is not the solution
        victory = false;
        // Create arrays to store counts of numbers not used for a correctPosAndColour count
        int[] excessCounter = new int[PuzzleCombination.NUMBER_OF_COLOURS];
        int[] unusedSolutionCounter = new int[PuzzleCombination.NUMBER_OF_COLOURS];
        correctPosAndColour = 0;
        for(int i = 0; i < PuzzleCombination.COMBINATION_LENGTH; i++) {
            if(solution.getCombination()[i] == puzzleAttempt.getCombination()[i])
            {
                correctPosAndColour++;
            } else {
                // stores the unused numbers for later iteration
                excessCounter[puzzleAttempt.getCombination()[i]]++;
                unusedSolutionCounter[solution.getCombination()[i]]++;
            }
        }
        // Use the number of unused numbers from solution and attempt to find the number of
        // correct Colour elements in the wrong position
        correctColourWrongPos = 0;
        for(int i = 0; i < PuzzleCombination.NUMBER_OF_COLOURS; i++) {
            correctColourWrongPos += Math.min(unusedSolutionCounter[i],excessCounter[i]);
        }
        // If every position has the correct colour the puzzle matches the solution
        if(correctPosAndColour == PuzzleCombination.COMBINATION_LENGTH) {
            victory = true;
        }
    }

    /**
     * Checks if the attempt was correct to trigger a victory.
     *
     * @return True if the puzzle attempt matches the solution.
     */
    public boolean getIsVictory() {
        return victory;
    }

    /**
     * Draws the two messages showing the state of the puzzle attempt.
     *
     * @param g Reference to the Graphics object for rendering.
     */
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(correctPosAndColourStr + correctPosAndColour, xOffset, yOffset+17);
        g.drawString(correctColourWrongPosStr + correctColourWrongPos, xOffset, yOffset+37);
    }
}
