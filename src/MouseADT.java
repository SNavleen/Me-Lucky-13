import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JOptionPane;


public class MouseADT implements MouseListener {

	private String name, winnername;
	private String[] players = {"1 Player", "2 Player"};
	private boolean win = false;

	public MouseADT (String name){
		this.name = name;
	}

	
	public void mouseClicked(MouseEvent e) {
		
		if(name.equals("play")){
			
			String player = (String) JOptionPane.showInputDialog(null, "Pick number of players", "Number of Players",
					JOptionPane.QUESTION_MESSAGE, null, players, players[0]);
			Model.cardadt.setPlayer(player);
			
			String player1 = (JOptionPane.showInputDialog("Please enter Player 1's name: ")); // gets the names of the players
			String player2 = "";
			if(Model.cardadt.getPlayer().equals("1 Player"))
				player2 = ("Computer");
			else
				player2 = (JOptionPane.showInputDialog("Please enter Player 2's name: "));
			
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
				
		if(this.win == false && x >= 400 && x <= 500 && y >= 225 && y <= 375 && Model.cardadt.getDeckArray().length != 0){ // if the click was on the deck (the part of the window the deck is displayed on)
			Random rand = new Random();
			int card = rand.nextInt(Model.cardadt.getDeckArray().length); // sets a random card value and random suit from the hash table
			Model.cardadt.setCardNumber(Model.cardadt.getDeckArray()[card].cardnumber); // sets the numerical value of the card
			Model.cardadt.setCardType(Model.cardadt.getDeckArray()[card].cardtype); // sets the suit of the card
			
			if(Model.cardadt.getPlayer().equals("2 Player")){
				if(Model.cardadt.getPlayerTurn()%2 == 0){
					Model.cardadt.setHashTablePlayer1(); // sets up users hash table
					Model.cardadt.setDeckArray();
					Model.cardadt.setPlayer1Array();
				}
				else if (Model.cardadt.getPlayerTurn()%2 == 1){
					Model.cardadt.setHashTablePlayer2(); // sets up users hash table
					Model.cardadt.setDeckArray();
					Model.cardadt.setPlayer2Array();
					this.win = getWinner();
				}
				Model.cardadt.setPlayerTurn();
			}
			else{
				Model.cardadt.setHashTablePlayer1(); // sets up users hash table
				Model.cardadt.setDeckArray();
				Model.cardadt.setPlayer1Array();
			}
			Model.oneplayerscreen.repaint();
		}
	}

	public void mouseReleased(MouseEvent e) {	// this is for the "computer opponent" - to draw cards
		int x = e.getX(); // gets the coordinates of the mouseclick
		int y = e.getY();
		
		if(this.win == false && x >= 400 && x <= 500 && y >= 225 && y <= 375 && Model.cardadt.getDeckArray().length != 0){ // if the click was on the deck (the part of the window the deck is displayed on)
			if(Model.cardadt.getPlayer().equals("1 Player")){
				Random rand = new Random();
				int card = rand.nextInt(Model.cardadt.getDeckArray().length); // selects a random card value and random suit from the hasharray
				Model.cardadt.setCardNumber(Model.cardadt.getDeckArray()[card].cardnumber); // sets the numerical value of card
				Model.cardadt.setCardType(Model.cardadt.getDeckArray()[card].cardtype); // sets the suit of the card
				Model.cardadt.setHashTablePlayer2(); // sets up opponent's hashtable
				Model.cardadt.setDeckArray();
				Model.cardadt.setPlayer2Array();
				Model.oneplayerscreen.repaint();

				this.win = getWinner();
			}
		}
		if(this.win == true){
			int done = JOptionPane.showConfirmDialog(null, "The Winner is "+this.winnername+"\n Click Yes to go back to Menu", "Player: "+this.winnername, 0);
			if(done == 0){
				Model.window.windowRemovePanel(Model.oneplayerscreen);
				Model.window.windowAddPanel(Model.titlescreen);
				Model.window.revalidate();
				Model.window.repaint();
			}
		}
	}

	public void mouseEntered(MouseEvent e) {		
	}

	public void mouseExited(MouseEvent e) {		
	}
	
	private boolean getWinner(){
		String winner = "";
		
		Model.cardadt.setPlayer1Counter();
		int p1counter = Model.cardadt.getPlayer1Counter();
		Model.cardadt.setPlayer2Counter();
		int p2counter = Model.cardadt.getPlayer2Counter();

		if(p1counter == 13 && p2counter == 13){
			winner = "No one";
			this.win = true;
		}
		else if(p1counter == 13 && p2counter != 13){
			winner = Model.cardadt.getPlayer1Name();
			this.win = true;
		}
		else if(p1counter != 13 && p2counter == 13){
			winner = Model.cardadt.getPlayer2Name();
			this.win = true;
		}
		else if(Model.cardadt.getDeckArray().length == 0){
			if(p1counter > p2counter)
				winner = Model.cardadt.getPlayer1Name();
			else if (p1counter < p2counter)
				winner = Model.cardadt.getPlayer2Name();
			else
				winner = "Tie";

			this.win = true;
		}
		this.winnername = winner;
		return win;
	}
}
