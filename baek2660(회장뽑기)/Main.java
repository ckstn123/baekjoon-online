import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int INF = 987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int score = Integer.MAX_VALUE;
        ArrayList<Integer> result = new ArrayList<>();
        int[][] matrix = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            Arrays.fill(matrix[i], INF);
            matrix[i][i] = 0;
        }
        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a == -1 && b == -1)
                break;
            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }
        for(int k = 1; k<=n; k++){
            for(int i = 1; i<=n; i++){
                for(int j = 1; j<=n; j++){
                    matrix[i][j] = Math.min(matrix[i][k] + matrix[k][j] , matrix[i][j]);
                }
            }
        }
        for(int i = 1; i<=n; i++) {
            int temp_score = 0;
            for (int j = 1; j <= n; j++) {
                if(i != j){
                    temp_score = Math.max(matrix[i][j], temp_score);
                }
            }
            score = Math.min(score, temp_score);
        }
        for(int i = 1; i<=n; i++) {
            boolean flag = false;
            for (int j = 1; j <= n; j++) {
                if(matrix[i][j] > score){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                result.add(i);
            }
        }
        System.out.println(score + " " + result.size());
        for(int num : result)
            System.out.print(num + " ");
    }
}
