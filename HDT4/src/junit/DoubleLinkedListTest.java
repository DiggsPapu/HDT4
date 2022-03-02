package junit;
/**
 * @author Diego Alonzo -20172
 * La mayoria fue obtenido de lo compartido por moises 
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import dataStructures.DoubleLinkedList;
import java.util.Random;
class DoubleLinkedListTest {
	DoubleLinkedList<Integer> testListPotente1 = new DoubleLinkedList<Integer>();
	DoubleLinkedList<Integer> testListPotente2 = new DoubleLinkedList<Integer>();
	Random random = new Random();
	/**
	 * @category preparation
	 * Es para hacer test complicados y verificar que pasen eso.
	 */
	void PreparacionDeLosTest() {
		for (int k=0; k<40; k++) {
			testListPotente1.InsertAtStart(k*40);
			testListPotente2.InsertAtEnd(k*40);
		}
	}
	/**
	 * Sirve para comprobar sí funciona la inserción en una lista vacía.
	 * @param Nueva testList
	 * @return boolean
	 */
	@Test
	void InsertAtStartEmptyListTest() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		testList.InsertAtStart(5);
		assertEquals(testList.Get(0), 5);
	}
	
	@Test
	void testInsertAtStart() {
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
	void TestDeleteEmptyList() {
		DoubleLinkedList<String> testEmptyList = new DoubleLinkedList<String>();
		assertEquals(null, testEmptyList.DeleteAtEnd());
		assertEquals(null, testEmptyList.DeleteAtStart());
		assertEquals(null, testEmptyList.Delete(50));
	}
	
	/**
	 * La primera parte del test es para preparar las listas.
	 * La segunda parte del test es para comprobar el metodo al eliminar valores que esten en el rango menos el ultimo y el primero
	 * La tercera parte es para comprobar el metodo al eliminar el ultimo
	 * La cuarta es para comprobar el metodo al eliminar el primero.
	 * @category pull
	 * @param valorInicial, randomValues, testListPotente en Index
	 */
	@Test
	void testDelete() {
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
		
		DoubleLinkedList<String> testEmptyList = new DoubleLinkedList<String>();
		assertEquals(null, testEmptyList.Delete(50));
	}
	
	/**
	 * Es para saber si funciona el metodo de DeleteAtStart().
	 * La primera parte es para listas con mas de un elemento.
	 * La segunda es para listas con un elemento.
	 * La tercera es para listas vacias.
	 * @parmas testListPotente1 index(0), varInicial
	 * @return True
	 */
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
	
	/**
	 * Es para saber si funciona el metodo de DeleteAtEnd.
	 * La primera parte es para listas con mas de un elemento.
	 * La segunda es para listas con un elemento.
	 * La tercera es para listas vacias.
	 * @parmas testListPotente1 index(0), varInicial
	 * @return True
	 */
	@Test
	void testDeleteAtEnd() {
		//Primera Parte
		PreparacionDeLosTest();
		Integer indexInicial= testListPotente1.Get(testListPotente1.Count()-2);
		testListPotente1.DeleteAtEnd();
		assertEquals(testListPotente1.Get(testListPotente1.Count()-1), indexInicial);
		//Segunda Parte
		DoubleLinkedList<String> elementList = new DoubleLinkedList<String>();
		elementList.Insert("fjdk", 9830);
		elementList.DeleteAtEnd();
		//Tercera Parte
		DoubleLinkedList<String> testEmptyList = new DoubleLinkedList<String>();
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
	void testCount1() {
		PreparacionDeLosTest();
		assertEquals(testListPotente2.count(), testListPotente1.count());	}

	@Test
	void testIsEmpty1() {
		DoubleLinkedList<String> empty = new DoubleLinkedList<String>();
		assertEquals(true, empty.isEmpty());	}

	@Test
	void testPush() {
		PreparacionDeLosTest();
		testListPotente2.InsertAtStart(438920); 
		testListPotente1.push(438920);
		assertEquals(testListPotente2.pull(), testListPotente1.pull());
	}

}
