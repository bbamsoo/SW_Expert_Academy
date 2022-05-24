package D3;

import java.util.*;

public class SW14361 {

    static List<ArrayList<Integer>> check = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int temp=0, n=0, sum=0;
        Boolean possible = null;
        List<Integer> num = new ArrayList<Integer>();
        Map<Integer,Boolean> answer = new LinkedHashMap<Integer,Boolean>();

        for(int test_case = 1; test_case <= T; test_case++){
            int input = sc.nextInt();
            temp = input;
            int mul=1;
            while(temp!=0) {
                n++;
                temp /=10;
            }
            temp = input;
            if(n == 1)
                possible = false;
            else {
                int[] A = new int[n];
                for(int i = 0; i < A.length ; i++) {
                    A[i] = input%10;
                    input/=10;
                }
                input = temp;
                permutation(A, 0, A.length, A.length);
                for(ArrayList<Integer> list:check) {
                    for(int i:list) {
                        sum+=(i*mul);
                        mul*=10;
                    }
                    num.add(sum);
                    mul = 1;
                    sum = 0;
                }
                for(int i:num) {
                    if(i>input && i%input == 0) {
                        possible = true;
                        break;
                    }
                    else possible = false;
                }
            }
            answer.put(test_case, possible);
            check.clear(); num.clear(); n=0;
        }
        for(int i:answer.keySet()) {
            if(answer.get(i)==true)
                System.out.println("#"+i+" possible");
            else
                System.out.println("#"+i+" impossible");
        }
    }
    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(arr[i]);
            }
            check.add(temp);
            return;
        }

        for (int i=depth; i<arr.length; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
