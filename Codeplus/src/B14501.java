import java.util.*;

public class B14501 {
	static int n;
	static int[] t;
	static int[] p;
	static int ans = 0;
	
	static void go(int day, int sum) {
		if(day == n + 1) {
			if (ans < sum) {
				ans = sum;
			}
			return ;
		}
		if(day > n + 1) {
			return ;
		}
		go(day+t[day-1],sum+p[day-1]);
		go(day+1, sum);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = new int[n];
		p = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();		
		}
		
		go (1, 0);
		System.out.println(ans);
	}
}