import java.util.*;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		char[] a = new char[10];
//		for (int i = 0; i < n; i++) {
//			a[i] = sc.next().toCharArray()[0];
//		}
//		for (int i = 0; i < a.length; i++) {
//			System.out.println(a[i]);
//		}
//		String str = sc.next();
		char[] a = new char[2];
//		a = str.toCharArray();
		for (int i = 0; i < 2; i++) {
			a[i] = sc.next().toCharArray()[0];			
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
	}
}
