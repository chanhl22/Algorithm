import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16920 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[] s = new int[p+1];
        for (int i = 1; i <= p; i++) {
            s[i] = sc.nextInt();
        }
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == '.') {
                    a[i][j] = 0;
                } else if (line.charAt(j) == '#') {
                    a[i][j] = -1;
                } else {
                    a[i][j] = line.charAt(j) - '0';
                }
            }
        }
        //bfs 준비
        Queue<Integer>[] q = new LinkedList[p + 1];
        Queue<Integer>[] next_q = new LinkedList[p + 1];
        for (int i = 1; i < p + 1; i++) {
            q[i] = new LinkedList<>();
            next_q[i] = new LinkedList<>();
        }
        //시작점 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] > 0) {
                    q[a[i][j]].add(i);
                    q[a[i][j]].add(j);
                }
            }
        }
        //bfs
        while (true) { //전체 사이클
            boolean ok = false;
            for (int who = 1; who <= p; who++) { //플레이어 1 ~ p
                int[][] d = new int[n][m];
                while (!q[who].isEmpty()) {
                    ok = true;
                    int x = q[who].remove();
                    int y = q[who].remove();
                    if (d[x][y] == s[who]) {
                        next_q[who].add(x);
                        next_q[who].add(y);
                        continue;
                    }
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            if (a[nx][ny] == 0) {
                                d[nx][ny] = d[x][y] + 1;
                                if (d[nx][ny] <= s[who]) {
                                    a[nx][ny] = who;
                                    q[who].add(nx);
                                    q[who].add(ny);
                                }
                            }
                        }
                    }
                }
                q[who] = next_q[who];
                next_q[who] = new LinkedList<>();
            }
            if (!ok) {
                break;
            }
        }
        int[] ans = new int[p + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] > 0) {
                    ans[a[i][j]] += 1;
                }
            }
        }
        for (int i = 1; i <= p; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
