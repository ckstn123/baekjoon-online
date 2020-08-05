import java.util.*;

public class Main {
    static int INF = 1000000;
    static int n;
    static int[] parents;
    static int[][] matrix;
    static boolean[] visited;
    static ArrayList<Integer> result = new ArrayList<>();

    static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        int min = parents[x];
        int present = x;
        queue.offer(x);
        visited[x] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i = 1; i<=n; i++){
                if(!visited[i] && matrix[temp][i] > 0 && matrix[temp][i] < INF){
                    visited[i] = true;
                    if(min > parents[i]){
                        present = i;
                        min = parents[i];
                    }
                    queue.offer(i);
                }
            }
        }
        result.add(present);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        parents = new int[n+1];
        visited = new boolean[n+1];
        matrix = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            Arrays.fill(matrix[i], INF);
            matrix[i][i] = 0;
        }
        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
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
            for(int j = 1; j<=n; j++){
                if(matrix[i][j] > 0 && matrix[i][j] < INF) {
                    parents[i] = Math.max(parents[i], matrix[i][j]);
                }
            }
        }

        for(int i = 1; i<=n; i++) {
            if(!visited[i]){
                bfs(i);
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int num : result)
            System.out.println(num);
    }
}
