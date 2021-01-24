import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        long[] lan = new long[K];
        for(int i = 0; i<K; i++){
            lan[i] =sc.nextLong();
        }
        Arrays.sort(lan);
        long left = 1;
        long right = lan[K-1];
        int sum = 0;
        long mid;
        long max = 0;
        while(left <= right){
            mid = (left+right)/2;
            sum = 0;

            for(long temp : lan){
                sum += temp/mid;
                if(sum > N){
                    break;
                }
            }

            if(sum >= N){
                if(max < mid){
                    max = mid;
                }
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }

        }
        System.out.println(max);

    }
}
