import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = 0;
        int min = Integer.MAX_VALUE;
        int[][] matrix = new int[N][3];
        int[][] max_dp = new int[N][3];
        int[][] min_dp = new int[N][3];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<3; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        max_dp[0][0] = matrix[0][0];
        max_dp[0][1] = matrix[0][1];
        max_dp[0][2] = matrix[0][2];

        min_dp[0][0] = matrix[0][0];
        min_dp[0][1] = matrix[0][1];
        min_dp[0][2] = matrix[0][2];

        for(int i = 1; i<N; i++){
            for(int j = 0; j<3; j++){
                if(j == 0){
                    max_dp[i][j] = matrix[i][j] + Math.max(max_dp[i-1][0],max_dp[i-1][1]);
                    min_dp[i][j] = matrix[i][j] + Math.min(min_dp[i-1][0],min_dp[i-1][1]);

                }
                if(j == 1){
                    max_dp[i][j] = matrix[i][j] + Math.max(max_dp[i-1][0], Math.max(max_dp[i-1][2],max_dp[i-1][1]));
                    min_dp[i][j] = matrix[i][j] + Math.min(min_dp[i-1][0], Math.min(min_dp[i-1][2],min_dp[i-1][1]));
                }
                if(j == 2){
                    max_dp[i][j] = matrix[i][j] + Math.max(max_dp[i-1][2],max_dp[i-1][1]);
                    min_dp[i][j] = matrix[i][j] + Math.min(min_dp[i-1][2],min_dp[i-1][1]);

                }
            }
        }

        for(int i = 0; i<3; i++){
            max = Math.max(max, max_dp[N-1][i]);
            min = Math.min(min, min_dp[N-1][i]);
        }

        System.out.println(max + " " + min);
    }
}
