import java.awt.Dimension;
import java.awt.Toolkit;

public class Model{
	
	
 	private static Dimension screen = Toolkit.getDefaultToolkit ().getScreenSize (); // used for finding the dimensions of the users screen		
	private static int screen_width = screen.width, screen_height = screen.height; // creates int's for the width and the height

	static Window window = new Window((screen_width/2) - (900/2), (screen_height/2) - (600/2), 900, 600); // sets up the window dimensions according to the height and width of the screen (so it goes to the right place on any screen opened on
	static TitleScreen titlescreen = new TitleScreen(); // creates screen objects
	static InstructionScreen instructionscreen = new InstructionScreen();
	static OnePlayerScreen oneplayerscreen = new OnePlayerScreen();
	static CardADT cardadt = new CardADT();
		
	public static void main(String [] args){
		window.windowAddPanel(titlescreen); // adds the titlescreen panel
		
		window.setVisible(true);
	}	
}
