import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] matrix;
    static int[][] check;
    static class point{
        int x,y,num;
        point(int x, int y, int n){
            this.x = x;
            this.y = y;
            this.num = n;
        }
    }
    static void bfs(int x, int y){
        Queue<point> queue = new LinkedList<>();
        queue.offer(new point(x,y,0));
        check[y][x] = 0;
        while(!queue.isEmpty()){
            point temp = queue.poll();
            for(int dir = 0; dir<4; dir++){
                int dis_x = temp.x + dx[dir];
                int dis_y = temp.y + dy[dir];
                if(dis_x < 1 || dis_x > M || dis_y < 1 || dis_y > N)
                    continue;
                if(dis_x == M && dis_y == N){
                    min = Math.min(min, temp.num);
                    continue;
                }
                if(matrix[dis_y][dis_x] == 1){
                    if(check[dis_y][dis_x] > temp.num + 1){
                        check[dis_y][dis_x] = temp.num + 1;
                        queue.offer(new point(dis_x,dis_y,temp.num+1));
                    }
                }
                else {
                    if(check[dis_y][dis_x] > temp.num){
                        check[dis_y][dis_x] = temp.num;
                        queue.offer(new point(dis_x,dis_y,temp.num));
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        if(N == 1 && M == 1){
            System.out.println(0);
            return;
        }
        matrix = new int[N+1][M+1];
        check = new int[N+1][M+1];
        for(int i = 1; i<=N; i++){
            Arrays.fill(check[i], Integer.MAX_VALUE);
        }
        for(int i = 1; i<=N; i++){
            String str = sc.next();
            for(int j = 0; j<M; j++){
                matrix[i][j+1] = str.charAt(j) - '0';
            }
        }

        bfs(1,1);

        System.out.println(min);
    }
}
