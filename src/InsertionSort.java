public class InsertionSort {
	
	private  HashArray [] deck;
	
	private void addNumber (int cardNumber, char cardSuit){
		HashArray given = new HashArray(cardNumber, cardSuit); // creates new hasharray object with given cardnumber and suit
		this.deck[this.deck.length - 1] = given; // adds it to the last entry of this.deck
		int N = this.deck.length;
		for (int i = 1; i < N; i++){
			for (int j = i; j > 0 && less(this.deck[j], this.deck[j-1]); j--){
				exch(j, j-1);
			}
		}
	}
	
	private void exch(int x, int y) {
		HashArray temp = this.deck[x]; // sets up temporary variable to assist with the exchange
		this.deck[x] = this.deck[y]; // deck[j] = deck [j-1]
		this.deck[y] = temp; // deck[j-1] = deck[j]	
	}


	private boolean less(HashArray card1, HashArray card2) { // returns true if the first card number is less than the second, false otherwise
		if (card1.cardnumber < card2.cardnumber){
			return true;
		} else if (card1.cardnumber > card2.cardnumber){
			return false;
		}
		return false;
	}


	public void setArray(HashArray[] deck, int cardNumber, char cardSuit){
		this.deck = new HashArray [deck.length+1]; // creates an array with room for 1 more entry than deck
		for (int i = 0; i < deck.length; i++){
			this.deck[i] = deck[i]; // copies array into this.deck
		}
		addNumber(cardNumber, cardSuit); // calls addNumber to add a new hasharray object with int cardnumber and char cardSuit into this.deck, then sort
	}
	
	public HashArray[] getArray(){
		return deck;
	}
	
}
