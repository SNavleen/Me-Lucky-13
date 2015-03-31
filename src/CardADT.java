import javax.swing.ImageIcon;

public class CardADT{

	private int card_number;
	private char card_type;
	private String player1name, player2name;
	private HashTabel hashtable_deck, hashtable_p1, hashtable_p2;
	private ImageIcon card;
	private HashArray [] deck_array, p1_array, p2_array;

	public CardADT(){
		this.hashtable_deck = new HashTabel();
		this.hashtable_p1 = new HashTabel();
		this.hashtable_p2 = new HashTabel();
		
		setDeck();
		setArrays();
	
		this.card = null;
	}
	private void setDeck(){
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
	public void setCardType(char cardtype){
		this.card_type = cardtype;
	}
	public void setPlayer1Name(String player1name){
		this.player1name = player1name; // sets the name of player 1
	}
	public void setPlayer2Name(String player2name){
		this.player2name = player2name; // sets name of player 2
	}
	public void setImageName(String file){
		//String file = ("/"+getCardNumber()+getCardType()+".png");
		this.card = new ImageIcon (getClass().getResource(file));
	}
	public void setArrays(){
		this.deck_array = null;
		this.deck_array = hashtable_deck.putInArray();
		this.p1_array = null;
		this.p1_array = hashtable_p1.putInArray();
		this.p2_array = null;
		this.p2_array = hashtable_p2.putInArray();
	
	}	
	public void setHashTablePlayer1(){
		this.hashtable_p1.addHashTabel(getCardNumber(), getCardType());
		this.hashtable_deck.deleteElement(getCardNumber(), getCardType());
	}
	public void setHashTablePlayer2(){
		this.hashtable_p2.addHashTabel(getCardNumber(), getCardType());
		this.hashtable_deck.deleteElement(getCardNumber(), getCardType());
	}

	
	
	public int getCardNumber(){ // returns int value of card
		return card_number;
	}
	public char getCardType(){
		return card_type;
	}
	public String getPlayer1Name(){ // returns name of player 1
		return player1name;
	}
	public String getPlayer2Name(){ // returns name of player 2
		return player2name;
	}
	public ImageIcon getImageName(){
		return card;
	}
	public HashArray[] getDeckArray(){
		return deck_array;
	}	
	public HashArray[] getPlayer1Array(){
		return p1_array;
	}	
	public HashArray[] getPlayer2Array(){
		return p2_array;
	}
	public HashTabel getHashTablePlayer1(){
		return hashtable_p1;
	}
	public HashTabel getHashTablePlayer2(){
		return hashtable_p2;
	}
}
