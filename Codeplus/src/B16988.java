import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16988 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] a;
    static int n;
    static int m;

    static int bfs() {
        int ans = 0;
        boolean[][] check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != 2) continue;
                if (check[i][j] != false) continue;
                int cnt = 1;
                boolean ok = true;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                q.add(j);
                check[i][j] = true;
                while (!q.isEmpty()) {
                    int x = q.remove();
                    int y = q.remove();
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (a[nx][ny] == 2 && check[nx][ny] == false) {
                            cnt += 1;
                            check[nx][ny] = true;
                            q.add(nx);
                            q.add(ny);
                        } else if (a[nx][ny] == 0) {
                            ok = false;
                        }
                    }
                }
                if (ok) {
                    ans += cnt;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int x1 = 0; x1 < n; x1++) {
            for (int y1 = 0; y1 < m; y1++) {
                if (a[x1][y1] != 0) continue;
                a[x1][y1] = 1;
                for (int x2 = 0; x2 < n; x2++) {
                    for (int y2 = 0; y2 < m; y2++) {
                        //if(x1 == x2 && y1 == y2) continue;
                        if (a[x2][y2] != 0) continue;
                        a[x2][y2] = 1;
                        int temp = bfs();
                        if (ans < temp) {
                            ans = temp;
                        }
                        a[x2][y2] = 0;
                    }
                }
                a[x1][y1] = 0;
            }
        }
        System.out.println(ans);
    }
}
