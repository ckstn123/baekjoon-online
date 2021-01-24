import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N+2];
        int[] P = new int[N+2];
        int[] dp = new int[N+2];
        int index = 1;
        int max = 0;

        for(int i = 1; i<N+1; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for(int i = 1; i<=N+1; i++){
            dp[i] = Math.max(dp[i], dp[i - 1]); //당일 상담을 받는 경우와 받지 않는 경우 구분

            if(i + T[i] <= N + 1)
                dp[i + T[i]] = Math.max(dp[i] + P[i], dp[i + T[i]]);

        }
        System.out.println(dp[N+1]);
    }
}
