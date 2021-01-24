import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] matrix;
    static int[][] dp;
    static void dfs(int now, int prev){
        dp[now][0] = 0;
        dp[now][1] = 1;
        for(int i = 0; i<matrix[now].size(); i++){
            int next = matrix[now].get(i);
            if(next != prev){
                dfs(next,now);
                dp[now][0] += dp[next][1];
                dp[now][1] += Math.min(dp[next][0], dp[next][1]);

            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        matrix = new ArrayList[n+1];
        dp = new int[n+1][2];
        for(int i = 1; i<=n; i++){
            matrix[i] = new ArrayList<>();
        }

        for(int i = 1; i<n; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            matrix[u].add(v);
            matrix[v].add(u);
        }

        dfs(1,0);
        int result = Math.min(dp[1][0], dp[1][1]);
        System.out.println(result);
    }
}
