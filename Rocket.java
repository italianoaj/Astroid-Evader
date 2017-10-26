import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
/**
 * This class creates the rocket sprite that  the player will move to 
 * avoid the astroids.
 * @author italianoaj
 *
 */
public class Rocket {
	
	private int x;
	private int y;
	
	private final int YOFFSET[]={0, 15, 28, 65, 78, 90, 90, 78, 65, 28, 15};
	private final int XOFFSET[]={40, 28, 28, 0, 15, 15, 65, 65, 80, 53, 53};
	private final int PIXELS_MOVED = 15;
	private final int FRAME_SIZE = 1000;
	private final int MAX_COLOR_VAL = 255;
	
	private Color myColor=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
	
	private Polygon rocket;

	/**
	 * This constructor initializes the fields to create the rocket sprite. 
	 * @param x: This gives the location on the x-axis to create the rocket sprite.
	 * @param y: This gives the location on the y-axis to create the rocket sprite.
	 */
	public Rocket(int x, int y) {
		
		this.x=x;
		this.y=y;
		rocket= new Polygon();
		for(int i=0;i<XOFFSET.length;i++) {
			rocket.addPoint(x+XOFFSET[i], y+YOFFSET[i]);
		}
	}
	/**
	 * This method draws the rocket.
	 * @param g: Uses the Graphics class.
	 */
	public void draw(Graphics g) {
		
		Graphics2D g2=(Graphics2D) g;
		g2.setColor(myColor);
		g2.fill(rocket);
	}
	/** 
	 * This method allows the user to move the rocket with the arrow keys and press the escape key to close the program.
	 * @param e: this is the key being pressed.
	 */
	public void UpdateLocation(KeyEvent e) {
		
		if (e.getKeyCode()==KeyEvent.VK_LEFT){
			rocket.translate(-PIXELS_MOVED, 0);
			if (rocket.getBounds().getX() <0) {
				rocket.translate(FRAME_SIZE-50, 0);
			}
		}else if (e.getKeyCode()==KeyEvent.VK_RIGHT){
			rocket.translate(PIXELS_MOVED, 0);
			if (rocket.getBounds().getX()>FRAME_SIZE-75) {
				rocket.translate(-FRAME_SIZE+50, 0);
			}
		}else if (e.getKeyCode()==KeyEvent.VK_UP){
			rocket.translate(0, -PIXELS_MOVED);
			if (rocket.getBounds().getY()<0) {
				rocket.translate(0, FRAME_SIZE-50);
			}
		}
//		else if (e.getKeyCode()==KeyEvent.VK_DOWN){
//			rocket.translate(0, PIXELS_MOVED);
//			if (rocket.getBounds().getY() == 900) {
//				rocket.translate(rocket.getBounds().x, rocket.getBounds().y);
//			}
//		}
		if (e.getKeyCode()==KeyEvent.VK_ESCAPE){
			AreYouSure close = new AreYouSure(null);
			close.windowClosing(null);
		}
	}
	/**
	 * This method handled the easter egg that the player can change the color of the ship with the space bar.
	 * @param e - the key being pressed.
	 */
	public void colorChange(KeyEvent e) {

		if (e.getKeyCode()==KeyEvent.VK_SPACE){
			myColor=new Color((int)(Math.random()*MAX_COLOR_VAL),(int)(Math.random()*MAX_COLOR_VAL),(int)(Math.random()*MAX_COLOR_VAL));
		}	
	}
	/**
	 * The collision() method checks to see if the rocket has collided with an astroid. 
	 * @param a - an instance of an astroid.
	 * @return - returns true if the rocket has collided, false otherwise. 
	 */
	public boolean collision(Astroid a){
		
		if(rocket.intersects(a.getBounds())){
			a.reset(a, this);
			return true;
			
		}
		return false;
	}
	/**
	 * The reset() method redraws the rocket at the original position. 
	 */
	public void reset() {
		
		rocket = new Polygon();
		for(int i=0;i<XOFFSET.length;i++) {
			rocket.addPoint(x+XOFFSET[i], y+YOFFSET[i]);
		}
	}
}