/*
 * 
 * @author Zikang Sheng
 * I pledge my honor that I have abided by the Stevens Honor System.
 * 04/21/2020
 *
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TreapTest {

	Treap<Integer> ti = new Treap<Integer>();
	Treap<Character> tc = new Treap<Character>();
	
	@Test
	void intTestAdd() {
		assertEquals(ti.add(4,19), true);
		assertEquals(ti.add(4,11), false);
		ti.add (2, 31);
		ti.add (6, 70);
		ti.add (1, 84);
		ti.add (3, 12);
		ti.add (5, 83);
		ti.add (7, 26);
		assertEquals(ti.add(5), false);
		assertEquals(ti.add(5,10), false);
		
		assertEquals(ti.toString(),
				"(key=1, priority=84)\n" + 
				"	null\n" + 
				"	(key=5, priority=83)\n" + 
				"		(key=2, priority=31)\n" + 
				"			null\n" + 
				"			(key=4, priority=19)\n" + 
				"				(key=3, priority=12)\n" + 
				"					null\n" + 
				"					null\n" + 
				"				null\n" + 
				"		(key=6, priority=70)\n" + 
				"			null\n" + 
				"			(key=7, priority=26)\n" + 
				"				null\n" + 
				"				null\n");
	}
	
	@Test
	void intTestDelete() {
		ti.add (4, 19);
		ti.add (2, 31);
		ti.add (6, 70);
		ti.add (1, 84);
		ti.add (3, 12);
		ti.add (5, 83);
		ti.add (7, 26);
		assertEquals(ti.delete(1), true);
		assertEquals(ti.delete(10), false);
		assertEquals(ti.toString(),
				"(key=5, priority=83)\n" + 
				"	(key=2, priority=31)\n" + 
				"		null\n" +
				"		(key=4, priority=19)\n" +
				"			(key=3, priority=12)\n" +
				"				null\n" +
				"				null\n" +
				"			null\n" +	
				"	(key=6, priority=70)\n" +
				"		null\n" + 
				"		(key=7, priority=26)\n" + 
				"			null\n" + 
				"			null\n");
	}
	
	@Test
	void intTestFind() {
		ti.add (4, 19);
		ti.add (2, 31);
		ti.add (6, 70);
		ti.add (1, 84);
		ti.add (3, 12);
		ti.add (5, 83);
		ti.add (7, 26);
		assertEquals(ti.find(1), true);
		assertEquals(ti.find(10), false);
	}
	
	@Test
	void charTestAdd() {
		tc.add('p', 99);
		tc.add('g', 80);
		tc.add('a', 60);
		tc.add('j', 65);
		tc.add('u', 75);
		tc.add('r', 40);
		tc.add('z', 47);
		tc.add('w', 32);
		tc.add('v', 21);
		tc.add('x', 25);
		tc.add('i', 93);
		assertEquals(tc.toString(), 
				"(key=p, priority=99)\n" + 
				"	(key=i, priority=93)\n" + 
				"		(key=g, priority=80)\n" + 
				"			(key=a, priority=60)\n" + 
				"				null\n" + 
				"				null\n" + 
				"			null\n" + 
				"		(key=j, priority=65)\n" + 
				"			null\n" + 
				"			null\n" + 
				"	(key=u, priority=75)\n" + 
				"		(key=r, priority=40)\n" + 
				"			null\n" + 
				"			null\n" + 
				"		(key=z, priority=47)\n" + 
				"			(key=w, priority=32)\n" + 
				"				(key=v, priority=21)\n" + 
				"					null\n" + 
				"					null\n" + 
				"				(key=x, priority=25)\n" + 
				"					null\n" + 
				"					null\n" + 
				"			null\n");
	}
	
	@Test
	void charTestDelete() {
		tc.add('p', 99);
		tc.add('g', 80);
		tc.add('a', 60);
		tc.add('j', 65);
		tc.add('u', 75);
		tc.add('r', 40);
		tc.add('z', 47);
		tc.add('w', 32);
		tc.add('v', 21);
		tc.add('x', 25);
		tc.delete('p');
		assertEquals(tc.toString(), 
				"(key=g, priority=80)\n" + 
				"	(key=a, priority=60)\n" + 
				"		null\n" + 
				"		null\n" + 
				"	(key=u, priority=75)\n" + 
				"		(key=j, priority=65)\n" + 
				"			null\n" + 
				"			(key=r, priority=40)\n" + 
				"				null\n" + 
				"				null\n" + 
				"		(key=z, priority=47)\n" + 
				"			(key=w, priority=32)\n" + 
				"				(key=v, priority=21)\n" + 
				"					null\n" + 
				"					null\n" + 
				"				(key=x, priority=25)\n" + 
				"					null\n" + 
				"					null\n" + 
				"			null\n");
	}
	
	@Test
	void charTestFind() {
		tc.add('p', 99);
		tc.add('g', 80);
		tc.add('a', 60);
		tc.add('j', 65);
		tc.add('u', 75);
		tc.add('r', 40);
		tc.add('z', 47);
		tc.add('w', 32);
		tc.add('v', 21);
		tc.add('x', 25);
		tc.add('i', 93);
		assertEquals(tc.find('a'), true);
		assertEquals(tc.find('z'), true);
		assertEquals(tc.find('b'), false);
	}

}
