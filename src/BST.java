public class BST {
	
	private int counter;
	
	private boolean binarySearch(int key, int size, HashArray[] data){//Setting up the divide and conquer algorithm
		int low = 0;//Lower bound
		int high = size;//Upper bound
		while(high >= low){
			int middle = (low + high) / 2;//Middle key that is the focus of the algorithm
			if(data[middle].cardnumber == key){
				return true;//If it is the middle key, return true for found
			}
			if(data[middle].cardnumber < key){
				low = middle + 1;//If the middle key is less than the key, key must be in left side of array
			}
			if(data[middle].cardnumber > key){
				high = middle - 1;//If the middle key is greater than the key, key must be in the right side of the array
			}
		}
		return false;//If it isn't found return false.
	}
	
	public void setCounter (HashArray[] deck){
		this.counter = 0;
		for(int i = 1; i <= 13; i++){//Searching for a 1-13 match
			boolean a = binarySearch(i, deck.length - 1, deck);//Does a search for the key of i
			if(a == true){//If it is found then
				counter++;//Increment the counter
			}else{
				return;//If not break out
			}
		}
	}
	public int getCounter (){//Returns the current counter value
		return counter;
	}

}
