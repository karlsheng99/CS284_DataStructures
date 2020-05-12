/*
 * 
 * @author Zikang Sheng
 * I pledge my honor that I have abided by the Stevens Honor System.
 * 05/11/2020
 *
 */

package SpecialAssignment_2;
import java.util.ArrayList;
import java.util.List;

public class FamilyTreeNode {
	// Data fields
	private String lastName;
	private List<Person> members;
	public FamilyTreeNode left;
	public FamilyTreeNode right;

	/**
     	* Constructor: instantializes a new FamilyTreeNode
     	* given a lastName
     	*/
	public FamilyTreeNode(String lastName) {
        	this.lastName = lastName;
        	members = new ArrayList<Person>();
        	left = null;
        	right = null;
	}

	/**
     	* Returns the last name of the FamilyTreeNode
     	*/
	public String getLastName() {
		return lastName;
	}

	/**
     	* Returns the arraylist of members in the FamilyTreeNode
     	*/
	public List<Person> getMembers() {
		return members;
	}

	/*
	 * Returns true if there is an instance of Person in the FamilyTreeNode that has
	 * the same first and last name provided Return false otherwise
	 */
	public boolean doesFamilyMemberExist(String lastName, String firstName) {
        	for (int i=0; i<members.size(); i++) {
        		if (members.get(i).getFirstName().equals(firstName) && members.get(i).getLastName().equals(lastName)) {
        			return true;
        		}
        	}
        	return false;
	}

	/**
	 * Returns true if there is an instance of Person in the FamilyTreeNode whose
	 * phone number matches the one provided Returns false otherwise
	 */
	public boolean doesNumberExist(String phoneNumber) {
        	for (int i=0; i<members.size(); i++) {
        		if (members.get(i).getPhoneNumber().equals(phoneNumber)) {
        			return true;
        		}
        	}
        	return false;
	}

	/*
	 * Adds a Person to this FamilyTreeNode
	 * Throw an exception if the last name provided does not match the last name of the FamilyTreeNode
	 */
	public void addFamilyMember(String lastName, String firstName, String phoneNumber) {
		Person p = new Person(lastName, firstName, phoneNumber);
		this.addFamilyMember(p);
	}

	/**
	 * Adds a Person to this FamilyTreeNode
	 * Throw an exception if the last name provided does not match the last name of the FamilyTreeNode
	 */
	public void addFamilyMember(Person person) {
		if (!this.lastName.equals(person.getLastName())) {
			throw new IllegalArgumentException("Last name does not match the family tree!");
		}
		if (doesFamilyMemberExist(person.getLastName(), person.getFirstName())) {
			throw new IllegalArgumentException("This family member already exists!");
		}
		if (doesNumberExist(person.getPhoneNumber())) {
			throw new IllegalArgumentException("This phone number already exists!");
		}
		members.add(person);
	}

	/*
	 * Returns the phone number of the person in the family with the given phone
	 * number Returns "Does not exist." if not found
	 */
	public String getPhoneNumberOfFamilyMember(String lastName, String firstName) {
		for (int i=0; i<members.size(); i++) {
    		if (members.get(i).getFirstName().equals(firstName) && members.get(i).getLastName().equals(lastName)) {
    			return members.get(i).getPhoneNumber();
    		}
    	}
    	return "Does not exist.";
	}

	/*
	 * toString method Ex: [] [John Smith (5551234567), May Smith (5551234568),
	 * April Smith (5551234569), August Smith (5551234570)]
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		for (int i=0; i<members.size(); i++) {
			s.append(members.get(i).toString() + (i<members.size()-1 ? ", " : ""));
		}
		s.append("]");
		return s.toString();
	}
	
//	public static void main(String[] args) {
//		FamilyTreeNode t = new FamilyTreeNode("Trump");
//		Person p = new Person("Trump", "q","123456");
//		t.addFamilyMember("Trump", "D", "123");
//		t.addFamilyMember("Trump", "A", "1234");
//		t.addFamilyMember("Trump", "B", "1235");
//		t.addFamilyMember(p);
//		System.out.println(t.doesFamilyMemberExist("Trum", "C"));
//		System.out.println(t.doesNumberExist("123123"));
//		System.out.println(t);
//	}
}
