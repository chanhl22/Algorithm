import java.util.*;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		while (num-- > 0) {
			String[] s = sc.nextLine().split(" ");
			
			int M = Integer.parseInt(s[0]);
			int N = Integer.parseInt(s[1]);
			int x = Integer.parseInt(s[2]) - 1;
			int y = Integer.parseInt(s[3]) - 1;
			
			System.out.println(s[0]);
			System.out.println(s[1]);
			System.out.println(s[2]);
			System.out.println(s[3]);
		}
	}
}
