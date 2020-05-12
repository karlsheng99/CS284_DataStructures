public class ListMatrix extends ListCollection<Integer> {
  private int rows;
  private int columns;

  /**
   * Initializes a `ListMatrix` with the specified number of rows and columns. By
   * default, ALL elements are set to 0.
   * 
   * @param rows
   * @param columns
   */
  public ListMatrix(int rows, int columns) {
	  super(rows);
	  this.rows = rows;
	  this.columns = columns;
	  for (int i=0; i<rows; i++) {
		  for (int j=0; j<columns; j++) {
			  this.addElem(i, j, 0);
		  }
	  }
  }

  /**
   * @return the number of rows
   */
  public int numRows() {
	  return this.rows;
  }

  /**
   * 
   * @return the number of columns
   */
  public int numColumns() {
	  return this.columns;
  }

  /**
   * Adds the `ListMatrix` to `ListMatrix other`, storing the result in the caller
   * (this)
   * 
   * @throws IllegalArgumentException if dimensions do not peoperly coincide
   * @param other
   * @complexity O(m*n^2) time complexity. The method modifies every element using "get" method and "set" method with total O(2*n)=O(n) linear time complexity.
   * Element modification happens once when the number of column=1 in the matrix, twice when the number of column=2, ..., n times when column=n. (n/2+(n^2)/2 in total)
   * So the inner loop of this method has O(n^2) time complexity, n depends on the number of columns in the matrix.
   * However, the number of rows is independent to the number of columns. 
   * We cannot assume that it is a square matrix, since the number of rows strongly affects the time complexity.
   * The outer loop runs m times which depends on the number of rows in the matrix.
   * So the time complexity for this method is O(m*n^2).
   */
  public void add(ListMatrix other) {
	  if (rows!=other.rows || columns!=other.columns) {
		  throw new IllegalArgumentException("Addition is not permissible. The number of rows and columns of the two matrices are not the same!");
	  }
	  for (int i=0; i<rows; i++) {
		  for (int j=0; j<columns; j++) {
			  this.setElem(i, j, this.getElem(i, j)+other.getElem(i, j));
		  }
	  }
		  
  }

  /**
   * Returns the transpose of the matrix
   * 
   * @param matrix
   * @return matrix transpose
   */
  public static ListMatrix transpose(ListMatrix matrix) {
	  ListMatrix lm = new ListMatrix(matrix.numColumns(), matrix.numRows());
	  for (int i=0; i<lm.rows; i++) {
		  for (int j=0; j<lm.columns; j++) {
			  lm.setElem(i, j, matrix.getElem(j, i));
		  }
	  }
	  return lm;
  }

  /**
   * Multiplies the `ListMatrix` with `ListMatrix other`, returning the result as
   * a new `ListMatrix.
   * 
   * @throws IllegalArgumentException if dimensions do not peoperly coincide
   * @param other
   * @return
   */
  public ListMatrix multiply(ListMatrix other) {
	  if (columns!=other.rows) {
		  throw new IllegalArgumentException("Multiplication is not permissible. The number of columns in the recipient matrix does not coincide with the number of rows in other.");
	  }
	  
	  ListMatrix lm = new ListMatrix(rows, other.columns);
	  for (int lmr=0; lmr<lm.rows; lmr++) {
		  for (int lmc=0; lmc<lm.columns; lmc++) {
			  int sum=0;
			  for (int i=0; i<columns; i++) {
				  sum += this.getElem(lmr, i)*other.getElem(i, lmc);
			  }
			  lm.setElem(lmr, lmc, sum);
		  }
	  }
	  return lm;
  }
}
