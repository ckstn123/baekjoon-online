import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int INF = 987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();
        long[][] matrix = new long[N+1][N+1];
        for(int i = 1; i<=N; i++){
            Arrays.fill(matrix[i], INF);
            matrix[i][i] = 0;
        }
        for(int i = 0; i<E; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            matrix[a][b] = c;
            matrix[b][a] = c;
        }

        for(int k = 1; k<=N; k++){
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=N; j++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        long result = matrix[1][v1] + matrix[v1][v2] + matrix[v2][N];
        result = Math.min(result, matrix[1][v2] + matrix[v2][v1] + matrix[v1][N]);
        if(result >= INF)
            System.out.println(-1);
        else
            System.out.println(result);
    }
}
