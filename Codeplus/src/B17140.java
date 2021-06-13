import java.util.*;

public class B17140 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int k = sc.nextInt();
		int[][] a = new int[100][100];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		int ans = 0;
		if (a[r][c] == k) {
			System.out.println(ans);
			System.exit(0);
		}
		
		int m = 3; 
		int n = 3;
		for (int t = 0; t < 100; t++) {
			if (n >= m) {
				int mm = m;
				for (int i = 0; i < n; i++) {
					HashMap<Integer, Integer> d = new HashMap<>();
					for (int j = 0; j < m; j++) {
						if (a[i][j] == 0) continue;
						int val = 0;
						if (d.containsKey(a[i][j])) {
							val = d.get(a[i][j]);
						}
						val += 1;
						d.put(a[i][j], val);
					}
				}
				m = mm;
			}
		}
		
	}

}