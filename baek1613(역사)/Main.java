import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n+1][n+1];
        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            matrix[a][b] = 1;
        }
        for(int k = 1; k<=n; k++){
            for(int i = 1; i<=n; i++){
                for(int j = 1; j<=n; j++){
                    matrix[i][j] = Math.max(matrix[i][k] * matrix[k][j] , matrix[i][j]);
                }
            }
        }
        int s = sc.nextInt();
        for(int i = 0; i<s; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(matrix[a][b] == 1)
                System.out.println(-1);
            else if(matrix[b][a] == 1)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
