import java.util.Scanner;

public class B15652 {
	static int[] a = new int[9];
	
	static void go(int index, int start, int n, int m) {
		if (index == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
			return ;
		}
		for (int i = start; i <= n; i++) {
			a[index] = i; 
			go(index+1, i, n, m);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		go(0, 1, n, m);
	}

}
