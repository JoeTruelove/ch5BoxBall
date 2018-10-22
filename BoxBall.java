import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
/**
 * Write a description of class BoxBall here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BoxBall
{
    // instance variables - replace the example below with your own
    private static final int GRAVITY = 3;
    
    private Ellipse2D.Double circle;
    private int xPosition;
    private int yPosition;
    private int diameter;
    private Canvas canvas;
    private Color color;
    private final int groundPosition;
    private Random random = new Random();
    private int ySpeed = random.nextInt(8);
    private int xSpeed = random.nextInt(8);
    private int ballDegradation = 2;

    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor, 
                   int groundPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        canvas = drawingCanvas;
    }
    
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }
    
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }   
    
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        int height = 400;
        int width = 200;
        yPosition += ySpeed;
        xPosition += xSpeed;
        xPosition += 2;
        yPosition += 2;
        
        if(xSpeed == 0 || ySpeed == 0)  {
            xSpeed++;
            ySpeed++;
        }
        // check if it has hit the ground
        if(yPosition > (height - diameter)) {
            yPosition = height - diameter;
            ySpeed = -ySpeed; 
            
        }
        if(yPosition < 0)   {
            
            ySpeed = -ySpeed;
        }
        if(xPosition < 0)   {
            
            xSpeed = -xSpeed;
        }
        if(xPosition > (width - diameter))  {
            xPosition = width - diameter;
            xSpeed = -xSpeed;
        }
        // draw again at new position
        draw();
    }  
    
    public int getXPosition()
    {
        return xPosition;
    }
    
    public int getYPosition()
    {
        return yPosition;
    }
}
