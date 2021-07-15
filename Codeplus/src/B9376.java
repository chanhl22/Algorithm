import java.util.*;

class Pair15 {
    int x;
    int y;

    public Pair15(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class B9376 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int[][] bfs(char[][] a, int x, int y) {
        int h = a.length;
        int w = a[0].length;
        Deque<Pair15> dq = new ArrayDeque<>();
        int[][] d = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                d[i][j] = -1;
            }
        }
        boolean[][] check = new boolean[h][w];
        dq.add(new Pair15(x, y));
        d[x][y] = 0;
        check[x][y] = true;
        while (!dq.isEmpty()) {
            Pair15 p = dq.poll();
            int px = p.x;
            int py = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = px + dx[k];
                int ny = py + dy[k];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (a[nx][ny] == '*') continue;
                if (check[nx][ny] == true) continue;
                if (a[nx][ny] == '.') {
                    dq.addFirst(new Pair15(nx, ny));
                    check[nx][ny] = true;
                    d[nx][ny] = d[px][py];
                }
                if (a[nx][ny] == '#') {
                    dq.addLast(new Pair15(nx, ny));
                    check[nx][ny] = true;
                    d[nx][ny] = d[px][py] + 1;
                }
            }
        }
        return d;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            sc.nextLine();
            char[][] a = new char[h + 2][w + 2];
            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    a[i][j] = '.';
                }
            }
            int[] criminal = new int[6];
            int x = 0;
            int y = 0;
            criminal[0] = 0;
            criminal[1] = 0;
            int cnt = 2;
            for (int i = 1; i < h + 1; i++) {
                String s = sc.nextLine();
                for (int j = 1; j < w + 1; j++) {
                    a[i][j] = s.charAt(j - 1);
                    if (a[i][j] == '$') {
                        criminal[cnt] = i;
                        criminal[cnt + 1] = j;
                        cnt += 2;
                        a[i][j] = '.';
                    }
                }
            }
            int[][] dist1 = bfs(a, criminal[0], criminal[1]);
            int[][] dist2 = bfs(a, criminal[2], criminal[3]);
            int[][] dist3 = bfs(a, criminal[4], criminal[5]);

            int ans = Integer.MAX_VALUE;
            for (int i = 1; i < h+1; i++) {
                for (int j = 1; j < w+1; j++) {
                    if (a[i][j] == '*') continue;
                    if(dist1[i][j] == -1 || dist2[i][j] == -1 || dist3[i][j] == -1) continue;
                    int temp = dist1[i][j] + dist2[i][j] + dist3[i][j];
                    if (a[i][j] == '#'){
                        temp -= 2;
                    }
                    if (ans > temp){
                        ans = temp;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
