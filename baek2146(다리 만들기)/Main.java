import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] matrix;
    static boolean[][] visited;
    static int N;
    static int min = Integer.MAX_VALUE;

    static class point{
        int x,y,distance;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
        point(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    static void bfs(int x , int y, int num){
        Queue<point> queue = new LinkedList<>();
        queue.offer(new point(x,y));
        matrix[y][x] = num;
        while(!queue.isEmpty()){
            point temp = queue.poll();
            for(int dir = 0; dir<4; dir++){
                int dis_x = temp.x + dx[dir];
                int dis_y = temp.y + dy[dir];
                if(dis_x < 0 || dis_x >= N || dis_y < 0 | dis_y >= N || matrix[dis_y][dis_x] != -1)
                    continue;
                matrix[dis_y][dis_x] = num;
                queue.add(new point(dis_x,dis_y));
            }
        }
    }

    static void connect(int num){
        Queue<point> queue = new LinkedList<>();
        for(int i = 0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == num) {
                    queue.offer(new point(j,i,0));
                }
            }
        }

        while(!queue.isEmpty()){
            point temp = queue.poll();
            for(int dir = 0; dir<4; dir++){
                int dis_x = temp.x + dx[dir];
                int dis_y = temp.y + dy[dir];
                if(dis_x < 0 || dis_x >= N || dis_y < 0 | dis_y >= N || matrix[dis_y][dis_x] == num)
                    continue;
                if(visited[dis_y][dis_x])
                    continue;
                visited[dis_y][dis_x] = true;
                if(matrix[dis_y][dis_x] != 0){
                    min = Math.min(min, temp.distance);
                    continue;
                }
                queue.add(new point(dis_x,dis_y,temp.distance+1));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int num = 1;
        matrix = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                matrix[i][j] = sc.nextInt();
                if(matrix[i][j] == 1)
                    matrix[i][j] = -1;
            }
        }

        for(int i = 0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == -1) {
                    bfs(j, i, num);
                    num++;
                }
            }
        }

        for(int i = 1; i<=num; i++){
            connect(i);
            visited = new boolean[N][N];
        }
        System.out.println(min);
    }
}
