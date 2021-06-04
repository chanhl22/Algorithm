import java.util.*;

public class B2580 {
	static int x = 0;
	static int y = 0;
	
	static void go(int z) {
		if (z == 81) {
			return ;
		}
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				go(9 * x + y);				
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] a = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		go (0);
		
	}

}
