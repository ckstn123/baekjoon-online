import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int w;
    static int h;
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {1,1,0,-1,-1,-1,0,1};
    static int[][] matrix;
    static class point{
        int x, y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y, int num){
        Queue<point> queue = new LinkedList<>();
        queue.offer(new point(x,y));
        matrix[y][x] = num;
        while(!queue.isEmpty()){
            point temp = queue.poll();
            for(int dir = 0; dir<8; dir++){
                int dis_x = temp.x + dx[dir];
                int dis_y = temp.y + dy[dir];
                if (dis_x < 0 || dis_x >= w || dis_y < 0 | dis_y >= h || matrix[dis_y][dis_x] != -1)
                    continue;
                matrix[dis_y][dis_x] = num;
                queue.offer(new point(dis_x,dis_y));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int num = 1;
            w = sc.nextInt();
            h = sc.nextInt();
            if(w == 0 && h == 0)
                return;
            matrix = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    matrix[i][j] = sc.nextInt();
                    if(matrix[i][j] == 1){
                        matrix[i][j] = -1;
                    }
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(matrix[i][j] == -1){
                        bfs(j,i,num);
                        num++;
                    }
                }
            }
            System.out.println(num-1);
        }
    }
}
