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
            matrix[b][a] = 1;
        }
        for(int k = 1; k<=n; k++){
            for(int i = 1; i<=n; i++){
                for(int j = 1; j<=n; j++){
                    matrix[i][j] = Math.max(matrix[i][j], matrix[i][k] * matrix[k][j]);
                }
            }
        }
        for(int i = 1; i<=n; i++){
            int sum = 0;
            for(int j = 1; j<=n; j++){
                //둘 경로 전부 0이어야 비교불가 대상이므로
                if(i!=j && matrix[i][j] == 0 && matrix[j][i] == 0)
                    sum++;
            }
            System.out.println(sum);
        }

    }
}
