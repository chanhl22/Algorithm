//import java.util.*;
//
//public class B9095 {
//	static int is_count(int sum, int input) {
//		if (sum > input)
//			return 0;
//		if (sum == input)
//			return 1;
//		int count = 0;
//		for (int i = 1; i <= 3; i++) {
//			count += is_count(sum+i, input);
//		}
//		return count;
//			
//	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int ans = 0;
//		for (int i = 0; i < n; i++) {
//			int input = sc.nextInt();
//			ans = is_count(0, input);
//			System.out.println(ans);
//		}
//	}
//}

import java.util.*;

public class B9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] d = new int [11];
		int s = sc.nextInt();
		
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		
		for (int i = 0; i < s; i++) {
			int n = sc.nextInt();
			for (int j = 3; j <= n; j++) {
				d[j] = d[j-1] + d[j-2] + d[j-3];
			}
			
			System.out.println(d[n]);
			
		}
	}
}

