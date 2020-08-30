import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] matrix;
    static int[][][] dist;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static class block{
        int x, y, check;
        block(int x, int y, int c){
            this.x = x;
            this.y = y;
            this.check = c;
        }
    }
    static int bfs(){
        Queue<block> queue = new LinkedList<>();
        queue.offer(new block(1,1,0));
        dist[1][1][0] = 1;
        while(!queue.isEmpty()){
            block temp = queue.poll();
            if(temp.x == M && temp.y == N){
                return dist[N][M][temp.check];
            }
            for(int dir = 0; dir<4; dir++){
                int x = temp.x + dx[dir];
                int y = temp.y + dy[dir];
                if(x < 1 || x > M || y < 1 || y > N || dist[y][x][temp.check] != 0){
                    continue;
                }
                if(matrix[y][x] == 1 && temp.check != 1){
                    queue.offer(new block(x,y,1));
                    dist[y][x][1] = dist[temp.y][temp.x][0] + 1;
                }
                else if(matrix[y][x] != 1){
                    queue.offer(new block(x,y,temp.check));
                    dist[y][x][temp.check] = dist[temp.y][temp.x][temp.check] + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        matrix = new int[N+1][M+1];
        dist = new int[N+1][M+1][2];
        for(int i = 0; i<N; i++){
            String str = sc.next();
            for(int j = 0; j<M; j++){
                matrix[i+1][j+1] = str.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }
}
