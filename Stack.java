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
	
	public T pull() {
		return head;
	}
	
	public T peek() {
		return head;
	}
	
	public int Count() {
		return count;
	}
	
	public boolean IsEmpty() {
		return count==0;
	}
}
