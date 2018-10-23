
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 * Class BallDemo - creates a new canvas and allows either to bounce a ball or to bounce balls in a box 
 * Canvas class. 
 *
 *
 * @author Joseph Truelove
 * @version 2018.10.22
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BoxBall> balls;
    private Random rand = new Random(); 
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine( 10, ground, 50, 10);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
    /**
     * create a box for a random amount of balls to bounce in
     */
    public void boxBounce()
    {
        myCanvas.erase();   
        int ground = 400;   // position of the ground line
        
        int number = rand.nextInt(25) + 5;  //random number for size
        
        myCanvas.setVisible(true);

        
        BoxBall[] balls = new BoxBall[number];  //create a random amount of ball array
        
        for(int i = 0; i < number; i++)    {    //assigns random x y position, size and color to each ball
            int size = rand.nextInt(15) + 10;
            int xPos = rand.nextInt(550);
            int yPos = rand.nextInt(400);
            int color = rand.nextInt(4);
            while(xPos < 50)    {
                xPos = rand.nextInt(550);
            }
            while(yPos < 100)   {
                yPos = rand.nextInt(400);
            }
            if(color == 0)  {
                balls[i] = new BoxBall(xPos, yPos, size, Color.BLUE, ground, myCanvas);
            }
            if(color == 1)  {
                balls[i] = new BoxBall(xPos, yPos, size, Color.RED, ground, myCanvas);
            }
            if(color == 2)  {
                balls[i] = new BoxBall(xPos, yPos, size, Color.BLACK, ground, myCanvas);
            }
            if(color == 3)  {
                balls[i] = new BoxBall(xPos, yPos, size, Color.ORANGE, ground, myCanvas);
            }
            if(color == 4)   {
                balls[i] = new BoxBall(xPos, yPos, size, Color.GREEN, ground, myCanvas);
            }
            
            // draw the rectangle after to make it not be affected by the balls
            balls[i].draw();
        }
        
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i = 0; i < number; i++)    {
                balls[i].move();
            }
            myCanvas.setForegroundColor(Color.BLACK);   //set color to black for rectangle
            myCanvas.drawLine( 50, 100, 550, 100);
            myCanvas.drawLine( 50, 400, 550, 400);
            myCanvas.drawLine( 50, 100, 50, 400);
            myCanvas.drawLine( 550, 100, 550, 400);
        }
    }
}
