import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        int[] costs = new int[N];
        for(int i = 0; i<N; i++){
            costs[i] =sc.nextInt();
        }
        Arrays.sort(costs);
        int M = sc.nextInt();
        int left = 0;
        int right = costs[N-1];
        int mid = 0;
        while(left <= right){
            int sum = 0;
            mid = (left+right)/2;
            for(int cost : costs){
                sum += Math.min(cost, mid);
            }
            if(sum <= M){
                left = mid + 1;
                result = mid;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}
