import java.util.Scanner;

public class B16968 {
    static int go(String s, int index, char last){
        if (index == s.length()){
            return 1;
        }
        int ans = 0;
        char start = (s.charAt(index) == 'c') ? 'a' : '0';
        char end = (s.charAt(index) == 'c') ? 'z' : '9';
        for (char i = start; i <= end; i++) {
            if (i != last) {
                ans += go(s,index+1,i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(go(s,0, ' '));
    }
}
