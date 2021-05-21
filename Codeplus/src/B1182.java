//import java.util.*;
//
//public class B1182 {
//	static int n;
//	static int s;
//	static int ans = 0;
//	static int[] a;
//	static boolean[] c;
//	
//	static int go (int index, int sum) {
//		if (index == a.length) {
//			if (sum == s) {
//				return 1;
//			} else {
//				return 0;
//			}
//		}
//		return go(index + 1, sum + a[index]) + go(index + 1, sum);
//	}
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		s = sc.nextInt();
//		a = new int[n];
//		for (int i = 0; i < n; i++) {
//			a[i] = sc.nextInt();
//		}
//		c = new boolean[n];
//		if (s == 0) {
//			System.out.println(go (0,0) - 1);
//		} else {
//			System.out.println(go (0,0));
//		}
//	}
//
//}

import java.util.*;

public class B1182 {
	static int n;
	static int s;
	static int ans = 0;
	static int[] a;
	static boolean[] c;
	
	static void go (int index, int sum) {
		if (index == a.length) {
			if (sum == s) {
				ans += 1;
				return ;
			} else {
				return ;
			}
		}
		go(index + 1, sum + a[index]);
		go(index + 1, sum);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		c = new boolean[n];
		go (0,0);
		if (s == 0) {
			ans -= 1;
		}
		System.out.println(ans);
	}
}
