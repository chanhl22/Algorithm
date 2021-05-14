import java.util.*;

class Pair4{
	int x;
	int y;
	Pair4(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class B1261 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}
		boolean[][] check = new boolean[n][m];
		int[][] dist = new int[n][m];
		check[0][0] = true;
		dist[0][0] = 0;
		Deque<Pair4> q = new ArrayDeque<>();
		q.add(new Pair4(0,0));
		while(!q.isEmpty()) {
			Pair4 p = q.remove();
			int px = p.x;
			int py = p.y;
			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (check[nx][ny] == false && a[nx][ny] == 0) {
						dist[nx][ny] = dist[px][py];
						check[nx][ny] = true;
						q.addFirst(new Pair4(nx,ny));
					}
					if (check[nx][ny] == false && a[nx][ny] == 1) {
						dist[nx][ny] = dist[px][py] + 1;
						check[nx][ny] = true;
						q.addLast(new Pair4(nx,ny));
					}
				}
			}
		}
		System.out.println(dist[n-1][m-1]);
	}
}
