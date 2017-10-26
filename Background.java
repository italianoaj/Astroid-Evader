import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import javax.swing.JComponent;
/**
 * Class background creates the background for game program.
 * @author italianoaj
 *
 */
public class Background extends JComponent implements KeyListener {

	private Star s1,s2;
	private Rocket r1;
	private Astroid a1, a2, a3, a4, a5;
	private final int NumberOfMaximumStars=500;
	private final int SPACE_BACKGROUND_MAX = 1000;
	private final int STAR_WIDTH = 3;
	private final int STAR_HEIGHT = 10;
	private final int FONT_SIZE = 85;
	public  static final int ASTROID_Y_LOCATION = -100;
	private final int ASTROID_1_X = 200;
	private final int ASTROID_2_X = 400;
	private final int ASTROID_3_X = 600;
	private final int ASTROID_4_X = 800;
	private final int ASTROID_5_X = 100;
	private final int STAR_Y_LOCATION = 25;
	private final int STAR_1_X = 50;
	private final int STAR_2_X = 850;
	private int ROCKET_X = 400;
	private final int ROCKET_Y = 800;
	private final int MESSAGE_X = 10;
	private final int MESSAGE_Y = 925;
	private final int TITLE_X = 190;
	private final int TITLE_Y = 100;
	private final int SEGMENT_Y = 110;
	private final int SEGMENT_STARTING_X = 190;
	private final int SEGMENT_ENDING_X = 800;
	private final Rectangle SPACE=new Rectangle(0,0,SPACE_BACKGROUND_MAX,SPACE_BACKGROUND_MAX);
	public static int livesRemaining = 3;
	public long score;
	public  ArrayList<Astroid> astroids; 

	/**
	 * This constructor calls the setUp() method in order to set the fields to the wanted amounts and locations.
	 */
	public Background(){
		
		setup();
	}
	/**
	 * Method paintComponent draws a rectangle that is black for the background, 
	 * prints stars in random positions, creates the title message, and places the sprites. 
	 */
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.fill(SPACE);
		Random random=new Random();
		g2.setColor(Color.WHITE);
		for (int counter = 1; counter < NumberOfMaximumStars; counter++) {
			
			int x = random.nextInt(SPACE_BACKGROUND_MAX);
			int y = random.nextInt(SPACE_BACKGROUND_MAX);
			int height = random.nextInt(STAR_HEIGHT);
			Ellipse2D.Double star = new Ellipse2D.Double(x, y,STAR_WIDTH, height);
			g2.fill(star);
			score++;
		}
		g2.setColor(Color.RED);
		g2.drawString("Lives Remaining: "+livesRemaining, MESSAGE_X, MESSAGE_Y);
		g2.drawString("Score: "+score, MESSAGE_X+300, MESSAGE_Y);
		g2.setColor(Color.BLUE);
		Font font = new Font("URW Gothic L", Font.BOLD, FONT_SIZE);
		g2.setFont(font);
		g2.drawString("Astroid Evader!",TITLE_X,TITLE_Y);
		g2.setColor(Color.MAGENTA);
		Line2D.Double segment=(Double) new Line2D.Double(SEGMENT_STARTING_X,SEGMENT_Y,SEGMENT_ENDING_X,SEGMENT_Y);
		g2.draw(segment);
		s1.draw(g);
		s2.draw(g);
		r1.draw(g);
		for(Astroid a : astroids){
			
			a.draw(g);
		}
	}
	/**
	 * The updatePositions() method calls the update() method in the Astroid class in order to move the positions of the astroids.
	 */
	public void updatePositions() {

		for (Astroid a : astroids){
			a.update(r1);
		}
	}
	/**
	 * The getScore() method returns the score of the current game.
	 * @return score - the current score. 
	 */
	public long getScore(){
		
		return score;
	}
	/**
	 * This method is implemented, but not used. 
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	/**
	 * This method is implemented, but not used.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		r1.UpdateLocation(e);
		r1.colorChange(e);
	}
	/**
	 * This method is implemented, but not used.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	/**
	 * The setUp() method creates all of the objects in the background and also sets the score of the current game session to one and also sets the lives
	 * remaining to 3. 
	 */
	public void setup(){
		s1=new Star(STAR_1_X,STAR_Y_LOCATION);
		s2=new Star(STAR_2_X,STAR_Y_LOCATION);
		
		a1=new Astroid(ASTROID_1_X,ASTROID_Y_LOCATION);
		a2=new Astroid(ASTROID_2_X,ASTROID_Y_LOCATION);
		a3=new Astroid(ASTROID_3_X,ASTROID_Y_LOCATION);
		a4=new Astroid(ASTROID_4_X,ASTROID_Y_LOCATION);
		a5=new Astroid(ASTROID_5_X,ASTROID_Y_LOCATION);
		
		r1=new Rocket(ROCKET_X,ROCKET_Y);
		
		this.livesRemaining = 3;
		
		astroids = new ArrayList<Astroid>();
		
		astroids.add(a1);
		astroids.add(a2);
		astroids.add(a3);
		astroids.add(a4);
		astroids.add(a5);
		
		this.score = 1;
	}
}
