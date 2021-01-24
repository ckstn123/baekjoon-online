import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int result = 0;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] matrix;
    static boolean[][] visited;
    static class block{
        int x,y,cnt;
        block(int x, int y, int count){
            this.x = x;
            this.y = y;
            cnt = count;
        }
    }
    static void bfs(){
        Queue<block> queue = new LinkedList<>();
        queue.offer(new block(1,1,1));
        visited[1][1] = true;

        while(!queue.isEmpty()){
            block temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            for(int dir = 0; dir<4; dir++){
                int dis_x = x + dx[dir];
                int dis_y = y + dy[dir];
                if(dis_x < 1 || dis_x > m || dis_y < 1 || dis_y > n || matrix[dis_y][dis_x] == 0 || visited[dis_y][dis_x])
                    continue;

                if(dis_x == m && dis_y == n){
                    result = temp.cnt+1;
                    return;
                }

                visited[dis_y][dis_x] = true;
                queue.offer(new block(dis_x,dis_y,temp.cnt+1));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        matrix = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for(int i = 1; i<=n; i++){
            String str = sc.next();
            for(int j = 1; j<=m; j++){
                matrix[i][j] = str.charAt(j-1) - '0';
            }
        }
        bfs();
        System.out.println(result);
    }
}
