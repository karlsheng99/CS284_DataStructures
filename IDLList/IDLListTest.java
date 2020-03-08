/*
 * 
 * @author Zikang Sheng
 * I pledge my honor that I have abided by the Stevens Honor System.
 * 03/08/2020
 *
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IDLListTest {
	IDLList<Integer> list = new IDLList<Integer>();

	@Test
	void add() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		assertEquals(list.toString(), "[4, 3, 2, 1, ]");
	}
	
	@Test
	void addElemToP() {
		list.add(0, 1);
		list.add(0, 2);
		list.add(2, 4);
		list.add(1, 6);
		
		assertEquals(list.toString(), "[2, 6, 1, 4, ]");
	}
	
	@Test
	void addElemToPError() {
		list.add(0, 1);
		list.add(0, 2);
		list.add(1, 6);
		
		Assertions.assertThrows(IllegalStateException.class, () -> {
			list.add(10, 4);
		});
	}
	
	@Test
	void append() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.append(9);
		list.append(10);
		
		assertEquals(list.toString(), "[4, 3, 2, 1, 9, 10, ]");
	}
	
	@Test
	void get() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		assertEquals(list.get(1), 3);
	}
	
	@Test
	void getError() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		Assertions.assertThrows(IllegalStateException.class, () -> {
			list.get(4);
		});
	}
	
	@Test
	void getHead() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		assertEquals(list.getHead(), 4);
	}
	
	@Test
	void getLast() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		assertEquals(list.getLast(), 1);
	}
	
	@Test
	void size() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.remove();
		
		assertEquals(list.size(), 3);
	}
	
	@Test
	void remove() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.remove();
		
		assertEquals(list.toString(), "[3, 2, 1, ]");
	}
	
	@Test
	void removeError() {
		Assertions.assertThrows(IllegalStateException.class, () ->{
			list.remove();
		});
	}
	
	@Test
	void removeLast() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.removeLast();
		
		assertEquals(list.toString(), "[4, 3, 2, ]");
	}
	
	@Test
	void removeLastError() {
		Assertions.assertThrows(IllegalStateException.class, () ->{
			list.removeLast();
		});
	}
	
	@Test
	void removeAt() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.removeAt(2);
		
		assertEquals(list.toString(), "[4, 3, 1, ]");
	}
	
	@Test
	void removeAtError() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		Assertions.assertThrows(IllegalStateException.class, () ->{
			list.removeAt(5);
		});
	}
	
	@Test
	void removeElem() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(2);
		list.remove(2);
		
		assertEquals(list.toString(), "[4, 3, 2, 1, ]");
	}
	
	@Test
	void removeElem1() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		assertEquals(list.remove(5), false);
		
	}
}
