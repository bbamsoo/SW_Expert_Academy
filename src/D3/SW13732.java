package D3;

import java.util.*;

public class SW13732{
    public static void main(String args[])	{

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)	{
            int N = sc.nextInt();
            char [][] square = new char[N][N];
            int index = 0;

            for(int i=0;i<N;i++) {
                String data = sc.next();
                for(int j=0;j<N;j++) {
                    square[i][j] = data.charAt(index++);
                }
                index=0;
            }
            int []pos = {N+1,N+1,-1,-1};

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(square[i][j] == '#'){
                        pos[0] = Math.min(pos[0], i);
                        pos[1] = Math.min(pos[1], j);
                        pos[2] = Math.max(pos[2], i);
                        pos[3] = Math.max(pos[3], j);
                    }
                }
            }
            Boolean check = true;

            if(pos[2] - pos[0] != pos[3] - pos[1])
                check = false;

            for(int i = pos[0]; i <= pos[2]; i++){
                for(int j = pos[1]; j <= pos[3]; j++) {
                    if(square[i][j] != '#')
                        check = false;
                }
            }
            if(check)
                System.out.println("#"+test_case+" yes");
            else
                System.out.println("#"+test_case+" no");
        }
    }
}
