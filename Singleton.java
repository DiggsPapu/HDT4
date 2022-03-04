package pstfixInfix;

import dataStructures.DoubleLinkedList;
import dataStructures.Stack;

public class Singleton {    
	private static Singleton SN = null;   
	public Stack<Float> stackNum;   
	public Singleton()   
	{   
	stackNum = new DoubleLinkedList<Float>();  
	}   
	public static Singleton getInstance()   
	{   
	if (SN== null)   
	SN = new Singleton();   
	return SN;   
	}   
}  

