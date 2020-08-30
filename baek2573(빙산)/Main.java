import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int time = 0;
    static int num = 1;
    static int[][] matrix;
    static int[][] visited;
    static int[][] new_matrix;

    static class block{
        int x, y;
        public block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static void bfs(int x, int y, int num){
        Queue<block> queue = new LinkedList<>();
        queue.offer(new block(x,y));
        visited[y][x] = num;
        while(!queue.isEmpty()){
            block temp = queue.poll();

            for(int i = 0; i<4; i++){
                int dis_x = temp.x + dx[i];
                int dis_y = temp.y + dy[i];
                if(dis_x < 0 || dis_x >= M || dis_y < 0 || dis_y >= N)
                    continue;
                if(matrix[dis_y][dis_x] == 0){
                    if(new_matrix[temp.y][temp.x] > 0)
                        new_matrix[temp.y][temp.x]--;
                }
                else if(visited[dis_y][dis_x] == 0){
                    visited[dis_y][dis_x] = num;
                    queue.offer(new block(dis_x,dis_y));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        matrix = new int[N][M];
        visited = new int[N][M];
        new_matrix = new int[N][M];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                matrix[i][j] = sc.nextInt();
                new_matrix[i][j] = matrix[i][j];
            }
        }
        while(true) {
            num = 1;
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[i][j] != 0 && visited[i][j] == 0) {
                        flag = true;
                        if (num > 1) {
                            System.out.println(time);
                            return;
                        }
                        bfs(j, i, num);
                        num++;
                    }
                }
            }
            if(!flag){
                System.out.println(0);
                return;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = new_matrix[i][j];
                }
            }
            visited = new int[N][M];
            time++;
        }
    }
}
