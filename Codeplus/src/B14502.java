import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14502 {
    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int go(int[][] a, int count) {
        int ans = 0;
        if (count == 3) {
            int[][] b = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    b[i][j] = a[i][j];
                }
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (b[i][j] == 2) {
                        q.add(i);
                        q.add(j);
                    }
                }
            }
            while (!q.isEmpty()) {
                int nx = q.remove();
                int ny = q.remove();
                for (int i = 0; i < 4; i++) {
                    int nnx = nx + dx[i];
                    int nny = ny + dy[i];
                    if (nnx >= 0 && nnx < n && nny >= 0 && nny < m) {
                        if (b[nnx][nny] == 0) {
                            b[nnx][nny] = 2;
                            q.add(nnx);
                            q.add(nny);
                        }
                    }
                }
            }
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (b[i][j] == 0) {
                        c += 1;
                    }
                }
            }
            return c;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    a[i][j] = 1;
                    int temp = go(a, count + 1);
                    if (temp > ans) {
                        ans = temp;
                    }
                    a[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        ans = go(a, 0);
        System.out.println(ans);
    }
}
