
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
/**
 *
 * @author Nate
 */
public abstract class PFigure implements Comparable
{
   protected int xPos, yPos;           // Current position of the figure
   protected int width, height;  // Drawn (displayed) this size
   protected int priority;       // Can use to determine "winner"
   protected JPanel panel;        // Panel the figure lives on
   protected boolean dead;       // Is the figure "dead" in some sense?

   public PFigure ( int startX, int startY, int inWidth, int inHeight, 
                    int pr, JPanel inPanel )
   {
       xPos = startX;
       yPos = startY;
       width = inWidth;
       height = inHeight;
       priority = pr;
       panel = inPanel;
       dead = false;
   }
   
   // Can use this in "battles", which figures is "greater"
   @Override
   public int compareTo(Object inObj)
   {
      if( inObj instanceof PFigure )
         return priority - ((PFigure)inObj).priority;
      return Integer.MAX_VALUE; // Hack: signal invalid parameter
   }
      
   // Has "this" figure collided with inPFigure?
   public boolean collidedWith ( PFigure inPFigure )
   {
      if ( inPFigure == null )
         return false;

      return ( xPos + width ) >= inPFigure.xPos && 
             ( inPFigure.xPos + inPFigure.width ) >= xPos &&
             ( yPos + height ) >= inPFigure.yPos && 
             ( inPFigure.yPos + inPFigure.height ) >= yPos;
   }
   
   // Can be used for moving by keyboard or mouse
   public void move ( int deltaX, int deltaY )
   {
      xPos = xPos + deltaX;
      yPos = yPos + deltaY;
   }
   
   public void hide()
   {
      Graphics graphics = panel.getGraphics();
      Color oldColor = graphics.getColor();
      graphics.setColor(panel.getBackground() );
      graphics.fillRect(xPos, yPos, width, height);
      graphics.setColor(oldColor);
   }
   
   // Can be automatic move, for example, called based on timer
   public void move()
   {
   }

   // Can be used to do things like remove this figure from the 
   // list if it goes off the panel.  For example, in the overridden parameterless 
   // move in a descendant class, if the x or y go outside the panel, you could
   // set dead to true. When checking through your figuerlist, you could remove the dead.
   public boolean isDead()
   {
      return dead;
   }


   // Draw the figure.
   // Each derived class will write their own drawing method.
   // The first line should be:
   //    Graphics graphics = panel.getGraphics();
   abstract public void draw();
    
}
