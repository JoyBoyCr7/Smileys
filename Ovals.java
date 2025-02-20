import javax.swing.*;
import java.awt.*;

public class Ovals extends JFrame {
    int x, y, size;
    final int TOP_OFFSET = 31;
    final int LEFT_OFFSET = 9;
    final int RIGHT_OFFSET = LEFT_OFFSET;
    final int BOTTOM_OFFSET = LEFT_OFFSET;
    
    //create constants to avoid magic numbers
    public static void main(String[]args){
        Ovals frame=new Ovals();
        frame.setSize(new Dimension(1000,800));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.initializeVariables();

        frame.setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
        //invoke or make a call to
        // randomOvals with the values from thevariables.
        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        System.out.println("X: "+x+" Y: "+ y+" Size: "+ size);
        Color myColor = makeRandomColor();
        randomOvals(x, y, size, g2d, myColor);
        //reset the values held in the variables with new randoms


        initializeVariables(getWidth() , getHeight(), (int)(getWidth() * .1), (int)(getWidth() * .3));
        //Make call to randomOvals again with new values.
        // This will draw the ovals
        // in new locations with new height and width.
        randomOvals(x,y,size, g2d,makeRandomColor());

        g2d.fillOval(9, 31, 100, 100);


    }

    public void initializeVariables(){
        //initialize my variables.
        x=(int)(Math.random()*300)+1;
        y=(int)(Math.random()*300)+1;
        size=(int)(150+(Math.random()*(300-150))+1);
        System.out.println("X:"+x+"Y:"+y);

    }

    public void initializeVariables(int xLimit, int yLimit){
        //initialize my variables.
        x=(int)(Math.random()*xLimit)+1;
        y=(int)(Math.random()*yLimit)+1;
        size=(int)(xLimit / 2 + (Math.random()*(xLimit - xLimit / 2 +1)));
        System.out.println("X:"+x+"Y:"+y);

    }

    public void initializeVariables(int xLimit, int yLimit, int ovalMinSize, int ovalMaxSize){
        //initialize my variables.
        size = randomInRange(ovalMinSize, ovalMaxSize);
        x =  randomInRange(LEFT_OFFSET, xLimit - size - RIGHT_OFFSET);
        y = randomInRange(TOP_OFFSET, yLimit - size - BOTTOM_OFFSET);
        System.out.println("X:"+x+"Y:"+y);

    }

    public int randomInRange(int min, int max){
        return (int)(min+ (Math.random()*(max - min + 1)));
    }


    //method to draw an oval
    public void randomOvals(int x, int y, int size, Graphics g, Color color)
    {
        g.setColor(color);
        System.out.println("X: "+x+" Y: "+ y+" Size: "+ size);
        g.drawOval(x, y, size, size);
        //I am using the x, y , h, and w and setting them
        // relative to theoriginal values.
        g.drawOval((int)(x + size * .25), (int)(y + size * .25),(int)(size - size*.80), (int)(size - size*.80));
    }
    public Color makeRandomColor(){
        int r= randomInRange(0, 255);
        int gr= randomInRange(0, 255);
        int b= randomInRange(0, 255);
        Color eyeColor=new Color(r, gr, b);
        return eyeColor;
    }
}