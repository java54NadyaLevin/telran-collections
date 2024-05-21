package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.List;

public abstract class ListTest extends CollectionTest {
   List<Integer> list;
   @BeforeEach
   @Override
   void setUp() {
	   super.setUp();
	   list = (List<Integer>)collection;
   }
   
   @Test
   void getTest() {
	   assertEquals(1, list.get(2));
	   assertThrowsExactly(IndexOutOfBoundsException.class, () -> list.get(14));
	   assertThrowsExactly(IndexOutOfBoundsException.class, () -> list.get(-3));
   }
   
   
//	@Test
//	void removeNegativeTest() {
//		collection.remove(16);
//		assertThrowsExactly(IndexOutOfBoundsException.class, () -> collection.remove(16));
//	}
	
   //TODO Write all test for methods from interface List (see interface telran.util.List)
}
