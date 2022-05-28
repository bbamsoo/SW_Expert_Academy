package D3;
import java.util.*;

public class SW13041 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1;test_case<=T;test_case++){
            int N =sc.nextInt(); int K = sc.nextInt();
            long result=0;
            int[][]works = new int[N][2];
            int[]person = new int[N];
            int[]select = new int[K];
            Arrays.fill(person, Integer.MAX_VALUE);
            for (int i=0;i<N;i++)
                works[i][0]= sc.nextInt();
            for (int i=0;i<N;i++){
                works[i][1]= sc.nextInt();

                if (select[works[i][0]-1]==0)
                    select[works[i][0]-1]=works[i][1];
                else if (select[works[i][0]-1]!=0 && select[works[i][0]-1] < works[i][1]){
                    person[i] = select[works[i][0]-1];
                    select[works[i][0]-1] = works[i][1];
                }
                else person[i]=works[i][1];
            }
            Arrays.sort(person);

            int num = 0;
            for (int i = 0; i < K; i++) {
                if(select[i] == 0) {
                    result += person[num];
                    num++;
                }
            }
            System.out.println("#"+test_case+" "+result);
        }
    }
}