import java.awt.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.JPanel;

/**
 *
 * @author Nate
 */
public class OrcFig extends PFigure
{
    private int xVel = 40;
   private int yVel = 40;
   private Image img;

   public OrcFig(JPanel p)
   {
      super(150,  250,  110,  78,  1, p );
      try
      {
         File file = new File("orc2.png");
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
         g.drawImage( img, xPos, yPos, width-40, height-30, null );
      }
   }
    
}
