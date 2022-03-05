package junitTestpstfixInfix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructures.DoubleLinkedList;
import pstfixInfix.Calculator;
import pstfixInfix.Postfix;
class CalculatorTest {
/**
 * Para saber si devuelve la misma calculadora al ser singleton
 */
	@Test
	void testGetInstance() {
		Calculator calculator1 = Calculator.getInstance();
		Calculator calculator2 = Calculator.getInstance();
		assertEquals(calculator1.hashCode(), calculator2.hashCode());
	}
/**
 * Para saber si funciona la suma
 */
	@Test
	void testAdd() {

		String[] list = {"1","3","+","24","3","1","2","+","+","+","+"};
		
		DoubleLinkedList<String> stack = new DoubleLinkedList<String>();
		
		for (int k = 0; k<list.length; k++) {
			stack.push(list[list.length-1-k]);
			System.out.print(stack.peek()+ "\n");
		}
		Postfix postfix = new Postfix();
		assertEquals((float)34,postfix.evaluatePsfx(stack, "DoubleLinkedList"));
	}
/**
 * Para saber si funciona la resta
 */
	@Test
	void testSubs() {
		String[] list = {"1","3","-","24","3","1","2","-","-","-","-"};
		
		DoubleLinkedList<String> stack = new DoubleLinkedList<String>();
		
		for (int k = 0; k<list.length; k++) {
			stack.push(list[list.length-1-k]);
			System.out.print(stack.peek()+ "\n");
		}
		Postfix postfix = new Postfix();
		assertEquals((float)-22,postfix.evaluatePsfx(stack, "DoubleLinkedList"));
	}
/**
 * Para saber si funciona la multiplicacion
 */
	@Test
	void testMult() {
		String[] list = {"1","3","*","24","3","1","2","*","*","*","*"};
		
		DoubleLinkedList<String> stack = new DoubleLinkedList<String>();
		
		for (int k = 0; k<list.length; k++) {
			stack.push(list[list.length-1-k]);
			System.out.print(stack.peek()+ "\n");
		}
		Postfix postfix = new Postfix();
		assertEquals((float)432,postfix.evaluatePsfx(stack, "DoubleLinkedList"));
	}
/**
 * Para saber si funciona la division
 */
	@Test
	void testDiv() {
		String[] list = {"1","3","/"};
		
		DoubleLinkedList<String> stack = new DoubleLinkedList<String>();
		
		for (int k = 0; k<list.length; k++) {
			stack.push(list[list.length-1-k]);
			System.out.print(stack.peek()+ "\n");
		}
		Postfix postfix = new Postfix();
		assertEquals((float)1/3,postfix.evaluatePsfx(stack, "DoubleLinkedList"));
	}
/**
 * Para saber si funciona el exponencial
 */
	@Test
	void testExp() {
		String[] list = {"2","25","^"};
		
		DoubleLinkedList<String> stack = new DoubleLinkedList<String>();
		
		for (int k = 0; k<list.length; k++) {
			stack.push(list[list.length-1-k]);
			System.out.print(stack.peek()+ "\n");
		}
		Postfix postfix = new Postfix();
		assertEquals((float)2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2,postfix.evaluatePsfx(stack, "DoubleLinkedList"));
	}

}
