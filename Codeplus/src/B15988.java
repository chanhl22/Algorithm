import java.util.*;

public class B15988 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] d = new long [1000001];
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		for (int j = 3; j <= 1000000 ; j++) {
				d[j] = d[j-1] + d[j-2] + d[j-3];
				d[j] %= 1000000009;
		}
		
		for (int i = 1; i <= n; i++) {
			int a = sc.nextInt();
			System.out.println(d[a] % 1000000009);
		}
	}
}
