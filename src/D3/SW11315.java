package D3;
import java.util.*;

public class SW11315 {
    static int N;
    static char [][] map;
    static int[][] move={{0,1},{1,-1},{1,0},{1,1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1;test_case<=T;test_case++){
            N=sc.nextInt();
            String ans = "NO";
            map = new char[N][N];

            for(int i=0;i<N;i++) {
                String data = sc.next();
                for(int j=0;j<N;j++) {
                    map[i][j] = data.charAt(j);
                }
            }
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    if (map[i][j]=='o'){
                        for (int k=0;k<4;k++){
                            int cnt = count(i,j,k);
                            if (cnt == 5)
                                ans = "YES";
                        }
                    }
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
    static int count(int i,int j,int k){
        int cnt=1;
        int dx=i; int dy=j;
        for (int m=0;m<4;m++){
            dx+=move[k][0];
            dy+=move[k][1];
            if (dx>=0 && dx<N && dy>=0 && dy<N && map[dx][dy] == 'o')
                cnt++;
            else break;
        }
        return cnt;
    }
}