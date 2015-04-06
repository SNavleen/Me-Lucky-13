import javax.swing.ImageIcon;

public class CardADT{ // abstract data type for cards

	private int card_number; // for the card-value
	private int playerturn = 0, player1counter = 0, player2counter = 0;
	private char card_type; // for the suit
	private String player1name, player2name; // for player names
	private String player = "";
	private HashTabel hashtable_deck, hashtable_p1, hashtable_p2;
	private ImageIcon card; // card images for the GUI
	private HashArray [] deck_array, p1_array, p2_array;

	public CardADT(){ // constructor creates a hash table for the hand of both players, as well as the deck
		this.hashtable_deck = new HashTabel();
		this.hashtable_p1 = new HashTabel();
		this.hashtable_p2 = new HashTabel();

		this.p1_array = new HashArray [0];
		this.p2_array = new HashArray [0];		
		setDeck();
		setDeckArray();
	}
	private void setDeck(){ // creates a deck of 52 cards, puts cards in the hashtable
		for (int i = 1; i <= 13; i++){
			this.hashtable_deck.addHashTabel(i, 'C');
			this.hashtable_deck.addHashTabel(i, 'D');
			this.hashtable_deck.addHashTabel(i, 'H');
			this.hashtable_deck.addHashTabel(i, 'S');
		}
	}
	
	public void setCardNumber(int cardnumber){ // sets card number to its numerical value
		this.card_number = cardnumber;
	}
	public void setCardType(char cardtype){ // sets suit of card
		this.card_type = cardtype;
	}
	public void setPlayer1Name(String player1name){
		this.player1name = player1name; // sets the name of player 1
	}
	public void setPlayer2Name(String player2name){
		this.player2name = player2name; // sets name of player 2
	}
	public void setImageName(String file){ // sets up the images for the cards in the GUI
		this.card = new ImageIcon (getClass().getResource(file));
	}
	public void setDeckArray(){ // sets up the array for the deck (starting deck, then whatever cards are left after each time a card is drawn)
		this.deck_array = null;
		this.deck_array = hashtable_deck.putInArray();
	}	
	public void setPlayer1Array(){ // sets up player1's array, sorts it after the addition of a card
		Model.insertionsort.setArray(this.p1_array, Model.cardadt.getCardNumber(), Model.cardadt.getCardType());
		this.p1_array = Model.insertionsort.getArray();
	}	
	public void setPlayer2Array(){ // sets up player2's array, sorts it after the addition of a card
		Model.insertionsort.setArray(this.p2_array, Model.cardadt.getCardNumber(), Model.cardadt.getCardType());
		this.p2_array = Model.insertionsort.getArray();
	}
	public void setHashTablePlayer1(){
		this.hashtable_p1.addHashTabel(getCardNumber(), getCardType()); // when player 1 clicks the deck, this method will be used to add a card to the user's hand
		this.hashtable_deck.deleteElement(getCardNumber(), getCardType()); // then remove that card from the deck (so the same card will not be repeated in the deck)
	}
	public void setHashTablePlayer2(){
		this.hashtable_p2.addHashTabel(getCardNumber(), getCardType()); // same as setHashTablePlayer1, but for second player
		this.hashtable_deck.deleteElement(getCardNumber(), getCardType());
	}
	public void setPlayer(String player){ // sets the name of player than won
		this.player = player;
	}
	public void setPlayerTurn(){ // increments for every mouse click
		this.playerturn ++;
	}
	public void setPlayer1Counter(){ // counts how many cards in the range the player has
		Model.bst.setCounter(this.p1_array);
		this.player1counter = Model.bst.getCounter();
	}
	public void setPlayer2Counter(){ // counts how many cards in the range from ace to king the player has
		Model.bst.setCounter(this.p2_array);
		this.player2counter = Model.bst.getCounter();
	}

	
	
	public int getCardNumber(){ // returns int value of card
		return card_number;
	}
	public char getCardType(){ // returns suit of card
		return card_type;
	}
	public String getPlayer1Name(){ // returns name of player 1
		return player1name;
	}
	public String getPlayer2Name(){ // returns name of player 2
		return player2name;
	}
	public ImageIcon getImageName(){ // returns iamge
		return card;
	}
	public HashArray[] getDeckArray(){ // returns the hash table for the deck
		return deck_array;
	}	
	public HashArray[] getPlayer1Array(){ // gets player1's hand as an array
		return p1_array;
	}	
	public HashArray[] getPlayer2Array(){ // gets player2's hand as an array
		return p2_array;
	}
	public HashTabel getHashTablePlayer1(){ // gets hash table with all player 1's cards
		return hashtable_p1;
	}
	public HashTabel getHashTablePlayer2(){ // gets hash table with all player 2's cards
		return hashtable_p2;
	}
	public String getPlayer(){ // returns player that won
		return player;
	}
	public int getPlayerTurn(){ // returns whose turn it is
		return playerturn;
	}
	public int getPlayer1Counter(){ // returns the amount of cards in range from ace to king player1 has
		return player1counter;
	}
	public int getPlayer2Counter(){ // returns the amount of cards in range from ace to king player2 has
		return player2counter;
	}
}
