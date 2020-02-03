/*
 * 
 * @author Zikang Sheng
 * I pledge my honor that I have abided by the Stevens Honor System.
 * 02/02/2020
 *
 */

public class BinaryNumber {
	private int[] data;
	private int length;
	
	public BinaryNumber(int length) {
		this.length = length;
		data = new int[length];
		for (int i = 0; i < length; i++) {
			data[i] = 0;
		}
	}
	
	public BinaryNumber(String str) {
		length = str.length();
		data = new int[length];
		for (int i = 0; i < length; i++) {
			data[i] = Character.getNumericValue(str.charAt(i));
		}
	}
	
	public int getLength() {
		return length;
	}
	
	public int getDigit(int index) {
		if (index < 0 || index > length) {
			throw new IndexOutOfBoundsException("Indedx is out of boundary!");
		}
		return data[index];
	}
	
	public int[] getInnerArray() {
		return data;
	}
	
	public static int[] bwor(BinaryNumber bn1, BinaryNumber bn2) {
		if (bn1.getLength() != bn2.getLength()) {
			throw new IllegalArgumentException();
		}
		int len = bn1.getLength();
		int[] temp = new int[len];
		for (int i = 0; i < len; i++) {
			temp[i] =  bn1.getDigit(i) | bn2.getDigit(i);
		}
		return temp;
	}
	
	public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
		int len = bn1.getLength();
		int[] temp = new int[len];
		for (int i = 0; i < len; i++) {
			temp[i] =  bn1.getDigit(i) & bn2.getDigit(i);
		}
		return temp;
	}
	
	public void bitShift(int direction, int amount) {
		if (amount > length && direction == 1 || amount < 0) {
			throw new IllegalArgumentException();
		}
		if (direction == -1) {
			length += amount;
			int[] temp = new int[length];
			for (int i = 0; i < length; i++) {
				if (i < data.length) {
					temp[i] = data[i];
				}
				else {
					temp[i] = 0;
				}
			}
			data = temp;
		}
		else if (direction == 1) {
			length -= amount;
			int[] temp = new int[length];
			for (int i = 0; i < length; i++) {
				temp[i] = data[i];
			}
			data = temp;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	private int[] prepend(int amount) {
		int[] newdata = new int[length + amount];
		for (int i = 0; i < newdata.length; i++) {
			if (i < amount) {
				newdata[i] = 0;
			}
			else {
				newdata[i] = data[i - amount];
			}
		}
		return newdata;
	}
	
	public void add(BinaryNumber aBinaryNumber) {
		int len1 = this.getLength();
		int len2 = aBinaryNumber.getLength();
		int newlen = Math.max(len1, len2) + 1;
		int[] bn1 = this.prepend(newlen - len1);
		int[] bn2 = aBinaryNumber.prepend(newlen - len2);
		int[] newbn = new int[newlen];
		
		int cd = 0;
		for (int i = newlen - 1; i >= 0; i--) {
			int sum = cd + bn1[i] + bn2[i];
			if (sum == 0 || sum == 1) {
				newbn[i] = sum;
				cd = 0;
			}
			else if(sum == 2 || sum == 3) {
				newbn[i] = sum - 2;
				cd = 1;
			}
		}
		
		data = newbn;
		length = newlen;
		
		if (newbn[0] == 0) {
			for (int i = 0; i < newlen -1; i++) {
				newbn[i] = newbn[i+1];
			}
			this.bitShift(1, 1);
		}
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < length; i++) {
			str.append(data[i]);
		}
		return str.toString();
	}
	
	public int toDecimal() {
		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum += data[length - 1 - i]*Math.pow(2, i);
		}
		return sum;
	}
}