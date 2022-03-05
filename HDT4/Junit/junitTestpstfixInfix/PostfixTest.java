package junitTestpstfixInfix;

import static org.junit.jupiter.api.Assertions.*;

import pstfixInfix.Infix2Pstfix;
import pstfixInfix.Postfix;
import org.junit.jupiter.api.Test;

class PostfixTest {
	
	/**
	 * Es un test para evaluar si el PostfixFunciona
	 */
	@Test
	void testEvaluatePsfx() {
		Infix2Pstfix translate = new Infix2Pstfix();
		String[] list = {"(","1","+","3",")","*","24","*","3","^","(","1","/","2",")"};
		//Para ArrayList
		translate.Infx2Pstfix("ArrayList", list);
		Postfix postfix = new Postfix();
		assertEquals(166.27687072753906,postfix.evaluatePsfx(translate.readStack(list),"ArrayList") );
		//Para Vector
		translate.Infx2Pstfix("Vector", list);
		Postfix postfix1 = new Postfix();
		assertEquals(166.27687072753906,postfix1.evaluatePsfx(translate.readStack(list),"Vector") );
		//Para SingleLinkedList
		translate.Infx2Pstfix("SingleLinkedList", list);
		Postfix postfix2 = new Postfix();
		assertEquals(166.27687072753906,postfix2.evaluatePsfx(translate.readStack(list),"SingleLinkedList") );
		//Para DoubleLinkedList
		translate.Infx2Pstfix("DoubleLinkedList", list);
		Postfix postfix3 = new Postfix();
		assertEquals(166.27687072753906,postfix3.evaluatePsfx(translate.readStack(list),"DoubleLinkedList") );
		//Para comparar entre ellos
		assertEquals(postfix.evaluatePsfx(translate.readStack(list),"ArrayList"),postfix1.evaluatePsfx(translate.readStack(list),"Vector"));
		assertEquals(postfix2.evaluatePsfx(translate.readStack(list),"SingleLinkedList"),postfix.evaluatePsfx(translate.readStack(list),"Vector"));
		assertEquals(postfix2.evaluatePsfx(translate.readStack(list),"SingleLinkedList"),postfix3.evaluatePsfx(translate.readStack(list),"DoubleLinkedList"));
	}

}
