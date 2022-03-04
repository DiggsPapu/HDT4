package junitTestpstfixInfix;

import static org.junit.jupiter.api.Assertions.*;

import pstfixInfix.Infix2Pstfix;
import pstfixInfix.Postfix;
import org.junit.jupiter.api.Test;

import dataStructures.DoubleLinkedList;
import dataStructures.SingleLinkedList;

class PostfixTest {

	@Test
	void testEvaluatePsfx() {
		Infix2Pstfix translate = new Infix2Pstfix();
		String[] list = {"(","1","+","3",")","*","24","*","3","^","(","1","/","2",")"};
		translate.Infx2Pstfix("ArrayList", list);
		Postfix postfix = new Postfix();
		
		assertEquals(166.27687072753906,postfix.evaluatePsfx(translate.readStack(list)) );
	}

}
