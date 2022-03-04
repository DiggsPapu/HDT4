package junitTestpstfixInfix;

import static org.junit.jupiter.api.Assertions.*;
import pstfixInfix.Infix2Pstfix;
import org.junit.jupiter.api.Test;

import dataStructures.Stack;

class Infix2PstfixTest {
	/**
	 * Es para leer las listas y poder hacer la prueba de si funciona
	 * la traduccion de infix a potfix.
	 * @param lista
	 * @return
	 */
	String ReadList(Stack<String> lista) {
		String infix = new String();
		int length = lista.Count();
		for (int k = 0; k<=length; k++) {
			infix+=lista.pull();
		}
		return infix;
	}
	
	/**
	 * Es el test para saber si es que se hace la misma traduccion para todos
	 * los tipos de estructuras de datos manejadas
	 */
	@Test
	void testReadStack() {
		Infix2Pstfix infix1 = new Infix2Pstfix();
		String[] list = {"(","(","1","+","3",")","*","24","*","3","^","(","1","/","2",")",")","^","(","2903","+","23","*","40",")"};
		
		infix1.Infx2Pstfix("Vector",list);
		infix1.readStack(list);
		
		Infix2Pstfix infix2 = new Infix2Pstfix();
		infix2.Infx2Pstfix("ArrayList",list);
		infix2.readStack(list);
		
		Infix2Pstfix infix3 = new Infix2Pstfix();
		infix3.Infx2Pstfix("SingleLinkedList",list);
		infix3.readStack(list);
		
		Infix2Pstfix infix4 = new Infix2Pstfix();
		infix4.Infx2Pstfix("DoubleLinkedList",list);
		infix4.readStack(list);
		
		assertEquals(ReadList(infix1.getInfixList()),ReadList(infix2.getInfixList()));
		assertEquals(ReadList(infix1.getInfixList()),ReadList(infix3.getInfixList()));
		assertEquals(ReadList(infix1.getInfixList()),ReadList(infix4.getInfixList()));
	}

}
