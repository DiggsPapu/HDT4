package junitTestDataStructures;

import static org.junit.jupiter.api.Assertions.*;
import dataStructures.Vector;
import org.junit.jupiter.api.Test;

class VectorTest {

	@Test
	void testPush() {
		Vector<String> vector = new Vector<String>(20);
		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");
		assertEquals("Blanco", vector.peek());
	}

	@Test
	void testPull() {
		Vector<String> vector = new Vector<String>(20);
		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");
		vector.pull();
		assertEquals("Gonzalez", vector.peek());
	}

	@Test
	void testPeek() {
		Vector<String> vector = new Vector<String>(20);
		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");
		vector.pull();
		assertEquals("Gonzalez", vector.peek());

		assertEquals("Gonzalez", vector.peek());
	}

	@Test
	void testCount() {
		Vector<String> vector = new Vector<String>(20);
		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");		vector.push("Raul");
		vector.push("Gonzalez");
		vector.push("Blanco");
		assertEquals(20, vector.Count());
	}

	@Test
	void testIsEmpty() {
		Vector<String> vector = new Vector<String>(20);
		assertEquals(true, vector.IsEmpty());
	}

}
