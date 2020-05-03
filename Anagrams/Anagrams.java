/*
 * 
 * @author Zikang Sheng
 * I pledge my honor that I have abided by the Stevens Honor System.
 * 05/03/2020
 *
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Anagrams {
	final Integer[] primes =  
			{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 
			31, 37, 41, 43, 47, 53, 59, 61, 67, 
			71, 73, 79, 83, 89, 97, 101};
	Map<Character,Integer> letterTable;
	Map<Long,ArrayList<String>> anagramTable;

	public void buildLetterTable() {
		letterTable = new HashMap<Character, Integer>();
		for (int i=0; i<26; i++) {
			letterTable.put((char)('a'+i), primes[i]);
		}
	}

	Anagrams() {
		buildLetterTable();
		anagramTable = new HashMap<Long,ArrayList<String>>();
	}

	public void addWord(String s) {
		 long key = myhashcode(s);
		 if (anagramTable.containsKey(key)) {
			 anagramTable.get(key).add(s);
		 }
		 else {
			 ArrayList<String> value = new ArrayList<String>();
			 value.add(s);
			 anagramTable.put(key, value);
		 }
	}
	
	public long myhashcode(String s) {
		long result = 1;
		for (int i=0; i<s.length(); i++) {
			result *= letterTable.get(s.charAt(i));
		}
		return result;
	}
	
	public void processFile(String s) throws IOException {
		FileInputStream fstream = new FileInputStream(s);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		while ((strLine = br.readLine()) != null)   {
		  this.addWord(strLine);
		}
		br.close();
	}
	
	public ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries() {
	    ArrayList<Map.Entry<Long, ArrayList<String>>> result = new ArrayList<Map.Entry<Long, ArrayList<String>>>();
	    long max = 0;
	    for (Map.Entry<Long, ArrayList<String>> entry: anagramTable.entrySet()) {
	    	if (entry.getValue().size()>max) {
	    		result.clear();
	    		result.add(entry);
	    		max = entry.getValue().size();
	    	}
	    	else if (entry.getValue().size()==max) {
	    		result.add(entry);
	    	}
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		Anagrams a = new Anagrams();

		final long startTime = System.nanoTime();    
		try {
			a.processFile("words_alpha.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ArrayList<Map.Entry<Long,ArrayList<String>>> maxEntries = a.getMaxEntries();
		final long estimatedTime = System.nanoTime() - startTime;
		final double seconds = ((double) estimatedTime/1000000000);
		System.out.println("Time: "+ seconds);
		
		for (int i=0; i<maxEntries.size(); i++) {
			System.out.println("Key of max anagrams: "+ maxEntries.get(i).getKey());
			System.out.println("List of max anagrams: "+ maxEntries.get(i).getValue());
			System.out.println("Length of list of max anagrams: "+ maxEntries.get(i).getValue().size());
		}
		
	}
}
