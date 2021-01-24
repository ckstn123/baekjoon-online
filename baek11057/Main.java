import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[10];
        for(int i=0; i<10; i++)
            dp[i] = 1;

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j<10; j++){
                dp[j] = (dp[j-1] + dp[j])%10007;
            }
        }

        System.out.println(dp[9]);
    }
}
