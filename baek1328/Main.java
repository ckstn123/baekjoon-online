import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();

        long[][][] dp = new long[N+1][N+1][N+1];
        //int[] buildings = new int[N+1];

        dp[0][0][0] = 0;
        dp[1][1][1] = 1;
        for(int i = 2; i<N+1; i++){
            dp[i][i][1] = 1;
            dp[i][1][i] = 1;
        }
        for(int i = 2; i<N+1; i++){
            for(int j = 1; j<L+1; j++){
                for(int k = 1; k< R+1; k++){
                    dp[i][j][k] = (dp[i-1][j][k] * (i-2) + dp[i-1][j-1][k] + dp[i-1][j][k-1])%1000000007;
                }
            }
        }
        System.out.println(dp[N][L][R]);

    }
}
