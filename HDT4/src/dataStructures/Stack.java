package dataStructures;
/**
 * 
 * @author Diego Alonzo 20172
 *Es generic y es un ADT
 * @param <T>
 */
public abstract class Stack<T> {
	private T head;
	private int count;
	
	public void push(T value) {
		
	}
	
	T pull() {
		return head;
	}
	
	T peek() {
		return head;
	}
	
	int Count() {
		return count;
	}
	
	boolean IsEmpty() {
		return count==0;
	}
}
