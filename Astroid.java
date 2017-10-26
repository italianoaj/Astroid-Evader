import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
/**
 * This class creates the astroid that the player will dodge.
 * @author italianoaj
 *
 */
public class Astroid {
	
	private final int XOFFSET[]={70, 80, 90, 100, 100, 110, 110, 100, 100, 90, 80, 70, 60, 50, 50, 40, 40, 50, 50, 60};
	private final int YOFFSET[]={30, 30, 40, 40, 50, 60, 70, 80, 90, 90, 100, 100, 90, 90, 80, 70, 60, 50, 40, 40};
	private final int MAXIMUM_Y_LOCATION = 1000;
	
	private int x, y;
	private int rate = 12;
	public int score = 0;
	public int direction;
	private int xrate = 20;
	
	private Polygon astroid;
	
	/**
	 * This constructor initializes the fields to create the astroid sprite.
	 * @param x: This gives the location on the x-axis to create the astroid sprite.
	 * @param y: This gives the location on the y-axis to create the astroid sprite.
	 */
	public Astroid (int x, int y) {
		this.x=x;
		this.y=y;
		astroid= new Polygon();
		for(int i=0;i<XOFFSET.length;i++) {
			astroid.addPoint(x+XOFFSET[i], y+YOFFSET[i]);
			this.direction = 1;
		}
	}
	/**
	 * This method draws the astroid sprite.
	 * @param g: Uses the Graphics class.
	 */
	public void draw(Graphics g) {
		
		Graphics2D g2=(Graphics2D) g;
		g2.setColor(Color.GRAY);
		g2.fill(astroid);
	}
	/**
	 * This method causes the astroids to move downward and then reset at the bottom. 
	 * @param r1 
	 * @param astroids 
	 */
	public void update(Rocket r1) {
		
		Random random=new Random();
		if (this.direction == 1){
			
			astroid.translate(random.nextInt(xrate), rate);
		}
		else if (this.direction == -1){
			astroid.translate(-random.nextInt(xrate), rate);
		}
		if(astroid.getBounds().y>MAXIMUM_Y_LOCATION){
			astroid.translate(random.nextInt(1000)-astroid.getBounds().x, -(MAXIMUM_Y_LOCATION-Background.ASTROID_Y_LOCATION));
			rate+=2;
			xrate+=2;
		}
		else if (r1.collision(this)){
			Background.livesRemaining--;
		}
		if (astroid.getBounds().x>900 || astroid.getBounds().x<=0){
				this.direction = direction*-1;
		}
	}
	/**
	 * The getBounds() method returns the bounding box of the astroid. 
	 * @return
	 */
	public Rectangle2D getBounds() {
		return astroid.getBounds();
	}
	
	public void reset(Astroid astroid2, Rocket r1){
		Random random=new Random();
		astroid.translate(random.nextInt(1000)-astroid.getBounds().x, -(MAXIMUM_Y_LOCATION-Background.ASTROID_Y_LOCATION));
		r1.reset();
	}

}