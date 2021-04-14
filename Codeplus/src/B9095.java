import java.util.*;

public class B9095 {
	static int is_count(int sum, int input) {
		if (sum > input)
			return 0;
		if (sum == input)
			return 1;
		int count = 0;
		for (int i = 1; i <= 3; i++) {
			count += is_count(sum+i, input);
		}
		return count;
			
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();
			ans = is_count(0, input);
			System.out.println(ans);
		}
	}
}