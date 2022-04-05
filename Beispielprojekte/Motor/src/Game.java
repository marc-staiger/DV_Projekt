import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Master Mind
 * Author: Peter Mitchell (2021)
 *
 * Game class:
 * Entry point to create the frame, and pass key events.
 */
public class Game implements KeyListener {
    /**
     * Creates the game to start it.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {
        Game game = new Game();
    }

    /**
     * Reference to the game panel to pass key events to it.
     */
    private GamePanel gamePanel;

    /**
     * Creates the JFrame and sets up the GamePanel to manage all the game state.
     */
    public Game() {
        JFrame frame = new JFrame("Master Mind");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        gamePanel = new GamePanel();
        frame.getContentPane().add(gamePanel);

        frame.addKeyListener(this);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Handles R to restart, Escape to quit, and C to toggle the cheat mode.
     *
     * @param e Information about the key that was pressed.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_R) {
            gamePanel.restart();
            gamePanel.repaint();
        } else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        } else if(e.getKeyCode() == KeyEvent.VK_C) {
            gamePanel.toggleCheat();
            gamePanel.repaint();
        }
    }

    /**
     * Not used.
     *
     * @param e Not used.
     */
    @Override
    public void keyTyped(KeyEvent e) {}
    /**
     * Not used.
     *
     * @param e Not used.
     */
    @Override
    public void keyReleased(KeyEvent e) {}
}
