package dataStructures;

/***
 * Clase de los nodos para moverse dentro del stack
 * @author Diego Alonzo
 *
 * @param <T> Generics
 */
public class SingleNode<T>{
	/**
	 * Creacion del nodo, con su valor y su apuntador.
	 */
	private T value;
	SingleNode<T> next;
	/**
	 * Creacion del nodo inicial, 
	 * cuando no tiene a quien apuntar.
	 */
	public SingleNode() {
		next = null;
	}
	/**
	 * Creacion del parametro de los nodos cuando tiene al menos a un nodo a quien apuntar. 
	 * Es un valor generico
	 * @param Value
	 */
	public SingleNode(T Value) {
		this.setValue(Value);
		next = null;
	}
	/**
	 * Metodos de getter y setters de value y next
	 * @return
	 */
	public T getValue() {
		return value;
	}
	
	public void setValue(T Value) {
		this.value = Value;
	}
	
	public SingleNode<T> getNext() {
		return next;
	}
	
	public void setNext(SingleNode<T> next) {
		// TODO Auto-generated method stub
		this.next = next;
	}
	


}