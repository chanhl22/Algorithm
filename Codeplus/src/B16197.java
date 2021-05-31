import java.util.*;

public class B16197 {
	static char[][] arr;
	static int n;
	static int m;
	static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		arr = new char[n][m];
		int x1,y1,x2,y2;
		x1=y1=x2=y2=-1;
		
		for (int i = 0; i < n; i++) {
			String a = sc.nextLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = a.charAt(j);
			}
		}
		//System.out.println(go(0, x1, y1, x2, y2));
	}

}
