package telran.util.test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Collection;

public abstract class CollectionTest {
	protected Collection<Integer> collection;
	Integer[] numbers = {-20, 10, 1, 100, -5};
	
	@BeforeEach
	void setUp() {
		
		for(Integer num: numbers) {
			collection.add(num);
		}
	}
	@Test
	void iteratorTest() {
		runTest(numbers);
	}
	protected void runTest(Integer[] expected) {
		Integer [] actual = collection.stream().toArray(Integer[]::new);
		assertArrayEquals(expected, actual);
	};
	
	@Test
	void addTest() {
		Integer[] expected1 = {-20, 10, 1, 100, -5, 15};
		collection.add(15);
		Integer [] actual = collection.stream().toArray(Integer[]::new);	
		assertArrayEquals(expected1, actual);
		
	}
	
	@Test
	void addResultTest() {
		boolean res = collection.add(Integer.valueOf(7));
		assertEquals(true, res);
	}
	
	@Test
	void removeTest() {
		Integer[] expected = {-20, 10, 1, 100};
		collection.remove(Integer.valueOf(-5));
		Integer [] actual = collection.stream().toArray(Integer[]::new);
		assertArrayEquals(expected, actual);	
	}
	
	@Test
	void removeResultTest() {
		boolean res = collection.remove(Integer.valueOf(7));
		assertEquals(false, res);
	}
	
	@Test
	void containsTest() {
		boolean res1 = collection.contains(Integer.valueOf(100));
		assertEquals(true, res1);
		boolean res2 = collection.contains(Integer.valueOf(22));
		assertEquals(false, res2);
	}	
}
