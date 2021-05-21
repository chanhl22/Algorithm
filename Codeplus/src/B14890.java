import java.util.*;

public class B14890 {

	static boolean go(int[] d, int l) {
		boolean[] c = new boolean[d.length];
		for (int i = 1; i < d.length; i++) {
			if (d[i] != d[i-1]) { // 인접한 칸이 같지 않다면 하나씩 체크, 같다면 바로 true;
				if (d[i] < d[i-1]) { // 인접한 칸 중 앞이 클때
					if (d[i-1] - d[i] != 1) { //차이가 1이 아닐 때
						return false;
					}
					for (int j = 1; j <= l; j++) { //경사로를 두는 방법 체크
						if (i + j - 1 >= d.length) { // 범위 체크
							return false;
						}
						if (d[i] != d[i+j-1]) { // 뒤의 l칸 체크
							return false;
						}
						if (c[i+j-1]) { // 경사로가 겹칠 때
							return false;
						}
						c[i+j-1] = true;
					}
				} else { // 인접한 칸 중 뒤가 클때
					if (d[i] - d[i-1] != 1) { //차이가 1이 아닐 때
						return false;
					}
					for (int j = 1; j <= l; j++) { //경사로를 두는 방법 체크
						if (i - j < 0) { // 범위 체크
							return false;
						}
						if (d[i-1] != d[i-j]) { // 뒤의 l칸 체크
							return false;
						}
						if (c[i-j]) { // 경사로가 겹칠 때
							return false;
						}
						c[i-j] = true;
					}
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		int ans = 0;
		// row
		for (int i = 0; i < n; i++) {
			int[] d = new int[n];
			for (int j = 0; j < n; j++) {
				d[j] = a[i][j];				
			}
			if (go(d, l)) {
				ans += 1;
			}
		}

		// column
		for (int j = 0; j < n; j++) {
			int[] d = new int[n];
			for (int i = 0; i < n; i++) {
				d[i] = a[i][j];				
			}
			if (go(d, l)) {
				ans += 1;
			}
		}
		System.out.println(ans);

	}

}
