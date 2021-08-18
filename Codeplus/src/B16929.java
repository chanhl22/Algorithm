import java.util.*;

public class B16929 {
	static boolean[][] check;
	static char[][] a;
	static int n;
	static int m;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static boolean dfs(int x, int y, int px, int py, char color) {
		if (check[x][y]) {
			return true;
		}
		check[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				// 다음의 값이 이전의 값과 달라야함
				if (!(nx == px && ny == py) && a[nx][ny] == color) {
					if (dfs(nx, ny, x, y, color)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new char[n][m];
		for (int i = 0; i < n; i++) {
			a[i] = sc.next().toCharArray();
		}
		check = new boolean[n][m];
		boolean ans = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 이미 동일한 color의 check배열을 true로 바꿨음
				// 만약 동일한 color를 또 찾는다면 무조건 true를 반환함
				// 그러니 동일한 color를 찾는다면 dfs를 하지 않고 넘어가게 해야함
				if (check[i][j])
					continue;
				ans = dfs(i, j, -1, -1, a[i][j]);
				/*
				AAAAA
				ACDDA
				AADDA
				ABAAA 와 같은 예시
				true에서 무조건 출력을 해야한다. 만약 출력하지 않으면 ans가 false로 다시 바뀜
				 */
				if (ans) {
					System.out.println("Yes");
					System.exit(0);
				}
			}
		}
		System.out.println("No");
	}

}

//import java.util.*;
//public class Main {
//    static char[][] a;
//    static boolean[][] check;
//    static int[][] dist;
//    static int n, m;
//    final static int[] dx = {0,0,1,-1};
//    final static int[] dy = {1,-1,0,0};
//    static boolean go(int x, int y, int cnt, char color) {
//        if (check[x][y]) {
//            if (cnt-dist[x][y] >= 4) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//        check[x][y] = true;
//        dist[x][y] = cnt;
//        for (int k=0; k<4; k++) {
//            int nx = x+dx[k];
//            int ny = y+dy[k];
//            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
//                if (a[nx][ny] == color) {
//                    if (go(nx, ny, cnt+1, color)) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        a = new char[n][m];
//        check = new boolean[n][m];
//        for (int i=0; i<n; i++) {
//            a[i] = sc.next().toCharArray();
//        }
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                if (check[i][j]) continue;
//                dist = new int[n][m];
//                boolean ok = go(i, j, 1, a[i][j]);
//                if (ok) {
//                    System.out.println("Yes");
//                    System.exit(0);
//                }
//            }
//        }
//        System.out.println("No");
//    }
//}
