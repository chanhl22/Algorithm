import java.util.*;

public class B11724 {
	static boolean[] check;
	static ArrayList<Integer>[] a; 
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		check[start] = true;
		while(!q.isEmpty()) {
			int x = q.remove();
			for (int y : a[x]) {
				if(check[y] == false) {
					check[y] = true;
					q.add(y);					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		a = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		check = new boolean[n+1];
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if(check[i] == false) {
				bfs(i);
				ans += 1;
			}
		}
		System.out.println(ans);
	}

}
