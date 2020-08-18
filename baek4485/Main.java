import java.util.*;

public class Main {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] matrix;
    static int[][] visited;

    static class block{
        int x, y, cost;
        block(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static void bfs(int x, int y){
        Queue<block> queue = new LinkedList<>();
        queue.offer(new block(x,y,matrix[y][x]));
        while(!queue.isEmpty()){
            block temp = queue.poll();
            if(temp.x == N-1 && temp.y == N-1){
                min = Math.min(min, temp.cost);
            }
            for(int dir = 0; dir<4; dir++){
                int dis_x = temp.x + dx[dir];
                int dis_y = temp.y + dy[dir];
                if(dis_x < 0 || dis_x >= N || dis_y < 0 || dis_y >= N)
                    continue;
                if(visited[dis_y][dis_x] > temp.cost + matrix[dis_y][dis_x]){
                    visited[dis_y][dis_x] = temp.cost + matrix[dis_y][dis_x];
                    queue.offer(new block(dis_x,dis_y,visited[dis_y][dis_x]));
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 1;
        while(true){
            N = sc.nextInt();
            if(N == 0)
                return;
            matrix = new int[N][N];
            visited = new int[N][N];
            for(int i = 0; i<N; i++){
                Arrays.fill(visited[i], Integer.MAX_VALUE);
                for(int j = 0; j<N; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            bfs(0,0);
            System.out.println("Problem " + T +": " + min);
            min = Integer.MAX_VALUE;
            T++;
        }

    }
}
