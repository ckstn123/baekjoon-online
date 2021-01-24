import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int INF = 987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int result = 0;
        int[][] matrix = new int[n+1][n+1];

        for(int i = 1; i<=n; i++){
            Arrays.fill(matrix[i],INF);
        }
        for(int i = 1; i<=n; i++){
            matrix[i][i] = 0;
        }

        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            matrix[a][b] = c;
        }

        for(int k = 1; k<=n; k++){
            for(int i = 1; i<=n; i++){
                for(int j = 1; j<=n; j++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        for(int i = 1; i<=n; i++){
            result = Math.max(result, matrix[i][x] + matrix[x][i]);
        }
        System.out.println(result);
    }
}
