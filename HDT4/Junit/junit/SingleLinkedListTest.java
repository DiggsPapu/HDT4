package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import dataStructures.DoubleLinkedList;
import dataStructures.SingleLinkedList;
class SingleLinkedListTest {

	SingleLinkedList<Integer> testListPotente1 = new SingleLinkedList<Integer>();
	SingleLinkedList<Integer> testListPotente2 = new SingleLinkedList<Integer>();
	Random random = new Random();
	/**
	 * @category preparation
	 * Es para hacer test complicados y verificar que pasen eso.
	 */
	void PreparacionDeLosTest() {
		int a = random.nextInt(40);
		for (int k=0; k<40; k++) {
			testListPotente1.InsertAtStart(a*k);
			testListPotente2.InsertAtEnd(k*a);
		}
	}
	@Test
	void testPush() {
		PreparacionDeLosTest();
		testListPotente2.InsertAtStart(438920); 
		testListPotente1.push(438920);
		assertEquals(testListPotente2.pull(), testListPotente1.pull());
	}

	@Test
	void testPull() {
		PreparacionDeLosTest();
		testListPotente2.push(109);
		testListPotente1.push(109);
		assertEquals(testListPotente2.DeleteAtStart(), testListPotente1.pull());
	}

	@Test
	void testPeek() {
		PreparacionDeLosTest();
		assertEquals(testListPotente2.Get(0), testListPotente2.peek());
	}

	@Test
	void testInsertAtStart() {
		SingleLinkedList<Integer> testList = new SingleLinkedList<Integer>();
		testList.InsertAtStart(5);
		assertEquals(testList.Get(0), 5);
		
		PreparacionDeLosTest();
		assertEquals(testListPotente1.Get(testListPotente1.Count()-30), testListPotente2.Get(29));
		Integer variableRandom = random.nextInt();
		testListPotente1.InsertAtStart(variableRandom);
		testListPotente2.InsertAtStart(variableRandom);
		assertEquals(testListPotente1.Get(0), testListPotente2.Get(0));
		
	}

	@Test
	void testInsertAtEnd() {
		PreparacionDeLosTest();
		assertEquals(testListPotente2.Get(testListPotente2.Count()-1), testListPotente1.Get(0));
		Integer variableRandom = random.nextInt();
		testListPotente1.InsertAtEnd(variableRandom);
		testListPotente2.InsertAtEnd(variableRandom);
		assertEquals(testListPotente2.Get(testListPotente2.Count()-1), testListPotente1.Get(testListPotente2.Count()-1));
	}

	@Test
	void testInsert() {
		PreparacionDeLosTest();
		testListPotente2.Insert(4893, 20);
		testListPotente1.Insert(4893, 20);
		assertEquals(testListPotente2.Get(20),testListPotente1.Get(20));
		assertNotEquals(testListPotente2.Get(0), testListPotente1.Get(0));
	}


	@Test
	void testDelete() {
		SingleLinkedList<String> testEmptyList = new SingleLinkedList<String>();
		assertEquals(null, testEmptyList.DeleteAtEnd());
		assertEquals(null, testEmptyList.DeleteAtStart());
		assertEquals(null, testEmptyList.Delete(50));
		
		PreparacionDeLosTest();
		
		Integer valorRandom0 = random.nextInt(testListPotente2.Count());
		Integer valorInicial1 = testListPotente2.Get(valorRandom0+1);		
		testListPotente2.Delete(valorRandom0);
		assertEquals(valorInicial1, testListPotente2.Get(valorRandom0) );
		
		Integer valorRandom1 = random.nextInt(testListPotente2.Count());
		Integer valorInicial2 = testListPotente2.Get(valorRandom1+1);
		testListPotente2.Delete(valorRandom1);
		assertEquals(valorInicial2, testListPotente2.Get(valorRandom1) );
		
		Integer valorInicial3 = testListPotente2.Get(testListPotente2.Count()-2);
		testListPotente2.Delete(8490);
		assertEquals(testListPotente2.Get(testListPotente2.Count()-1), valorInicial3);
		
		Integer valorInicial4 = testListPotente2.Get(0+1);
		testListPotente2.Delete(-32891);
		assertEquals(valorInicial4, testListPotente2.Get(0));
		
		SingleLinkedList<String> testMptyList = new SingleLinkedList<String>();
		assertEquals(null, testMptyList.Delete(50));
	}

	@Test
	void testDeleteAtStart() {
		//Primera Parte
				PreparacionDeLosTest();
				Integer indexInicial= testListPotente1.Get(1);
				testListPotente1.DeleteAtStart();
				assertEquals(testListPotente1.Get(0), indexInicial);
				//Segunda Parte
				DoubleLinkedList<String> elementList = new DoubleLinkedList<String>();
				elementList.Insert("fjdk", 9830);
				elementList.DeleteAtStart();
				assertEquals(elementList.Get(0), null);
				//Tercera Parte
				DoubleLinkedList<String> testEmptyList = new DoubleLinkedList<String>();
				assertEquals(null, testEmptyList.DeleteAtStart());
	}

	@Test
	void testDeleteAtEnd() {
		//Primera Parte
				PreparacionDeLosTest();
				Integer indexInicial= testListPotente1.Get(testListPotente1.Count()-2);
				testListPotente1.DeleteAtEnd();
				assertEquals(testListPotente1.Get(testListPotente1.Count()-1), indexInicial);
				//Segunda Parte
				SingleLinkedList<String> elementList = new SingleLinkedList<String>();
				elementList.Insert("fjdk", 9830);
				elementList.DeleteAtEnd();
				//Tercera Parte
				SingleLinkedList<String> testEmptyList = new SingleLinkedList<String>();
				assertEquals(null, testEmptyList.DeleteAtEnd());
	}

	@Test
	void testGet() {
		PreparacionDeLosTest();
		Integer randomValue = random.nextInt(39);
		assertEquals(testListPotente1.Get(testListPotente1.Count()-1-randomValue), testListPotente2.Get(randomValue));
	}

	@Test
	void testIsEmpty() {
		DoubleLinkedList<String> empty = new DoubleLinkedList<String>();
		assertEquals(true, empty.IsEmpty());
	}

	@Test
	void testCount() {
		PreparacionDeLosTest();
		assertEquals(40, testListPotente1.Count());
	}

}
