import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int[] visited;
    public static void dfs(int vertex ,int[][] matrix){
        visited[vertex] = 1;
        for(int i = 1; i<matrix.length; i++){
            if(visited[i] == 0 && matrix[vertex][i] == 1){
                dfs(i, matrix);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;
        int[][] matrix = new int[N+1][N+1];
        visited = new int[N+1];

        for(int i = 0; i<M; i++){
            int src = sc.nextInt();
            int des = sc.nextInt();
            matrix[src][des] = 1;
            matrix[des][src] = 1;
        }

        for(int i = 1; i<N+1; i++){
            if(visited[i] == 0){
                dfs(i, matrix);
                count++;
            }
        }

        System.out.println(count);
    }
}
