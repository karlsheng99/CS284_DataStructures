/*
 * 
 * @author Zikang Sheng
 * I pledge my honor that I have abided by the Stevens Honor System.
 * 05/11/2020
 *
 */

package SpecialAssignment_2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
	// Data fields
	public Map<Character, BSFamilyTree> directory;

	/**
     	* Creates a new phone book with an empty directory.
     	*/
	public PhoneBook() {
		directory = new HashMap<Character, BSFamilyTree>();
		for (int i=0; i<26; i++) {
			directory.put((char)('A'+i), new BSFamilyTree());
		}
	}

	/*
	 * Returns the instance of BSFamilyTree at the indicated letter
	 * Must accept lowercase letters as well as uppercase letters
	 */
	public BSFamilyTree getFamilyTree(char letter) {
		if (!Character.isLetter(letter)) {
			throw new IllegalArgumentException("Invalid parameter!");
		}
		letter = Character.toUpperCase(letter);
		return directory.get(letter);
	}

	/*
	 * Adds a FamilyTreeNode to the PhoneBook
	 */
	public void addFamily(String lastName) {
		char letter = lastName.charAt(0);
		getFamilyTree(letter).addFamilyTreeNode(lastName);
	}

	/*
	 * Adds a Person to the PhoneBook
	 * If a FamilyTreeNode with the given last name doesn't currently exist, create the FamilyTreeNode
	 */
	public void addPerson(String lastName, String firstName, String phoneNumber) {
		Person p = new Person(lastName, firstName, phoneNumber);
		
		for (int i='A'; i<='Z'; i++) {
			if (getFamilyTree((char) i).doesNumberExist(phoneNumber)) {
				throw new IllegalArgumentException("This phone number already exists!");
			}
		}
		
		char letter = lastName.charAt(0);
		if (!getFamilyTree(letter).doesFamilyExist(lastName)) {
			addFamily(lastName);
		}
		
		getFamilyTree(letter).getFamilyTreeNode(lastName).addFamilyMember(p);
	}

	/*
	 * Finds the phone number of a person
	 * Returns 'Does not exist.' if not found.
	 */
	public String getPhoneNumber(String lastName, String firstName) {
		char letter = lastName.charAt(0);
		if (!getFamilyTree(letter).doesFamilyExist(lastName)) {
			return "Does not exist.";
		}
		return getFamilyTree(letter).getFamilyTreeNode(lastName).getPhoneNumberOfFamilyMember(lastName, firstName);
	}

    	/**
     	* String representation of PhoneBook
     	*/
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i='A'; i<='Z'; i++) {
			s.append((char) i + "\n");
			s.append(getFamilyTree((char) i).toString());
		}
		return s.toString();
	}
	
//	public static void main(String[] args) {
//		PhoneBook pb = new PhoneBook();
//		//System.out.print(pb);
//		pb.addFamily("Trump");
//		pb.addPerson("Trump", "D", "123");
//		pb.addPerson("Ta", "B", "1234");
//		pb.addPerson("Sheng", "b", "2016314244");
//		pb.addPerson("Sheng", "a", "2016914645");
//		pb.addPerson("Sheng", "c", "2016914646");
//		pb.addPerson("Sa", "b", "2016914647");
//		pb.addPerson("Sz", "a", "2016914648");
//		pb.addPerson("Sc", "c", "2016914649");
//		pb.addPerson("K", "c", "2016914640");
//	
//		pb.getFamilyTree('a');
//		
//		System.out.println(pb.getFamilyTree('A'));	
//		System.out.println(pb.getPhoneNumber("Sz", "a"));
//		System.out.println(pb.getPhoneNumber("K", "c"));
//	}
}
