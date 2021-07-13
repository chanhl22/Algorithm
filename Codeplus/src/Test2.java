import java.util.ArrayList;

class Solution {
    static int go(int[][] arr, int sx, int sy, int ex, int ey){
        int ans = 0;
        ArrayList<Integer> q = new ArrayList<>();
        for (int i = sy; i <= ey; i++) {
            ans += arr[ex][i];
            q.add(arr[ex][i]);
//            System.out.println("----");
//            System.out.println(arr[ex][i]);
        }
//        for (int i = ex; i <= sx; i--) {
//            for (int j = ey; j <= ex; j--) {
//                if (i+1 >= arr.length) continue;
//                arr[i+1][j] = arr[i][j];
//            }
//        }
        ArrayList<Integer> group = new ArrayList<>();
        for (int j = sy; j <= ey; j++) {
            for (int i = sx; i < ex; i++) {
                int temp = arr[ex][sy];

            }

        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        return ans;
    }

    public int[] solution(int rows, int columns, int[][] swipes) {
        int[] answer = {};
        int[][] arr = new int[rows][columns];
        //init
        int n = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = n;
                n++;
            }
        }

        for (int i = 0; i < swipes.length; i++) {
            int cal = swipes[i][0];
            int sx = swipes[i][1] - 1;
            int sy = swipes[i][2] - 1;
            int ex = swipes[i][3] - 1;
            int ey = swipes[i][4] - 1;
            int ans = 0;

            if (cal == 1){
                ans = go(arr,sx,sy,ex,ey);
            } else if (cal == 2){

            } else if (cal == 3){

            } else if (cal == 4){

            }
        }


        return answer;
    }
}



public class Test2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ans = new int[4];
        int[][] swipes = {{1,1,2,4,3},{3,2,1,2,3},{4,1,1,4,3},{2,2,1,3,3}};
        ans = sol.solution(4,3,swipes);
        System.out.println(ans);
    }
}