import java.awt.*;

/**
 * Master Mind:
 * Author: Peter Mitchell (2021)
 *
 * GameEndedPanel class:
 * Represents an overlay dialogue that shows a
 * victory or loss message when the game has ended.
 */
public class GameEndedPanel {
    /**
     * X coordinate representing the centre.
     */
    private int x;
    /**
     * Y coordinate representing the centre.
     */
    private int y;
    /**
     * Width of the background.
     */
    private int width;
    /**
     * Height of the background.
     */
    private int height;
    /**
     * Changes the message between a won/loss message.
     */
    private boolean victory;
    /**
     * The solution to be drawn as part of the dialogue.
     */
    private PuzzleCombination solution;

    /**
     * Font used for drawing all the text in the panel.
     */
    private Font gameEndFont = new Font("Arial", Font.BOLD, 20);
    /**
     * Message displayed when victory has been achieved.
     */
    private String endLineSuccess = "You won! :D";
    /**
     * Message displayed when game was lost (victory not achieved).
     */
    private String endLineLoss = "You lost! :(";
    /**
     * Middle text line to show how to change the state.
     */
    private String endLine1 = "Press R to Restart!";
    /**
     * Bottom line of text to show a descriptive element saying that below it is the solution.
     */
    private String endLine2 = "Solution was:";

    /**
     * Sets up the size and position to use for the rendering.
     */
    public GameEndedPanel() {
        this.x = AttemptPanel.PANEL_WIDTH/2;
        this.y = GamePanel.PANEL_HEIGHT/2;
        this.width = 200;
        this.height = 100;
    }

    /**
     * Changes the message that will be displayed by the panel.
     *
     * @param victory True will display the won message, false will display the loss message.
     */
    public void setVictory(boolean victory) {
        this.victory = victory;
    }

    /**
     * Sets the reference to the solution so it can be drawn on top of the panel.
     *
     * @param solution Reference to the solution for rendering as part of the panel.
     */
    public void setSolution(PuzzleCombination solution) {
        this.solution = solution;
    }

    /**
     * Draws a background with won/loss message, how to restart, and the solution.
     *
     * @param g Reference to the Graphics object for rendering.
     */
    public void paint(Graphics g) {
        g.setColor(new Color(213, 180, 112, 230));
        g.fillRect(x-width/2, y-height/2-30,width,height+30);
        g.setFont(gameEndFont);
        int strWidth;
        if(victory) {
            g.setColor(new Color(36, 76, 19));
            strWidth = g.getFontMetrics().stringWidth(endLineSuccess);
            g.drawString(endLineSuccess, x-strWidth/2, y-55);
        } else {
            g.setColor(new Color(104, 15, 15));
            strWidth = g.getFontMetrics().stringWidth(endLineLoss);
            g.drawString(endLineLoss, x-strWidth/2, y-55);
        }
        g.setColor(Color.BLACK);
        strWidth = g.getFontMetrics().stringWidth(endLine1);
        g.drawString(endLine1, x-strWidth/2, y-30);
        strWidth = g.getFontMetrics().stringWidth(endLine2);
        g.drawString(endLine2, x-strWidth/2, y-5);
        solution.paint(g);
    }
}
