import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * This class fulfills the FileIO requirement of the project. It allows the players to view the previous high score and then save 
 * a new high score.
 * @author italianoaj
 *
 */
public class HighScore {

	public long highScore;
	public FileReader reader;
	public PrintWriter out;
	public Scanner scan;

	/**
	 * This constructor sets up the fields of the class. It also reads the "score.txt" file to set the current high score.
	 */
	public HighScore() {
		
		try{
			
			this.reader = new FileReader("score.txt");
			this.scan = new Scanner (reader);
			if (scan.hasNextLong()){
				this.highScore = scan.nextLong();
				System.out.print(this.highScore);
			}
		}
		catch (FileNotFoundException exception) {
			
			try{
				
				this.reader = new FileReader("score.txt");
				out.println("0");
				out.close();
				this.reader = new FileReader("score.txt");
				this.scan = new Scanner (reader);
				if (scan.hasNextLong()){
					this.highScore = scan.nextLong();
				}
			} 
			catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		}
	}
	/**
	 * The setHighScore() method allows the user to add their score to become the new high score if it is higher than the previous one.
	 * @param score - The score of the current player that is higher than the current. 
	 */
	public void setHighScore(long score) {
		
		try {
			
			this.out = new PrintWriter("score.txt");
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		String newHS = Long.toString(score);
		out.println(newHS);
		out.close();
	}
	/**
	 * The getHighScore() method returns the current high score. 
	 * @return highScore - the current high score of the game. 
	 */
	public long getHighScore(){
		
		return highScore;
	}
}
