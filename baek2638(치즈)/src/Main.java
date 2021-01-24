import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N;
    static int M;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] matrix;
    static boolean[][] visited;
    static boolean[][] air_visited;
    static Stack<point> c_stack;
    static class point{
        int x, y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void air_bfs(int x, int y){
        Queue<point> queue = new LinkedList<>();
        queue.offer(new point(x,y));
        matrix[y][x] = 2;
        while(!queue.isEmpty()){
            point temp = queue.poll();
            for(int i = 0; i<4; i++){
                int dis_x = temp.x + dx[i];
                int dis_y = temp.y + dy[i];
                if(dis_x < 0 || dis_x >= M || dis_y < 0 || dis_y >= N || air_visited[dis_y][dis_x] || matrix[dis_y][dis_x] == 1){
                    continue;
                }
                air_visited[dis_y][dis_x] = true;
                queue.offer(new point(dis_x,dis_y));
            }
        }

    }

    static void cheese_bfs(int x, int y){
        Queue<point> queue = new LinkedList<>();
        queue.offer(new point(x,y));
        visited[y][x] = true;
        while(!queue.isEmpty()){
            point temp = queue.poll();
            int count = 0;
            for(int i = 0; i<4; i++){
                int dis_x = temp.x + dx[i];
                int dis_y = temp.y + dy[i];
                if(dis_x < 0 || dis_x >= M || dis_y < 0 || dis_y >= N || visited[dis_y][dis_x]){
                    continue;
                }
                if(air_visited[dis_y][dis_x]){
                    count++;
                    continue;
                }
                visited[dis_y][dis_x] = true;
                queue.offer(new point(dis_x,dis_y));
            }

            if(count > 1){
                c_stack.push(new point(temp.x,temp.y));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int cheese_count = 0;
        matrix = new int[N][M];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                matrix[i][j] = sc.nextInt();
                if(matrix[i][j] == 1){
                    cheese_count++;
                }
            }
        }
        int x = 0;
        int y = 0;
        int time = 0;
        while (cheese_count > 0){
            air_visited = new boolean[N][M];
            air_bfs(x,y);

            c_stack = new Stack<>();
            visited = new boolean[N][M];
            for(int i = 1; i<N-1; i++) {
                for (int j = 1; j < M-1; j++) {
                    if(!visited[i][j] && matrix[i][j] == 1){
                        cheese_bfs(j,i);
                    }
                }
            }

            cheese_count -= c_stack.size();
            for(point temp : c_stack){
                matrix[temp.y][temp.x] = 0;
            }
            time++;
        }
        System.out.println(time);
    }
}
