import java.util.Arrays;

class Group2{
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
        int cnt = 0;
        int req_cnt = 0;
        if (sticky) {
            
//            boolean[] check = new boolean[requests.length + 1];
//            for (int i = 0; i < servers; i++) {
//                for (int j = 0; j < servers; j++) {
//                    if (check[requests[req_cnt]] == true) {
//                        for (int k = 0; k < servers; k++) {
//                            for (int l = 0; l < servers; l++) {
//                                if(answer[k][l] == requests[req_cnt]) {
//                                    answer[k][cnt] = requests[req_cnt];
//                                }
//                            }
//                        }
//                    } else {
//                        answer[j][cnt] = requests[req_cnt];
//                        check[requests[req_cnt]] = true;
//                    }
//                    req_cnt++;
//                }
//                cnt++;
//            }
        }
        if (!sticky) {
            for (int i = 0; i < servers; i++) {
                for (int j = 0; j < servers; j++) {
                    answer[j][cnt] = requests[req_cnt++];
                }
                cnt++;
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
        ans = sol.solution(2,true,new int[]{1,1,2,2});
        System.out.println(Arrays.deepToString(ans));
    }
}