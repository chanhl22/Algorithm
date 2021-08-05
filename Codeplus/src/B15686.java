import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Pair20 {
    int x;
    int y;

    public Pair20(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class B15686 {
    static int n;
    static int m;
    static int[][] a;
    static ArrayList<Pair20> people;
    static ArrayList<Pair20> store;
    static Stack<Pair20> select;
    static int ans = Integer.MAX_VALUE;

    static void cals() {
        int sum = 0;
        for (Pair20 p : people) {
            int min = Integer.MAX_VALUE;
            for (Pair20 s : select) {
                int dist = Math.abs(p.x - s.x) + Math.abs(p.y - s.y);
                min = Math.min(min, dist);
            }
            sum += min;
        }
        ans = Math.min(ans, sum);
    }

    static void go(int index, int pick) {
        if (pick == m) {
            cals();
            return;
        }
        if (index >= store.size()) {
            return;
        }
        select.push(store.get(index));
        go(index + 1, pick + 1);
        select.pop();
        go(index + 1, pick);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];
        people = new ArrayList<>();
        store = new ArrayList<>();
        select = new Stack<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 1) {
                    people.add(new Pair20(i, j));
                }
                if (a[i][j] == 2) {
                    store.add(new Pair20(i, j));
                }
            }
        }
        go(0, 0);
        System.out.println(ans);
    }
}
