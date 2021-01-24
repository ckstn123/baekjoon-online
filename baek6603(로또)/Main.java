import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int k;
    static int[] matrix;
    static boolean[] visited;
    static int[] result;
    static void dfs(int n, int start){
        if(n == 6){
            for(int i = 0; i<k; i++){
                if(visited[i])
                    System.out.print(matrix[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i<k; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(n+1, i+1);
                visited[i] = false;
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            k = sc.nextInt();
            if(k == 0)
                return;
            matrix = new int[k];
            result = new int[6];
            visited = new boolean[k];
            for (int i = 0; i < k; i++) {
                matrix[i] = sc.nextInt();
            }
            dfs(0,0);
            System.out.println();
        }
    }
}
