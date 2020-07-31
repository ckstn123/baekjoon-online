import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        int result = 0;
        int[] array = new int[N+2];
        array[0] = 0;
        array[N+1] = L;
        for(int i=1; i<=N; i++){
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);

        int left = 0;
        int right = L-1;
        int mid = 0;
        while(left<=right){
            mid = (left+right)/2;
            int sum = 0;
            for(int i = 0; i<N+1; i++){
                int diff = array[i+1] - array[i] - 1;
                if(diff >= mid){
                    sum += diff/mid;
                }
            }
            if(sum <= M){
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}
