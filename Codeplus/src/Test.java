
public class Test {

	public static void main(String[] args) {

		int[] arr = new int[6];
		for (int i = 1; i <= 5; i++) {
			arr[i] = i+1;
		}
		for (int j = 0; j <= 5; j++) {
			System.out.println(arr[j]);			
		}
	}
}
