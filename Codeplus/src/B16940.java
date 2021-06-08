import java.util.*;
public class B16940 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] a = new ArrayList[n];
        int[] parent = new int[n];
        int[] order = new int[n];
        boolean[] check = new boolean[n];
        for (int i=0; i<n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i=0; i<n-1; i++) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            a[u].add(v);
            a[v].add(u);
        }
        for (int i=0; i<n; i++) {
            order[i] = sc.nextInt()-1;
        }
    }
}