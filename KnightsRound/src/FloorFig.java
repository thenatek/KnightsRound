import java.awt.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.JPanel;

/**
 *
 * @author Nate
 */
public class FloorFig extends PFigure
{
   private int xVel = 20;
   private int yVel = 20;
   private Image img;

   public FloorFig(JPanel p)
   {
      super(0,  0,  80,  80,  1,p);
      try
      {
         File file = new File("wood.jpg");
         img = ImageIO.read(file);
      }
      catch ( Exception e )
      {
         System.out.println("Crashing: " + e);
         // Whatever???
      }
   }

   @Override
   public void move()
   {
      if ( xVel < 0 && xPos <= 0 ||
           xVel > 0 && xPos + width >= panel.getSize().width )
         xVel = - xVel;
      if ( yVel < 0 && yPos <= 0 ||
           yVel > 0 && yPos + height >= panel.getSize().height )
         yVel = - yVel;
      xPos = xPos + xVel;
      yPos = yPos + yVel;
   }

   @Override
   public void draw()
   {
      if( img != null )
      {
         Graphics g = panel.getGraphics();
         g.drawImage( img, xPos, yPos, width+100, height+100, null );
      }
   }
    
}
