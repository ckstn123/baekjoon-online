import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int C = sc.nextInt();
        long sum = 0;
        long[] pa_list = new long[S];
        for(int i = 0; i<S; i++){
            pa_list[i] = sc.nextLong();
            sum += pa_list[i];
        }
        Arrays.sort(pa_list);
        long left = 1;
        long right = pa_list[S-1];
        long mid;
        long result = 0;
        long num;
        while(left <= right){
            num = 0;
            mid = (left + right)/2;
            for(long pa : pa_list){
                num += pa/mid;
            }

            if(num >= C){
                left = mid + 1;
                result = mid;
            }
            else {
                right = mid - 1;
            }

        }
        System.out.println(sum - (result * C));
    }
}
