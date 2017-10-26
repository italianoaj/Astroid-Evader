 import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This Class creates the frame for the game
 * @author italianoaj
 *
 */

public class AstroidEvader {
	public final static int DELAY = 100;
	public final static int FRAMESIZE = 1000;
	
	public static boolean play = true;
	
	public static String username;
	public static String current;
	
	/**
	 * This method creates the frame size and launches the frame.
	 * @param args: Arguments.
	 */
	public static void main(String args[]) {
		
		username = System.getenv("USER");
		Name name = new Name();
		HighScore hs = new HighScore();
		JFrame frame=new JFrame();
		frame.setSize(FRAMESIZE,FRAMESIZE);
		frame.setTitle("Astroid Evader");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new AreYouSure(frame));
		frame.setResizable(false);
		Background component=new Background();
		frame.add(component);
		frame.addKeyListener(component);
		frame.setVisible(true);
		String user = JOptionPane.showInputDialog(frame, "Plese enter your username:");
		if (user.equalsIgnoreCase("blazek") || user.equalsIgnoreCase("nate") || user.equalsIgnoreCase("nathan") || user.equalsIgnoreCase("blaze") || user.equalsIgnoreCase("blazer")){
			JOptionPane.showMessageDialog(frame, "Nate You Suck");
			component.livesRemaining = 0;
		}
		JOptionPane.showMessageDialog(frame, "THE ALIEN EMPIRE IS AFTER YOU AND THE ONLY WAY TO ESCAPE IS THROUGH THE ASTROID FIELD!");
		JOptionPane.showMessageDialog(frame, "Use the arrow keys to move and press ESC to exit."
				+ "\nThe current high score holder is : \n"+name.getName()+" with a score of "+hs.getHighScore());
		while (true){
			
			component.updatePositions();
			frame.repaint();
			try {
				
				Thread.sleep(DELAY);
			} 
			catch(Exception e) {
			}
			if(component.livesRemaining <= 0 && component.getScore() <= hs.getHighScore()){
				
				int result = JOptionPane.showConfirmDialog(frame, "You have lost all of your lives! Your score was: "+component.getScore()+
						" Would you like to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION){
					
					component.setup();
				}else if (result == JOptionPane.NO_OPTION){
					
					System.exit(0);
				}
			}
			else if (component.livesRemaining <= 0 && component.getScore() > hs.getHighScore()){
				JOptionPane.showMessageDialog(frame, "CONGRATS! \nYOU SET A NEW HIGH SCORE!");
				hs.setHighScore(component.getScore());
				name.setName(user);
				int result = JOptionPane.showConfirmDialog(frame, "You have lost all of your lives! Your score was: "+component.getScore()+
						" Would you like to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);				if (result == JOptionPane.YES_OPTION){
					
					component.setup();
				}else if (result == JOptionPane.NO_OPTION){
					
					System.exit(0);
				}
			}
		}
	}
}