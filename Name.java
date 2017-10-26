import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * This class fulfills the FileIO requirement of the project. It allows the players to view the previous high score holder 
 * and then save a new high score user name if the score was beaten.
 * @author italianoaj
 *
 */
public class Name {
	
	public String name;
	public FileReader reader;
	public PrintWriter out;
	public Scanner scan;
	
	/**
	 * This constructor sets up the fields of the class. It also reads the "score.txt" file to set the current high score.
	 * If the file is not found, it will be created and set to the name "Louis Oliphant"
	 */
	public Name() {
		
		try{
			
			this.reader = new FileReader("name.txt");
			this.scan = new Scanner (reader);
			if (scan.hasNextLine()){
				this.name = scan.nextLine();
			}
		}
		catch (FileNotFoundException exception){
			
			try {
				
				this.out = new PrintWriter("name.txt");
				out.println("Louis Oliphant");
				out.close();
				this.reader = new FileReader("name.txt");
				this.scan = new Scanner (reader);
				if (scan.hasNextLine()){
					this.name = scan.nextLine();
				}
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		}
	}
	/**
	 * The setHighScore() method allows the user to add their score to become the new high score if it is higher than the previous one.
	 * @param score - The score of the current player that is higher than the current. 
	 */
	public void setName(String newName){
		
		try {
			
			this.out = new PrintWriter("name.txt");
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		out.println(newName);
		out.close();
	}
	/**
	 * The getHighScore() method returns the current high score. 
	 * @return highScore - the current high score of the game. 
	 */
	public String getName(){
		
		return name;
	}
}

