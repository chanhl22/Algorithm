import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B15558 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[2][n];
        for (int i = 0; i < 2; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                a[i][j] = line.charAt(j) - '0';
            }
        }
        int[][] dir = {{0,1}, {0,-1}, {1,k}};
        Queue<Integer> q = new LinkedList<>();
        int[][] dist = new int[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], -1);
        }
        q.add(0);
        q.add(0);
        dist[0][0] = 0;
        boolean ok = false;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int i = 0; i < 3; i++) {
                int nx = (x + dir[i][0]) % 2;
                int ny = y + dir[i][1];
                if (ny >= n) {
                    ok = true;
                    break;
                }
                if (ny < 0) continue;
                if (a[nx][ny] == 0) continue;
                if (dist[nx][ny] != -1) continue;
                if (ny < dist[x][y] + 1) continue;
                dist[nx][ny] = dist[x][y] + 1;
                q.add(nx);
                q.add(ny);
            }
        }
        if (ok) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
