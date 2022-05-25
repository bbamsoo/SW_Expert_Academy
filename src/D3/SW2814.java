package D3;
import java.util.*;

public class SW2814 {

    static int [][]map;
    static int N,M;
    static boolean [] visited;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){
            N = sc.nextInt(); M = sc.nextInt();
            max =Integer.MIN_VALUE;
            map=new int[N+1][N+1];
            visited = new boolean[N+1];
            for (int i = 0; i < M; i++) {
                int N1 = sc.nextInt();
                int M1 = sc.nextInt();
                map[N1][M1] = map[M1][N1] = 1;
            }
            for (int i = 1; i <= N; i++) {
                visited[i]=true;
                dfs(i,1);
                visited[i]=false;
            }

            if(max == Integer.MIN_VALUE)
                System.out.println("#" + test_case + " " + 1);
            else
                System.out.println("#" + test_case + " " +max);
        }
    }
    static void dfs(int node, int cnt){

        for (int i = 1; i <= N; i++) {
            if(node == i) continue;
            if(map[node][i] == 1 && !visited[i]) {
                visited[i]=true;
                dfs(i, cnt+1);
                visited[i] = false;
            }
        }
        max = Math.max(cnt, max);
    }
}