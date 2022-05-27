package D3;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N= sc.nextInt();
            int[] arr = new int[N];
            String answer = "Yes";
            for (int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            for (int i=1; i<N+1; i++){
                if (arr[i-1] != i){
                    answer = "No";
                    break;
                }
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}
