import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
/**
 * This class creates the star sprite.
 * @author italianoaj
 *
 */
public class Star {
	
	private final int x, y;
	private final int XOFFSET[]={50, 30, 0, 20, 0, 50, 100, 80, 100, 70};
	private final int YOFFSET[]={10, 50, 50, 100, 150, 125, 150, 100, 50,50};
	
	private final Polygon star;
/**
 * This constructor initializes the fields for the star sprite.
 * @param x:This gives the location on the x-axis to create the star sprite.
 * @param y: This gives the location on the x-axis to create the star sprite.
 */
	public Star(int x, int y) {
		
		this.x=x;
		this.y=y;
		star= new Polygon();
		for(int i=0;i<XOFFSET.length;i++) {
			
			star.addPoint(x+XOFFSET[i], y+YOFFSET[i]);
		}
	}
/**
 * This method draws the star sprite.
 * @param g: Uses the Graphics class. 
 */
	public void draw(Graphics g) {
		
		Graphics2D g2=(Graphics2D) g;
		g2.setColor(Color.YELLOW);
		g2.fill(star);
	}
}

