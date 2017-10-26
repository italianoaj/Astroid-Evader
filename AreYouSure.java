import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * This class creates the "Are You Sure?" pop up prompt when exiting the game.
 * @author italianoaj
 *
 */
public class AreYouSure implements WindowListener {
	
	private JFrame frame;
	public AreYouSure(JFrame f) {
		this.frame=f;
	}
/**
 * This method creates the frame for the closing box.
 * @param e: Uses the WindowEvent class.
 */
	public void windowClosing(WindowEvent e) {
		int result=JOptionPane.showConfirmDialog(frame, "Are You Sure?", "Closing Program", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			System.exit(0);
		}else{
			//do nothing
		}
	}
/**
 * Opens the window.
 */
	@Override
	public void windowOpened(WindowEvent e) {
	}
/**
* Closes the window.
*/
	@Override
	public void windowClosed(WindowEvent e) {	
	}
/**
 * Sets the window icons.
 */
	@Override
	public void windowIconified(WindowEvent e) {
	}
/**
 * Sets the window icons.
 */
	@Override
	public void windowDeiconified(WindowEvent e) {
	}
/**
 * Closes the game.
 */
	@Override
	public void windowActivated(WindowEvent e) {
	}
/**
 * Resumes the game.
 */
	@Override
	public void windowDeactivated(WindowEvent e) {	
	}
}
