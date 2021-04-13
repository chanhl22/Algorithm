import java.util.*;

public class B14500 {
	static int[][][] block = {
		 {{0,1}, {0,2}, {0,3}},
		 {{1,0}, {2,0}, {3,0}},
		 {{1,0}, {1,1}, {1,2}},
		 {{0,1}, {1,0}, {2,0}},
		 {{0,1}, {0,2}, {1,2}},
		 {{1,0}, {2,0}, {2,-1}},
		 {{0,1}, {0,2}, {-1,2}},
		 {{1,0}, {2,0}, {2,1}},
		 {{0,1}, {0,2}, {1,0}},
		 {{0,1}, {1,1}, {2,1}},
		 {{0,1}, {1,0}, {1,1}},
		 {{0,1}, {-1,1}, {-1,2}},
		 {{1,0}, {1,1}, {2,1}},
		 {{0,1}, {1,1}, {1,2}},
		 {{1,0}, {1,-1}, {2,-1}},
		 {{0,1}, {0,2}, {-1,1}},
		 {{0,1}, {0,2}, {1,1}},
		 {{1,0}, {2,0}, {1,1}},
		 {{1,0}, {2,0}, {1,-1}},
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[][] arr = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int res = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				for (int k = 0; k < 19; k++) {
					int sum = arr[i][j];
					for (int l = 0; l < 3; l++) {
						int a = i + block[k][l][0];
						int b = j + block[k][l][1];
						if (a >= 0 && a < x && b >= 0 && b < y) {
							sum += arr[a][b];
						}
					}
					if (res < sum) {
						res = sum;
					}
				}
			}
		}
		System.out.println(res);
	}
}
