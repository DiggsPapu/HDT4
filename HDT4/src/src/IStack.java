package src;
/**
 * 
 * @author diego alonzo 20172
 *Es generic y es un ADT
 * @param <T>
 */
public interface IStack<T> {

	void push(T value);
	
	T pull();
	
	T peek();
	
	int count();
	
	boolean isEmpty();
}
