package junitTestDataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import dataStructures.ArrayList;
class ArrayListTest {

	@Test
	void testArrayList() {
		ArrayList<String> arrayEmpty = new ArrayList<String>();
		assertEquals(arrayEmpty.peek(), null);
	}

	@Test
	void testPush() {
		ArrayList<String> arrayNotEmpty = new ArrayList<String>();
		arrayNotEmpty.push("Las Flautas domesticas");
		assertEquals(arrayNotEmpty.peek(), "Las Flautas domesticas");
	}

	@Test
	void testPull() {
		ArrayList<String> arrayNotEmpty = new ArrayList<String>();
		arrayNotEmpty.push("Los arrancacebollas");
		assertEquals(arrayNotEmpty.pull(), "Los arrancacebollas");	}

	@Test
	void testPeek() {
		ArrayList<String> arrayNotEmpty = new ArrayList<String>();
		arrayNotEmpty.push("ChocoChocolala");
		assertEquals(arrayNotEmpty.peek(), "ChocoChocolala");
	}

	@Test
	void testCount() {
		ArrayList<String> arrayNotEmpty = new ArrayList<String>();
		arrayNotEmpty.push("ChocoChocolala");
		arrayNotEmpty.push("ChocoChocolala");
		arrayNotEmpty.push("ChocoChocolala");
		assertEquals(arrayNotEmpty.Count(), 3);
		ArrayList<String> arrayEmpty = new ArrayList<String>();
		assertEquals(arrayEmpty.Count(), 0);
	}

	@Test
	void testIsEmpty() {
		ArrayList<String> arrayNotEmpty = new ArrayList<String>();
		arrayNotEmpty.push("ChocoChocolala");
		arrayNotEmpty.push("ChocoChocolala");
		arrayNotEmpty.push("ChocoChocolala");
		assertEquals(arrayNotEmpty.IsEmpty(), false);
		ArrayList<String> arrayEmpty = new ArrayList<String>();
		assertEquals(arrayEmpty.IsEmpty(), true);
	}

}
