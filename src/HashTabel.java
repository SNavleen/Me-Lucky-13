import java.util.Arrays;

class HashNode{
	int cardnumber;
	char cardtype;
	HashNode next;
	
	HashNode(int cardnumber, char cardtype) {
		this.cardnumber = cardnumber;
		this.cardtype = cardtype;
		this.next = next;
	}
}
class HashArray{
	int cardnumber;
	char cardtype;
	HashArray(int cardnumber, char cardtype){
		this.cardnumber = cardnumber;
		this.cardtype = cardtype;
	}
}
public class HashTabel {
	
	private HashNode[] deck = new HashNode [13];
	
	public void addHashTabel (int cardnumber, char cardtype){
		
		int hashvalue = cardnumber-1;
		if(deck[hashvalue] == null)
			deck[hashvalue] = new HashNode(cardnumber, cardtype);
		else{
			HashNode new_node = deck[hashvalue];
			while(new_node.next != null && new_node.cardtype != cardtype){
				new_node = new_node.next;
			}
			new_node.next = new HashNode(cardnumber, cardtype);
		}
	}
	
	public void deleteElement (int cardnumber, char cardtype){
		int hashvalue = cardnumber-1;	
		HashNode previous = null;          
		HashNode current = deck[hashvalue];

		while( current != null && cardtype != current.cardtype){                           
			previous = current;
			current = current.next;     
		}

		if(previous==null)             
			deck[hashvalue] = deck[hashvalue].next;         
		else                           
			previous.next = current.next; 
	}
	
	public HashArray [] putInArray(){
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

