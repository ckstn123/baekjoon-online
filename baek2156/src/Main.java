import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        int n = sc.nextInt();
        int[] dp = new int[n];
        int[] glass = new int[n];
        for(int i = 0; i<n; i++){
            glass[i] = sc.nextInt();
        }
        if(n >= 1){
            dp[0] = glass[0];
        }
        if(n>=2){
            dp[1] = glass[0] + glass[1];
        }
        if(n>=3){
            dp[2] = Math.max(dp[1],Math.max(dp[0]+glass[2], glass[1]+glass[2]));
        }
        for(int i = 3; i<n; i++){
            dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+glass[i], dp[i-3] + glass[i-1]+glass[i]));
        }
        System.out.println(dp[n-1]);
    }
}