import java.util.Arrays;

class Group2 {
    int x;
    int y;
    int index;

    public Group2(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}

class Solution11 {
    public int[][] solution(int servers, boolean sticky, int[] requests) {
        int[][] answer = new int[servers][servers];
        int n = requests.length;
        int cnt = 0;
        if (sticky) {
            boolean[] check = new boolean[n+1];
            for (int j = 0; j < servers; j++) {
                for (int i = 0; i < servers; i++) {

                    answer[i][j] = requests[cnt++];
                }
            }
        }
        if (!sticky) {
            for (int j = 0; j < servers; j++) {
                for (int i = 0; i < servers; i++) {
                    answer[i][j] = requests[cnt++];
                }
            }
        }
        return answer;
    }
}


public class T2 {
    public static void main(String[] args) {
        Solution11 sol = new Solution11();
        int[][] ans = {};
        //ans = sol.solution(2,false,new int[]{1,2,3,4});
        ans = sol.solution(2, true, new int[]{1, 1, 2, 2});
        System.out.println(Arrays.deepToString(ans));
    }
}