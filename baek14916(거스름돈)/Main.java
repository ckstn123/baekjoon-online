import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] money = {2,5};
        int[] dp = new int[N+1];
        Arrays.fill(dp, N+1);
        dp[0] = 0;
        for(int temp : money){
            for(int i = 1; i<=N; i++){
                if(i - temp >= 0){
                    dp[i] = Math.min(dp[i], dp[i-temp] + 1);
                }
            }
        }
        if(dp[N] == N+1)
            System.out.println(-1);
        else
            System.out.println(dp[N]);
    }
}
