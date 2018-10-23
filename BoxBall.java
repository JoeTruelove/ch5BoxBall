import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
/**
 * Create balls that bounce within a set param
 *
 * @author Joseph Truelove
 * @version 2018.10.22
 */
public class BoxBall
{
    
    private Ellipse2D.Double circle;
    private int xPosition;
    private int yPosition;
    private int diameter;
    private Canvas canvas;
    private Color color;
    private final int groundPosition;
    private Random random = new Random();
    private int ySpeed = random.nextInt(7) + 1;
    private int xSpeed = random.nextInt(7) + 1;
    

    /**
     * Constructor for BoxBall
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
    
    /**
     * draws the ball
     */
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }
    
    /**
     * erase the ball
     */
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }   
    
    /**
     * creates a pattern for how the ball moves and interacts with walls
     */
    public void move()
    {
        // remove from canvas at the current position
        erase();
        
        int height = 400;
        int width = 550;
        yPosition += ySpeed;
        xPosition += xSpeed;
        
        // check if it has hit the walls
        if(yPosition > (height - diameter)) {
            yPosition = height - diameter;
            ySpeed = -ySpeed; 
            
        }
        if(yPosition < 100)   {
            yPosition = 100;
            ySpeed = -ySpeed;
        }
        if(xPosition < 50)   {
            xPosition = 50;
            xSpeed = -xSpeed;
        }
        if(xPosition > (width - diameter))  {
            xPosition = width - diameter;
            xSpeed = -xSpeed;
        }
        // draw again at new position
        draw();
    }  
    
    /**
     * get the x Position
     */
    public int getXPosition()
    {
        return xPosition;
    }
    
    /**
     * get the y Position
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
