package dataStructures;

/***
 * Clase de los nodos para moverse dentro del stack
 * @author Diego Alonzo
 *
 * @param <T> Generics
 */
public class Node<T> {
	/**
	 * Creacion del nodo, con su valor y su apuntador.
	 */
	private T Value;
	Node<T> next;
	/**
	 * Creacion del nodo inicial, 
	 * cuando no tiene a quien apuntar.
	 */
	public Node() {
		next = null;
	}
	/**
	 * Creacion del parametro de los nodos cuando tiene al menos a un nodo a quien apuntar. 
	 * Es un valor generico
	 * @param Value
	 */
	public Node(T Value) {
		this.Value = Value;
		next = null;
	}
	/**
	 * Metodos de getter y setters de value y next
	 * @return
	 */
	public T getValue() {
		return Value;
	}
	
	public void setValue(T value) {
		Value = value;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}

}