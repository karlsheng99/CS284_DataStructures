/*
 * 
 * @author Zikang Sheng
 * I pledge my honor that I have abided by the Stevens Honor System.
 * 02/18/2020
 *
 */

public class Complexity {
	
	public static void method1(int n) {
		int count = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n ;j++) {
				System.out.println("Operation " + count);
				count++;
			}
		}
	}
	
	public static void method2(int n) {
		int count = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				for (int k=0; k<n; k++) {
					System.out.println("Operation " + count);
					count++;
				}
			}
		}
	}
	
	public static void method3(int n) {
		int count = 0;
		for (int i=1; i<n; i*=2) {
			System.out.println("Operation " + count);
			count++;
		}
	}
	
	public static void method4(int n) {
		int count = 0;
		for (int i=0; i<n; i++) {
			for (int j=1; j<n; j*=2) {
				System.out.println("Operation " + count);
				count++;
			}
		}
	}
	
	public static void method5(int n) {
		int count = 0;
		for (int i=2; i<n; i=(int)Math.pow(i, 2)) {
			System.out.println("Operation " + count);
			 count++;
		}
	}
	
	static int counter = 0;
	public static void method6(int n) {
		 if (n<=0) {
			 System.out.println("Operation " + counter);
			 counter++;
		 }
		 else {
			 method6(n-1);
			 method6(n-1);
		 }
	}
}
