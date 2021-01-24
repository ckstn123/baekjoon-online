import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int INF = 100000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = Integer.MAX_VALUE;
        int[][] matrix = new int[n+1][n+1];
        for(int i =1; i<=n; i++){
            Arrays.fill(matrix[i], INF);
        }
        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            matrix[a][b] = Math.min(matrix[a][b], c);
        }
        for(int k = 1; k<=n; k++){
            for(int i = 1; i<=n; i++){
                for(int j = 1; j<=n; j++){
                    matrix[i][j] = Math.min(matrix[i][k] + matrix[k][j] , matrix[i][j]);
                }
            }
        }
        for(int i = 1; i<=n; i++){
            result = Math.min(result, matrix[i][i]);
        }
        if(result >= INF){
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }
}
