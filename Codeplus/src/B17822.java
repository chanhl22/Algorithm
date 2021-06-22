import java.util.*;

public class B17822 {
	static void go(int [][] a, int x, int d, int k) {
		List<int[]> test = new ArrayList<>();
		if (d == 0) {
			test.addAll(Arrays.asList(a[x]));
		} else {
			test.addAll(Arrays.asList(a[x]));
		}
		System.out.println(test);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		int	[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		while (t-- > 0) {
			int x = sc.nextInt();
			int d = sc.nextInt();
			int k = sc.nextInt();
			for (int i = x; i < n; i += x) {
				go(a, i, d, k);
			}
		}

	}

}