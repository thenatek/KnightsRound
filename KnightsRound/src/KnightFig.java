import java.awt.*;
import javax.swing.JPanel;
/**
 *
 * @author Nate
 */
public class KnightFig extends PFigure
{
    public KnightFig(JPanel p)
   {
      super(10,  75,  80,  80,  1,p);
   }
   
   public void move ( int deltaX, int deltaY )
   {
      super.move(deltaX, deltaY);
      if ( xPos < -width / 2 )
         xPos = panel.getSize().width - width / 2;
      else if ( (xPos + width / 2) > panel.getSize().width )
         xPos = -width / 2;
      if ( yPos < -height / 2 )
         yPos = panel.getSize().height - height / 2;
      else if ( (yPos + height / 2) > panel.getSize().height )
         yPos = -height / 2;
   }

   public void draw()
   {
      Graphics g = panel.getGraphics();
      //head
      g.setColor(Color.red);
      g.drawOval(xPos + width / 8 , yPos + 1, width / 4, height / 4);
      //neck
      g.setColor(Color.red);
      g.drawLine( xPos + width / 4, yPos + height / 4 + 1, xPos + width / 4, yPos + 3 * height / 8 );
      //arms
      g.setColor(Color.red);
      g.drawLine( xPos + width / 8, yPos + 5 * height / 16 + 1, xPos + 3 * width / 8, yPos + 5 * height / 16 + 1);
      //legs
      g.setColor(Color.red);
      g.drawLine( xPos + width / 4, yPos + 3 * height / 8, xPos + width / 8, yPos + 7 * height / 16 );
      g.drawLine( xPos + width / 4, yPos + 3 * height / 8, xPos + 3 * width / 8, yPos + 7 * height / 16 );
      //sword
      g.setColor(Color.white);
      g.drawLine( xPos + (width + 6) / 2, yPos + height / 4 + 1, xPos + width / 2, yPos + 3 * height / 8 );
   }
    
}
