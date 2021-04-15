import java.util.*;

public class Test {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] c = new boolean[10][10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 2;
		int m = 2;
		boolean ok = true;
		for (int i=0; i<4; i++) {
			 int nx = dx[i];
			 int ny = dy[i];
			 if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				 ok = false;
				 System.out.println("asdfds");
			 }
			 System.out.println(ok);
		}
		System.out.println(ok);
	}
}
