import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class Window extends JFrame{ // abstract data type for the window

	private final int x, y, width, height; // initialize class variables
	
	public Window(int x, int y, int width, int height){ // constructor for game window dimensions, as well as x and y coordinates for points on the game window
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		setSize(width, height); // within constructor, sets the window's width and height
		setLocation(x, y); // where the window shows up on the computer screen
		setTitle("");
		setResizable(false); // does not allow window size to be changed
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // allows to close
	}
	
	public int windowGetX(){ // returns x coordinate of a point on screen
		return x;
	}	
	public int windowGetY(){ // returns y coordinate of a point on screen
		return y;
	}	
	public int windowGetWidth(){ // returns width of window
		return width;
	}	
	public int windowGetHeight(){ // return height of window
		return height;
	}	
	
	public void windowAddPanel(Component name){ // adds a new panel to be used
		add(name);
	}
	public void windowRemovePanel(Component name){ // allows current panel to be removed so we can replace with a new one (new screen)
		remove(name);
	}
}
