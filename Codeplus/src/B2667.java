import java.util.Arrays;
import java.util.Scanner;

public class B2667 {
	
	static int[] dx = {0, 0 ,-1, 1};
	static int[] dy = {-1, 1 ,0, 0};
	
	static void dfs(int i, int j, int[][] d, int[][] a, int cnt, int n) {
		d[i][j] = cnt;
		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if (nx < n && nx >= 0 && ny < n && ny >= 0) {
				if (a[nx][ny] == 1 && d[nx][ny] == 0) {
					dfs(nx, ny, d, a, cnt, n);					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[][] a = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();			
			for (int j = 0; j < n; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}
		
		int d[][] = new int[n][n];
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(d[i][j] == 0 && a[i][j] == 1) {
					dfs(i, j, d, a, cnt, n);
					cnt++;
				}
			}
		}
		cnt--;
		int[] ans = new int[cnt];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(d[i][j] != 0) {
					ans[d[i][j] - 1] += 1;
				}
			}
		}
		System.out.println(cnt);
		Arrays.sort(ans);
		for (int i = 0; i < cnt; i++) {
			System.out.println(ans[i]);			
		}
	}

}
