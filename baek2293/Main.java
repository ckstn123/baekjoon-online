import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dp = new int[k+1];
        int[] coin = new int[n];
        for(int i = 0; i<n; i++){
            coin[i] = sc.nextInt();
        }
        Arrays.sort(coin);
        dp[0] = 1;

        for(int i = 0; i<n; i++){
            for(int j = 1; j<=k; j++){
                if(j-coin[i] >= 0){
                    dp[j] += dp[j-coin[i]];
                }
            }
        }
        System.out.println(dp[k]);
    }
}