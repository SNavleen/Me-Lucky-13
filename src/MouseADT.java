import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JOptionPane;


public class MouseADT implements MouseListener {

	private String name;

	public MouseADT (String name){
		this.name = name;
	}
	
	public void mouseClicked(MouseEvent e) {
		
		if(name.equals("play")){
			String player1 = (JOptionPane.showInputDialog("Please enter Player 1's name: ")); // gets the names of the players
			String player2 = (JOptionPane.showInputDialog("Please enter Player 2's name: "));
			if(!player1.equals(" ") && !player1.equals("") && !player2.equals(" ") && !player2.equals("")){ // if names are actually given (not blank)
				Model.window.windowRemovePanel(Model.titlescreen); // remove the titlescreen panel so we can move to the game panel
				Model.cardadt.setPlayer1Name(player1); // player names are set
				Model.cardadt.setPlayer2Name(player2);
				Model.window.windowAddPanel(Model.oneplayerscreen); // goes to new "one player screen"
			}else JOptionPane.showMessageDialog(null, "A players name is not in the correct format!", "Warning", JOptionPane.WARNING_MESSAGE); // else gives a warning that the player has not entered a name
			
		}else if(name.equals("instruction")){ // if instruction page label is clicked
			Model.window.windowRemovePanel(Model.titlescreen); // remove titlescreen panel
			Model.window.windowAddPanel(Model.instructionscreen); // go to instruction screen
		}else if (name.equals("title")){ // do whatever is required for the current panel
			Model.window.windowRemovePanel(Model.instructionscreen);
			Model.window.windowAddPanel(Model.titlescreen);
			
		}else if (name.equals("exit")){
			int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to close?", "", 0); // checks to see if the user really wants to close the window
			if (exit == 0)
				System.exit (0); // if so the window closes
		}
		Model.window.revalidate();
		Model.window.repaint();
	}

	public void mousePressed(MouseEvent e) { // this is for the user - to draw cards
		int x = e.getX(); // gets coordinates of mouse click
		int y = e.getY();
				
		if(x >= 400 && x <= 500 && y >= 225 && y <= 375){ // if the click was on the deck (the part of the window the deck is displayed on)
			Random rand = new Random();
			int card = rand.nextInt(Model.cardadt.getDeckArray().length); // sets a random card value and random suit from the hash table
			Model.cardadt.setCardNumber(Model.cardadt.getDeckArray()[card].cardnumber); // sets the numerical value of the card
			Model.cardadt.setCardType(Model.cardadt.getDeckArray()[card].cardtype); // sets the suit of the card
			Model.cardadt.setHashTablePlayer1(); // sets up users hash table
			Model.cardadt.setArrays();
			
			Model.oneplayerscreen.repaint();
		}
	}

	public void mouseReleased(MouseEvent e) {	// this is for the "computer opponent" - to draw cards
		int x = e.getX(); // gets the coordinates of the mouseclick
		int y = e.getY();
	
		if(x >= 400 && x <= 500 && y >= 225 && y <= 375){ // if the click was on the deck (the part of the window the deck is displayed on)
			Random rand = new Random();
			int card = rand.nextInt(Model.cardadt.getDeckArray().length); // selects a random card value and random suit from the hasharray
			Model.cardadt.setCardNumber(Model.cardadt.getDeckArray()[card].cardnumber); // sets the numerical value of card
			Model.cardadt.setCardType(Model.cardadt.getDeckArray()[card].cardtype); // sets the suit of the card
			Model.cardadt.setHashTablePlayer2(); // sets up opponent's hashtable
			Model.cardadt.setArrays();

			Model.oneplayerscreen.repaint();
		}	
	}

	public void mouseEntered(MouseEvent e) {		
	}

	public void mouseExited(MouseEvent e) {		
	}

}
