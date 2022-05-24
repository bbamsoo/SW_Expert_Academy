package D3;

import java.util.*;

public class SW4466{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)	{
            int N = sc.nextInt(); int K = sc.nextInt();
            int [] scores = new int[N];
            int sum=0;
            for(int i=0;i<N;i++) {
                scores[i] = sc.nextInt();
            }
            Arrays.sort(scores);

            for(int i=scores.length-1; i>=scores.length-K;i--) {
                sum+=scores[i];
            }
            System.out.println("#"+test_case+" "+sum);
        }
    }
}