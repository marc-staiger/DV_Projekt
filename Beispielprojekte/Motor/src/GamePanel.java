import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Master Mind
 * Author: Peter Mitchell (2021)
 *
 * GamePanel class:
 * Manages the game state to draw attempts and handle mouse interaction to
 * change between game states.
 */
public class GamePanel extends JPanel implements MouseListener {
    /**
     * The game states include:
     * Playing: allows mouse input to play the game.
     * GameWon: When a correct combination is entered and submit is hit.
     * GameLost: When the maximum number of attempts has been made.
     */
    public enum GameState {Playing, GameWon, GameLost};

    /**
     * Increases the number of rows to this number, and once this number's count of
     * attempts have been made the game ends.
     */
    private static final int MAXIMUM_ATTEMPTS = 12;
    /**
     * A constant panel height based on the max number of attempts allowed and the height of the puzzle display.
     */
    public static final int PANEL_HEIGHT = MAXIMUM_ATTEMPTS * PuzzleCombination.CELL_SIZE;
    /**
     * All the attempts that have been made so far including the current attempt.
     */
    private List<AttemptPanel> attempts;
    /**
     * Reference to the current attempt for applying mouse interaction.
     */
    private AttemptPanel currentAttempt;
    /**
     * Reference to the solution for matching, and for displaying when cheats are active.
     */
    private PuzzleCombination solution;
    /**
     * Shared random reference for generating the solution/s.
     */
    private Random rand;
    /**
     * A collection of all the clickable regions for cycling puzzle combinations.
     */
    private List<SimpleButton> buttons;
    /**
     * The submit button for submitting the current attempt and swapping to a won state
     * or swapping to a game over state, or just adding another new attempt.
     */
    private SimpleTextButton submitButton;
    /**
     * The current game state. Defaults to Playing and changes state when the game ends.
     * R will reset the game state back to default.
     */
    private GameState gameState;
    /**
     * Reference to the game overlay shown when the state changes to GameWon or GameLost.
     */
    private GameEndedPanel gameEndedPanel;
    /**
     * When true will show the solution.
     */
    private boolean showCheat = false;

    /**
     * Configures the game ready to start by initialising all the buttons, panels,
     * and setting up a new puzzle with a solution and the first attempt.
     */
    public GamePanel() {
        setPreferredSize(new Dimension(AttemptPanel.PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.GRAY);
        rand = new Random();
        createButtons();
        gameEndedPanel = new GameEndedPanel();
        restart();
        addMouseListener(this);
    }

    /**
     * Wipes all state data from any previous playing. Then generates a new solution,
     * and prepares a new attempt ready for play to start.
     */
    public void restart() {
        attempts = new ArrayList<>();
        // Remove reference to let addNewAttempt() set it up.
        currentAttempt = null;
        generateSolution();
        addNewAttempt();
        gameState = GameState.Playing;
    }

    /**
     * Moves all attempts up visually, and adds a new AttemptPanel to the attempts.
     */
    public void addNewAttempt() {
        // Handle the case where a new game is beginning
        if(currentAttempt == null) {
            currentAttempt = new AttemptPanel(solution,PANEL_HEIGHT-PuzzleCombination.CELL_SIZE);
        } else {
            for(AttemptPanel attemptPanel : attempts) {
                attemptPanel.moveUp();
            }
            // Use the previous attempts combination as a starting point
            currentAttempt = new AttemptPanel(new PuzzleCombination(attempts.get(attempts.size()-1).getPuzzleCombination()),
                    attempts.size()+1, solution,PANEL_HEIGHT-PuzzleCombination.CELL_SIZE);
        }
        attempts.add(currentAttempt);
    }

    /**
     * Generates a solution based on the combination length and number of colours available in the puzzle combination class.
     */
    public void generateSolution() {
        int[] solutionValues = new int[PuzzleCombination.COMBINATION_LENGTH];
        for(int i = 0; i < solutionValues.length; i++) {
            solutionValues[i] = rand.nextInt(PuzzleCombination.NUMBER_OF_COLOURS);
        }
        solution = new PuzzleCombination(solutionValues,
                AttemptPanel.PANEL_WIDTH / 2 - PuzzleCombination.PANEL_WIDTH / 2, PANEL_HEIGHT / 2);
        gameEndedPanel.setSolution(solution);
    }

    /**
     * Toggles whether the solution is visible.
     */
    public void toggleCheat() {
        showCheat = !showCheat;
    }

    /**
     * Draws lines between attempts, all the attempts that have been added.
     * If the game is playing it will show the submitButton, otherwise the game ended panel.
     * Lastly draws the solution if showCheat is active.
     *
     * @param g Reference to the Graphics object for drawing.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int i = 1; i < MAXIMUM_ATTEMPTS; i++) {
            g.drawLine(0,i*PuzzleCombination.CELL_SIZE, AttemptPanel.PANEL_WIDTH, i*PuzzleCombination.CELL_SIZE);
        }
        for(AttemptPanel attemptPanel : attempts) {
            attemptPanel.paint(g);
        }
        if(gameState == GameState.Playing)
            submitButton.paint(g);
        else
            gameEndedPanel.paint(g);
        if(showCheat)
            solution.paint(g);
    }

    /**
     * Handles the mouse being clicked inside the panel. Does nothing if the game state is not playing.
     * Clicking the submit button will use handleSubmitClicked() to check the solution and change game state.
     * Clicking on any of the puzzle buttons for the current attempt will cycle up with left mouse or
     * cycle down with right mouse.
     * Finally it will repaint() to show updates.
     *
     * @param e Mouse event data.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(gameState != GameState.Playing) return;

        int x = e.getX();
        int y = e.getY();
        if(submitButton.isClicked(x,y)) {
            handleSubmitClicked();
        } else {
            checkForCycleButton(x,y,e.getButton() == MouseEvent.BUTTON1);
        }
        repaint();
    }

    /**
     * Creates the submit button and invisible buttons for all the puzzle combination changing.
     */
    private void createButtons() {
        buttons = new ArrayList<>();
        int y = PANEL_HEIGHT-PuzzleCombination.CELL_SIZE;
        submitButton = new SimpleTextButton(AttemptPanel.TEXT_OFFSET_WIDTH+PuzzleCombination.PANEL_WIDTH, y
                , ResultPanel.PANEL_WIDTH, PuzzleCombination.CELL_SIZE,
                Color.DARK_GRAY, true, -1,"Submit", Color.BLACK, new Font("Arial",Font.BOLD,40));
        int x = AttemptPanel.TEXT_OFFSET_WIDTH;
        for(int i = 0; i < PuzzleCombination.COMBINATION_LENGTH; i++) {
            buttons.add(new SimpleButton(x,y,PuzzleCombination.CELL_SIZE, PuzzleCombination.CELL_SIZE,Color.PINK,true,i));
            x += PuzzleCombination.CELL_SIZE;
        }
    }

    /**
     * Checks if the current attempt matches the solution to change to a won state.
     * Otherwise checks if the maximum attempts have been used to change to a loss state.
     * In any other case it will add a new attempt with addNewAttempt().
     */
    private void handleSubmitClicked() {
        if(currentAttempt.getIsVictory()) {
            gameState = GameState.GameWon;
            gameEndedPanel.setVictory(true);
        } else if(attempts.size() < MAXIMUM_ATTEMPTS) {
            addNewAttempt();
        } else {
            gameState = GameState.GameLost;
            gameEndedPanel.setVictory(false);
        }
    }

    /**
     * Tests all the buttons for clicks and if a match is found it will cycle up with left mouse,
     * or cycle down with right mouse.
     *
     * @param x Mouse X coordinate.
     * @param y Mouse Y coordinate.
     * @param isLeft Is left mouse button.
     */
    private void checkForCycleButton(int x, int y, boolean isLeft) {
        for(SimpleButton button : buttons) {
            if(button.isClicked(x,y)) {
                currentAttempt.cycleCombination(button.getActionCode(),isLeft);
                break;
            }
        }
    }

    /**
     * Not used.
     *
     * @param e Not used.
     */
    @Override
    public void mousePressed(MouseEvent e) {}
    /**
     * Not used.
     *
     * @param e Not used.
     */
    @Override
    public void mouseReleased(MouseEvent e) {}
    /**
     * Not used.
     *
     * @param e Not used.
     */
    @Override
    public void mouseEntered(MouseEvent e) {}
    /**
     * Not used.
     *
     * @param e Not used.
     */
    @Override
    public void mouseExited(MouseEvent e) {}
}
