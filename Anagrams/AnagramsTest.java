/*
 * 
 * @author Zikang Sheng
 * I pledge my honor that I have abided by the Stevens Honor System.
 * 05/03/2020
 *
 */

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.Test;

class AnagramsTest {
	@Test
	void test1() {
		Anagrams a = new Anagrams();
		
		try {
			a.processFile("words_alpha.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ArrayList<Map.Entry<Long,ArrayList<String>>> maxEntries = a.getMaxEntries();
		assertEquals(maxEntries.get(0).getKey(), 236204078);
		assertEquals(maxEntries.get(0).getValue().get(0), "alerts");
		assertEquals(maxEntries.get(0).getValue().get(3), "estral");
		assertEquals(maxEntries.get(0).getValue().get(14), "talers");
		assertEquals(maxEntries.get(0).getValue().size(), 15);
	}
	
	@Test
	void test2() {
		Anagrams a = new Anagrams();
   
		try {
			a.processFile("mylist.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ArrayList<Map.Entry<Long,ArrayList<String>>> maxEntries = a.getMaxEntries();
		assertEquals(maxEntries.size(), 2);
		assertEquals(a.anagramTable.size(), 3);
		assertEquals(maxEntries.get(0).getKey(), 235790219);
		assertEquals(maxEntries.get(1).getValue().get(0), "night");
	}
	
	@Test
	void test3() {
		Anagrams a = new Anagrams();
  
		try {
			a.processFile("mylist2.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ArrayList<Map.Entry<Long,ArrayList<String>>> maxEntries = a.getMaxEntries();
		assertEquals(maxEntries.size(), 0);
		assertEquals(a.anagramTable.size(), 0);
		assertEquals(maxEntries.isEmpty(), true);
	}

}
