import java.util.Scanner;

public class Main {
    static class consult{
        int time, price;

        public consult(int time, int price) {
            this.time = time;
            this.price = price;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        consult[] list = new consult[n];
        int[] dp = new int[20];
        int result = 0;
        for(int i = 0; i<n; i++){
            list[i] = new consult(sc.nextInt(), sc.nextInt());
        }

        for(int i = 0; i<n; i++){
            if(i != 0)
                dp[i] = Math.max(dp[i-1],dp[i]);
            dp[i+list[i].time] = Math.max(dp[i+list[i].time], dp[i] + list[i].price);
        }

        for(int i = 0; i<=n; i++){
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
