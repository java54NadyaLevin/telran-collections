package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.ArrayList;
import telran.util.List;

public abstract class ListTest extends CollectionTest {
	List<Integer> list;
	List<Integer> actual;

	@BeforeEach
	@Override
	void setUp() {
		super.setUp();
		list = (List<Integer>) collection;
	}

	@Test
	void getTest() {
		assertEquals(1, list.get(2));
		assertThrowsExactly(IndexOutOfBoundsException.class, () -> list.get(14));
		assertThrowsExactly(IndexOutOfBoundsException.class, () -> list.get(-3));
	}

	@Test
	void listAddTest() {
		Integer[] expected1 = { -20, 10, 1, 4, 100, -5 };
		Integer[] expected2 = { -20, 10, 1, 4, 100, -5, 7 };
		list.add(3, Integer.valueOf(4));
		assertArrayEquals(expected1, list.stream().toArray(Integer[]::new));
		list.add(6, Integer.valueOf(7));
		assertArrayEquals(expected2, list.stream().toArray(Integer[]::new));
		assertThrowsExactly(IndexOutOfBoundsException.class, () -> list.add(33, 2));
		assertThrowsExactly(IndexOutOfBoundsException.class, () -> list.add(-3, 3));
	}

	@Test
	void listRemoveTest() {
		Integer[] expected = { -20, 1, 100, -5 };
		list.remove(1);
		assertArrayEquals(expected, list.stream().toArray(Integer[]::new));
		Integer res = list.remove(2);
		assertEquals(100, res);
		assertThrowsExactly(IndexOutOfBoundsException.class, () -> list.remove(13));
		assertThrowsExactly(IndexOutOfBoundsException.class, () -> list.remove(-3));

	}

	@Test
	void indexOfTest() {
		collection.add(100);
		assertEquals(3, list.indexOf(Integer.valueOf(100)));
		assertEquals(-1, list.indexOf(Integer.valueOf(22)));
	}
	
	@Test
	void lastIndexOfTest() {
		collection.add(100);
		assertEquals(-1, list.lastIndexOf(Integer.valueOf(22)));
		assertEquals(5, list.lastIndexOf(Integer.valueOf(100)));
		
	}

}
