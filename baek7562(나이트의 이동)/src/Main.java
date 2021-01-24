import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int result = 0;
    static int[] dx = {1,2,2,1,-1,-2,-2,-1};
    static int[] dy = {2,1,-1,-2,-2,-1,1,2};
    static boolean[][] visited;
    static int[][] matrix;

    static class  point{
        int x, y, cnt;

        public point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static void bfs(int x, int y, int end_x, int end_y){
        Queue<point> queue = new LinkedList<>();
        queue.offer(new point(x,y,0));
        visited[y][x] = true;
        while(!queue.isEmpty()){
            point temp = queue.poll();
            if(temp.x == end_x && temp.y == end_y){
                result = temp.cnt;
                return;
            }
            for(int i = 0; i<8; i++){
                int dis_x = temp.x + dx[i];
                int dis_y = temp.y + dy[i];
                if(dis_x < 0 || dis_x >= N || dis_y < 0 || dis_y >= N || visited[dis_y][dis_x])
                    continue;

                visited[dis_y][dis_x] = true;
                queue.offer(new point(dis_x,dis_y,temp.cnt+1));
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test = 0; test<tc; test++) {
            N = sc.nextInt();
            matrix = new int[N][N];
            visited = new boolean[N][N];
            int x = sc.nextInt();
            int y = sc.nextInt();
            int end_x = sc.nextInt();
            int end_y = sc.nextInt();
            bfs(x,y,end_x,end_y);
            System.out.println(result);
            result = 0;
        }
    }
}
