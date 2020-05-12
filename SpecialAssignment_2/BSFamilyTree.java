/*
 * 
 * @author Zikang Sheng
 * I pledge my honor that I have abided by the Stevens Honor System.
 * 05/11/2020
 *
 */

package SpecialAssignment_2;
import java.util.ArrayList;

/**
 * BSFamilyTree creates a tree for specific families. 
 */
public class BSFamilyTree {
    //Data Fields
    private FamilyTreeNode root;

    /**
     * Constructor: constructs an empty BSFamilyTree
     */
    public BSFamilyTree() {
        root = null;
    }

    /**
     * takes in the last name and returns true if there
     * is a FamilyTreeNode with the given last name.
     */
    public boolean doesFamilyExist(String lastName) {
        return doesFamilyExist_helper(lastName, root);
    }
    
    private boolean doesFamilyExist_helper(String lastName, FamilyTreeNode current) {
    	if (current==null) {
    		return false;
    	}
    	else {
    		int c = current.getLastName().compareTo(lastName);
    		if (c==0) {
    			return true;
    		}
    		else if (c>0) {
    			return doesFamilyExist_helper(lastName, current.left);
    		}
    		else {
    			return doesFamilyExist_helper(lastName, current.right);
    		}
    	}
    }
    
    /**
     * Takes in a last name and creates a new instance of
     * FamilyTreeNode and adds it to the BSFamilyTree.
     */
    public void addFamilyTreeNode(String lastName) {
    	if (lastName=="") {
    		throw new IllegalArgumentException("Invalid last name!");
    	}
    	if (root!=null && lastName.charAt(0)!=root.getLastName().charAt(0)) {
    		throw new IllegalArgumentException("It does not belong to this family tree!");
    	}
        root = addFamilyTreeNode_helper(lastName, root);
    }
    
    private FamilyTreeNode addFamilyTreeNode_helper(String lastName, FamilyTreeNode current) {
    	if (current==null) {
    		return new FamilyTreeNode(lastName);
    	}
    	else {
    		int c = current.getLastName().compareTo(lastName);
			if (c==0) {
				throw new IllegalArgumentException("This last name is already in the tree!");
			}
			else if (c>0) {
				current.left = addFamilyTreeNode_helper(lastName, current.left);
				return current;
			}
			else {
				current.right = addFamilyTreeNode_helper(lastName, current.right);
				return current;
			}
    	}
    }

    /**
     * Takes a last name and then finds that specific
     * family tree and then returns that FamilyTreeNode
     * If last name is not in tree, throws an exception.
     */
    public FamilyTreeNode getFamilyTreeNode(String lastName) {
        return getFamilyTreeNode_helper(lastName, root);
    }
    
    private FamilyTreeNode getFamilyTreeNode_helper(String lastName, FamilyTreeNode current) {
    	if (current==null) {
    		throw new IllegalArgumentException("This last name is not in the tree!");
    	}
    	else {
    		int c = current.getLastName().compareTo(lastName);
    		if (c==0) {
    			return current;
    		}
    		else if (c>0) {
    			return getFamilyTreeNode_helper(lastName, current.left);
    		}
    		else {
    			return getFamilyTreeNode_helper(lastName, current.right);
    		}
    	}
    }

    /**
     * Returns true if the input phone number exists in the BSFamilyTree
     * false otherwise.
     */
    public boolean doesNumberExist(String phoneNumber) {
        return doesNumberExist_helper(phoneNumber, root);
    }
    
    private boolean doesNumberExist_helper(String phoneNumber, FamilyTreeNode current) {
    	if (current==null) {
    		return false;
    	}
    	else {
    		return current.doesNumberExist(phoneNumber) || 
    				doesNumberExist_helper(phoneNumber, current.left) || doesNumberExist_helper(phoneNumber, current.right);
    	}
    }

    /**
     * Returns the string representation of the BSFamilyTree
     */
    public String toString() {
        return toString_helper(0, root);
    }
    
    public String toString_helper(int i, FamilyTreeNode current) {
    	StringBuilder s = new StringBuilder();
    	for (int j=0; j<i; j++) {
    		s.append("  ");
    	}
    	
    	if (current==null) {
    		s.append("null\n");
    	}
    	else {
    		s.append(current.toString() + "\n");
    		s.append(toString_helper(i+1, current.left));
    		s.append(toString_helper(i+1 ,current.right));
    	}
    	return s.toString();
    }
    
//    public static void main(String[] args) {
//		
//    	BSFamilyTree tree1 = new BSFamilyTree();
//    	tree1.addFamilyTreeNode("Trump");
//    	FamilyTreeNode node1 = tree1.getFamilyTreeNode("Trump");
//    	node1.addFamilyMember("Trump", "D", "123");
//    	
//    	tree1.addFamilyTreeNode("Tqq");
//    	FamilyTreeNode node2 = tree1.getFamilyTreeNode("Tqq");
//    	node2.addFamilyMember("Tqq", "C", "1234");
//    	tree1.addFamilyTreeNode("");
//    	tree1.addFamilyTreeNode("Sa");
//    	FamilyTreeNode node3 = tree1.getFamilyTreeNode("Sa");
//    	node2.addFamilyMember("Sa", "a", "123");
//		System.out.print(tree1);
//		
//		System.out.print(tree1.doesNumberExist(""));
//	}
}
