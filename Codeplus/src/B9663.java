import java.util.*;

public class B9663 {
	static int n;
	static int ans = 0;
	static boolean[] check_col;
	static boolean[] check_dig1;
	static boolean[] check_dig2;
	
	static boolean check(int row, int col) {
		if (check_col[col]) {
			return false;
		}
		if (check_dig1[row + col]) {
			return false;
		}
		if (check_dig2[n + row - col]) {
			return false;
		}
		return true;
	}
	
	static void go(int row) {
		if(row == n) {
			ans += 1;
		}
		for (int col = 0; col < n; col++) {
			// if check returns false, no more numbers can be placed
			if (check(row, col)) {
				check_col[col] = true; //column check
				check_dig1[row + col] = true; // / check
				check_dig2[n+ row - col] = true; // \ check
				go(row + 1);
				check_col[col] = false;
				check_dig1[row + col] = false;
				check_dig2[n+ row - col] = false;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		check_col = new boolean[n];
		check_dig1 = new boolean[2 * n + 1];
		check_dig2 = new boolean[2 * n + 1];
		
		go(0);

		System.out.println(ans);
	}

}
