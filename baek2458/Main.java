import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int answer = 0;
        int INF = 987654321;
        boolean[] check = new boolean[n+1];
        int[][] rank = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            Arrays.fill(rank[i],INF);
        }
        for(int i = 1; i<=n; i++){
            rank[i][i] = 0;
        }

        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            rank[a][b] = 1;
        }
        for(int k = 1; k<=n; k++){
            for(int i = 1; i<=n; i++){
                for(int j = 1; j<=n; j++){
                    rank[i][j] = Math.min(rank[i][j], rank[i][k] + rank[k][j]);
                }
            }
        }
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(i==j)
                    continue;
                if(rank[i][j] == INF && rank[j][i] == INF){
                    check[i] = true;
                    break;
                }
            }
        }
        for(int i = 1; i<=n; i++){
            if(!check[i]){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
