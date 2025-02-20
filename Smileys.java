import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**Smiley Project
 *@author Ronard Nyongkah
 *@version Spring 2025
 *CSci1130
*/

public class Smileys extends JFrame {
    double dNum1, dNum2;
    int iNum;
    int min, max, size;
    int x, y, hight, width;
    Graphics2D g;

    final int TOP_OFFSET = 31;
    final int LEFT_OFFSET = 9;
    final int RIGHT_OFFSET = LEFT_OFFSET;
    final int BOTTOM_OFFSET = LEFT_OFFSET;

    
    public static void main(String[] args) {
        Smileys frame =  new Smileys();
        frame.setSize(new Dimension(600,600));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }

    public void paint(Graphics g){
        super.paint(g);


        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        
        // The first line on 37 sets the variables and line 38 uses those variables to create our new smiley face
        // The same this is repeated for each smiley face
        initializeVariables(getWidth() , getHeight(), (int)(getWidth() * .1), (int)(getWidth() * .4));
        drawSmileyFace(x, y, size, g2d, makeRandomColor() );

        initializeVariables(getWidth() , getHeight(), (int)(getWidth() * .1), (int)(getWidth() * .4));
        drawSmileyFace(x, y, size, g2d, makeRandomColor() );

        initializeVariables(getWidth() , getHeight(), (int)(getWidth() * .1), (int)(getWidth() * .4));
        drawSmileyFace(x, y, size, g2d, makeRandomColor() );

        initializeVariables(getWidth() , getHeight(), (int)(getWidth() * .1), (int)(getWidth() * .4));
        drawSmileyFace(x, y, size, g2d, makeRandomColor() );

        initializeVariables(getWidth() , getHeight(), (int)(getWidth() * .1), (int)(getWidth() * .4));
        drawSmileyFace(x, y, size, g2d, makeRandomColor() );

        initializeVariables(getWidth() , getHeight(), (int)(getWidth() * .1), (int)(getWidth() * .4));
        drawSmileyFace(x, y, size, g2d, makeRandomColor() );
    }

  
    // This method is used to create each face
    public void drawSmileyFace(int locX, int locY, int size, Graphics g, Color color)
    {
        g.setColor(color);
        System.out.println("X: "+locX+" Y: "+ locY+" Size: "+ size);
        g.fillOval(locX, locY, size, size);
       
        g.setColor(makeRandomColor());
        g.fillOval((int)(locX + size * .15), (int)(locY + size * .25),(int)(size - size*.80), (int)(size - size*.80));

        g.fillOval((int)(locX + size * .67), (int)(locY + size * .25),(int)(size - size*.80), (int)(size - size*.80));
        
        g.fillArc((int)(locX + size * .15), (int)(locY + size * .35), (int)(size * .70), (int)(size * .50), 180, 180);

    }

    public void initializeVariables(int xLimit, int yLimit, int ovalMinSize, int ovalMaxSize){
        //initialize my variables.
        size = randomInRange(ovalMinSize, ovalMaxSize);
        x =  randomInRange(LEFT_OFFSET, xLimit - size - RIGHT_OFFSET);
        y = randomInRange(TOP_OFFSET, yLimit - size - BOTTOM_OFFSET);
        System.out.println("X:"+x+"Y:"+y);
    
    }
    // returns a random number within the min and max
    public int randomInRange(int min, int max){
        return (int)(min+ (Math.random()*(max - min + 1)));
    }

    public Color makeRandomColor(){
        int r= randomInRange(0, 255);
        int gr= randomInRange(0, 255);
        int b= randomInRange(0, 255);
        Color eyeColor=new Color(r, gr, b);
        return eyeColor;
    }
   
}