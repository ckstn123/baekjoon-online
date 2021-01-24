import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int m;
    static int n;
    static int max = 0;
    static int[][] matrix;
    static boolean[][] visited;
    static class Pair{
        int x, y, distance;
        Pair(int x, int y, int d){
            this.x = x;
            this.y = y;
            distance = d;
        }
    }
    static void bfs(int x, int y){
        Queue<Pair> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.offer(new Pair(x,y,0));

        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            int distance = temp.distance;
            if(max < distance){
                max = distance;
            }

            for (int dir = 0; dir < 4; dir++) {
                int dis_x = temp.x + dx[dir];
                int dis_y = temp.y + dy[dir];
                if (dis_x < 0 || dis_x >= n || dis_y < 0 || dis_y >= m || matrix[dis_y][dis_x] == 0 || visited[dis_y][dis_x])
                    continue;
                visited[dis_y][dis_x] = true;
                queue.offer(new Pair(dis_x,dis_y,distance+1));
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        m = Integer.parseInt(line.split(" ")[0]);
        n = Integer.parseInt(line.split(" ")[1]);

        matrix = new int[m][n];
        visited = new boolean[m][n];
        for(int i = 0; i<m; i++){
            line = br.readLine();
            for (int j = 0; j<n; j++){
                if(line.charAt(j) == 'W')
                    matrix[i][j] = 0;
                else if(line.charAt(j) == 'L')
                        matrix[i][j] = 1;
            }
        }

        for(int i = 0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 1){
                    bfs(j,i);
                    visited = new boolean[m][n];
                }
            }
        }
        System.out.println(max);
    }
}
