import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] times = new int[N];
        long sum = 0;
        long result = 0;
        for(int i=0; i<N; i++){
            times[i] = sc.nextInt();

        }
        Arrays.sort(times);
        long left = 0;
        long right = (long)times[N-1] * M;

        long mid = 0;
        while(left<=right){
            mid = (left+right)/2;
            sum = 0;
            for(int time : times){
                sum += mid/time;
            }

            if(sum < M){
                left = mid + 1;

            }
            else {
                right = mid - 1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}
