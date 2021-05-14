import java.util.*;

public class B13549 {
	public static final int MAX = 200000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] d = new int[MAX];
		boolean[] check = new boolean[MAX];
		check[n] = true;
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> next_q = new LinkedList<>();
		q.add(n);
		while(!q.isEmpty()) {
			int p = q.remove();
			if (p*2 < MAX && check[p*2] == false) {
				d[p*2] = d[p];
				check[p*2] = true;
				q.add(p*2);
			}
			if (p+1 < MAX && check[p+1] == false) {
				d[p+1] = d[p] + 1;
				check[p+1] = true;
				next_q.add(p+1);
			}
			if (p-1 >= 0 && check[p-1] == false) {
				d[p-1] = d[p] + 1;
				check[p-1] = true;
				next_q.add(p-1);
			}
			if (q.isEmpty()) {
                q = next_q;
                next_q = new LinkedList<Integer>();
            }
		}
		System.out.println(d[k]);
	}
}
