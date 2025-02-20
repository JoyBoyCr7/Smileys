import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Smileys2 extends JFrame {
    int locX, locY, size; 
    Color headColor = Color.red, eyeColor = Color.red;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Smileys2 frame = new Smileys2();
            frame.setSize(new Dimension(600, 600));
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.drawSmileyFace(100, 200, 200, Color.BLACK, Color.BLACK);
        });
    }

    public void drawSmileyFace(int locX, int locY, int size, Color headColor, Color eyeColor) {
        this.locX = locX; // Use the passed parameters
        this.locY = locY;
        this.size = size;
        this.headColor = headColor;
        this.eyeColor = eyeColor;
        repaint(); // Request to repaint the frame
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(headColor);
        g.fillOval(locX, locY, size, size); // Draw the head

        // Draw eyes
        int eyeSize = size / 10; // Adjust eye size as needed
        g.setColor(eyeColor);
        g.fillOval(locX + size / 4, locY + size / 4, eyeSize, eyeSize); // Left eye
        g.fillOval(locX + (size * 3 / 4) - eyeSize, locY + size / 4, eyeSize, eyeSize); // Right eye

        // Draw mouth
        g.setColor(Color.BLACK);
        g.drawArc(locX + size / 4, locY + size / 2, size / 2, size / 4, 0, -180); // Mouth
    }
}