import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class gameengine extends JFrame {

    private int playerX = 50;
    private int playerY = 50;
    private String keyPressedText = "";

    public gameengine() {
        setTitle("Simple Game Engine");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });

        setFocusable(true);
    }

    private void handleKeyPress(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keyPressedText = "Key Pressed: " + KeyEvent.getKeyText(keyCode);

        int speed = 5;

        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                playerX -= speed;
                break;
            case KeyEvent.VK_RIGHT:
                playerX += speed;
                break;
            case KeyEvent.VK_UP:
                playerY -= speed;
                break;
            case KeyEvent.VK_DOWN:
                playerY += speed;
                break;
            case KeyEvent.VK_SPACE:
                // Perform action for SPACE key (e.g., shoot)
                break;
            case KeyEvent.VK_SHIFT:
                // Perform action for SHIFT key (e.g., sprint)
                break;
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawGame(g);
    }

    private void drawGame(Graphics g) {
        // Draw the player
        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, 50, 50);

        // Display the pressed key text on the screen
        g.setColor(Color.BLACK);
        g.drawString(keyPressedText, 10, 20);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            gameengine game = new gameengine();
            game.setVisible(true);
        });
    }
}
