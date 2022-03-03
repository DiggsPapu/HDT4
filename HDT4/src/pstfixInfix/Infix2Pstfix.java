package pstfixInfix;

import dataStructures.ArrayList;
import dataStructures.DoubleLinkedList;
import dataStructures.Stack;
import dataStructures.SingleLinkedList;
import dataStructures.Vector;

public class Infix2Pstfix {
	Stack<String> infixList;
	String stackOp;
	Stack<Integer> stackStorage;
	
	/**
	 * Es un factory para crear un Stack de un tipo especifico de estructura de dato.
	 * @param text
	 * @param output
	 * @param opStack
	 */
	public void Infx2Pstfix(String output, String opStack){
		
		switch(stackCase(output)) {
		
		case 1:{
			stackStorage = new ArrayList<Integer>();
			infixList = new ArrayList<String>();
		}case 2:{
			stackStorage= new Vector<Integer>();
			infixList = new Vector<String>();
		}case 3:{
			stackStorage= new SingleLinkedList<Integer>();
			infixList = new SingleLinkedList<String>();
		}case 4:{
			stackStorage= new DoubleLinkedList<Integer>();
			infixList = new DoubleLinkedList<String>();
		}
		}
	}
	
	public Stack<String> readStack(String[] listValues){
		
		return infixList;
	}
	/**
	 * Es para evaluar los casos para saber que tipo de stack usar.
	 * 
	 * @param stackOption
	 * @return 
	 */
	private int stackCase(String stackOption){
		if (stackOption=="ArrayList") {
			return 1;
		}else if (stackOption == "Vector") {
			return 2;
		}else if (stackOption=="SingleLinkedList") {
			return 3;
		}else if (stackOption=="DoubleLinkedList") {
			return 4;
		}else {
			return 0;
		}
	}
	
	
}
