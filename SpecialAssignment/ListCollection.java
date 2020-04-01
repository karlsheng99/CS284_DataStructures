import java.util.ArrayList;
import java.util.List;

public class ListCollection<E> {
  private int nodeCount;
  protected List<SingleLL<E>> collection;

  /**
   * Base constructor, initializes an empty ListCollection.
   */
  public ListCollection() {
	  nodeCount = 0;
	  collection = new ArrayList<SingleLL<E>>();
  }

  /**
   * Initializes a ListCollection with `numLists` lists.
   * 
   * @param numLists
   */
  public ListCollection(int numLists) {
	  nodeCount = 0;
	  collection = new ArrayList<SingleLL<E>>();
	  for (int i=0; i<numLists; i++) {
		  collection.add(new SingleLL<E>());
	  }
  }

  /**
   * @return The size of the `ListCollection`
   */
  public int size() {
	  return collection.size();
  }

  /**
   * Sets the nodeCount
   * 
   * @param nodeCount
   */
  public void setNodeCount(int nodeCount) {
	  this.nodeCount = nodeCount;
  }

  /**
   * @return the nodeCount
   */
  public int getNodeCount() {
	  return nodeCount;
  }

  /**
   * Adds the specified `SingleLL` to the end of the `ListCollection`
   * 
   * @param list
   */
  public void addList(SingleLL<E> list) {
	  collection.add(list);
	  nodeCount += list.size();
  }

  /**
   * Adds the specified `List` to the `ListCollection`
   * 
   * @param list
   * @complexity O(n^2) quadratic complexity. The method goes through the outer loop with n times, 
   * and then appends each element to the end of SingleLL using "add" method which goes through the inner loop once when n=1, twice when n=2, ..., n times when n=n.
   * So the total complexity is 1+2+3+...+n = (1+n)*n/2 , which time complexity is equal to O(n^2).
   */
  public void addList(List<E> list) {
	  SingleLL<E> sl = new SingleLL<E>();
	  for (E var: list) {
		  sl.append(var);
	  }
	  collection.add(sl);
	  nodeCount += sl.size();
  }

  /**
   * Returns the list at the specified index
   * 
   * @throws IllegalArgumentException when index out of bounds
   * @param listIndex
   * @return the list
   */
  public SingleLL<E> getList(int listIndex) {
	  if (listIndex<0 || listIndex>=collection.size()) {
		  throw new IllegalArgumentException("Index out of bond!");
	  }
	  return collection.get(listIndex);
  }

  /**
   * Adds an element to the `elemIndex` position of the list at `listIndex`
   * 
   * @throws IllegalArgumentException when index out of bounds
   * @param listIndex
   * @param elemIndex
   * @param elem
   * @complexity O(n) linear complexity. The method can find any SingleLL in the collection(ArrayList) with a constant time complexity,
   * and then the element is inserted into the position of a specific SingleLL using "insert" method which has O(n) complexity.
   * So the total time complexity is O(n).
   */
  public void addElem(int listIndex, int elemIndex, E elem) {
	  if (listIndex<0 || listIndex>=collection.size() || elemIndex<0 || elemIndex>collection.get(listIndex).size()) {
		  throw new IllegalArgumentException("Index out of bond!");
	  }
	  collection.get(listIndex).insert(elemIndex, elem);
	  nodeCount++;
  }

  /**
   * Sets the element at the `elemIndex` position of the list at `listIndex`
   * 
   * @throws IllegalArgumentException when index out of bounds
   * @param listIndex
   * @param elemIndex
   * @param elem
   */
  public void setElem(int listIndex, int elemIndex, E elem) {
	  if (listIndex<0 || listIndex>=collection.size() || elemIndex<0 || elemIndex>=collection.get(listIndex).size()) {
		  throw new IllegalArgumentException("Index out of bond!");
	  }
	  collection.get(listIndex).set(elemIndex, elem);
  }

  /**
   * Returns the element at the `elemIndex` position of the list at `listIndex`
   * 
   * @throws IllegalArgumentException when index out of bounds
   * @param listIndex
   * @param elemIndex
   * @return
   */
  public E getElem(int listIndex, int elemIndex) {
	  if (listIndex<0 || listIndex>=collection.size() || elemIndex<0 || elemIndex>=collection.get(listIndex).size()) {
		  throw new IllegalArgumentException("Index out of bond!");
	  }
	  return collection.get(listIndex).get(elemIndex);
  }

  /**
   * Returns the `ListCollection` in string form, following STRICTLY the rule of
   * "[LIST1, LIST2, LIST3, ... ]" Ex: [[0, 1, 2], [3, 4, 5] [6, 7, 8]]
   */
  public String toString() {
	  StringBuilder sb = new StringBuilder();
	  sb.append("[");
	  for (int i=0; i<collection.size(); i++) {
		  sb.append(collection.get(i).toString() + (i<collection.size()-1 ? ", " : ""));
      }
      sb.append("]");
      return sb.toString();  
  }
}
