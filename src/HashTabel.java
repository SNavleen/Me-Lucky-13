import java.util.Arrays;

class HashNode{
	int cardnumber; // stores the card number
	char cardtype; // and card suit
	HashNode next; // for linked list
	
	HashNode(int cardnumber, char cardtype) { // constructor for each node in the hash table, sets cardnumber and suit
		this.cardnumber = cardnumber;
		this.cardtype = cardtype;
		this.next = next; // creating a link for the next node (linked list implementation)
	}
}
class HashArray{
	int cardnumber;
	char cardtype;
	HashArray(int cardnumber, char cardtype){ // constructor for hasharray to set card value and suit
		this.cardnumber = cardnumber;
		this.cardtype = cardtype;
	}
}
public class HashTabel {
	
	private HashNode[] deck = new HashNode [13]; // hash table created to hold all 13 individual card numerical values, each will hold all four suits for the value
	
	public void addHashTabel (int cardnumber, char cardtype){
		
		int hashvalue = cardnumber-1; // hash function
		if(deck[hashvalue] == null) // if the deck's hash table is empty at this hashvalue, 
			deck[hashvalue] = new HashNode(cardnumber, cardtype); // add a card to it (node)
		else{
			HashNode new_node = deck[hashvalue]; // sets newnode to the "filled" value in the deck (now we need to implement the linked list for this index in the deck array)
			while(new_node.next != null && new_node.cardtype != cardtype){ // while the next link isn't null and the suits do not match
				new_node = new_node.next; // go to next
			}
			new_node.next = new HashNode(cardnumber, cardtype); // an empty spot has been found, fills with new hashnode
		}
	}
	
	public void deleteElement (int cardnumber, char cardtype){ // deletes card from a hashtable
		int hashvalue = cardnumber-1; // hash function
		HashNode previous = null;
		HashNode current = deck[hashvalue]; // sets current to the deck array indexed at hashvalue

		while( current != null && cardtype != current.cardtype){ // while the current card isn't null and the given suit is not the same at the current suit                      
			previous = current; // set previous to current
			current = current.next;     // go to next link
		}

		if(previous==null)     // if the desired key-value pair was found in the first link, previous will = null       
			deck[hashvalue] = deck[hashvalue].next; // so we delete that key-value pair, move other links up  
		else{
			previous.next = current.next; // else if its not the first link, deletes it
		}
	}
	
	public HashArray [] putInArray(){ // TODO
		HashArray[] array = new HashArray [0];
		HashNode[] deck_temp = new HashNode[deck.length];
		for(int i = 0; i < deck.length; i++){
			deck_temp[i] = deck[i];
		}
		int N = 0;
		for(int i = 0; i < deck_temp.length; i++){
			while(deck_temp[i] != null){
				if(deck_temp[i] != null){
					array = Arrays.copyOf(array, array.length + 1);
					array[N++] = new HashArray(deck_temp[i].cardnumber, deck_temp[i].cardtype);
				}
				deck_temp[i] = deck_temp[i].next;
			}
		}
		return array;
	}
}

