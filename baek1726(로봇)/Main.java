import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int m;
    static int n;
    static int result = 0;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] matrix;
    static int[][][] visited;
    static robot end;

    static class robot{
        int x,y,dir,time;
        robot(int x, int y, int dir, int time){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.time = time;
        }
    }
    static boolean isMove(int x, int y, int dir){
        if(x < 0 || x >= n || y < 0 || y >= m || matrix[y][x] == 1)
            return false;
        else
            return true;
    }
    static void bfs(int x, int y, int dir){
        Queue<robot> queue = new LinkedList<>();
        queue.offer(new robot(x,y,dir,0));
        visited[y][x][dir] = 0;
        while(!queue.isEmpty()){
            robot temp = queue.poll();
            x = temp.x;
            y = temp.y;
            dir = temp.dir;
            if(x == end.x && y == end.y && dir == end.dir){
                result = temp.time;

            }
            int time = temp.time;
            //방향대로 쭉 가는 경우
            for(int i = 0; i<3; i++){
                x = x + dx[dir];
                y = y + dy[dir];
                if(!isMove(x,y,dir))
                    break;
                if(visited[y][x][dir] == -1 || visited[y][x][dir] > time + 1) {
                    visited[y][x][dir] = time + 1;
                    queue.offer(new robot(x, y, dir, time + 1));
                }
            }
            x = temp.x;
            y = temp.y;
            if(dir%2 == 0){
                if(isMove(x,y,(dir+2)%4)){
                    if(visited[y][x][(dir+2)%4] == -1 || visited[y][x][(dir+2)%4] > time + 1) {
                        visited[y][x][(dir+2)%4] = time + 1;
                        queue.offer(new robot(x, y, (dir+2)%4, time + 1));
                    }
                }
                if(isMove(x,y,(dir+3)%4)){
                    if(visited[y][x][(dir+3)%4] == -1 || visited[y][x][(dir+3)%4] > time + 1) {
                        visited[y][x][(dir+3)%4] = time + 1;
                        queue.offer(new robot(x, y, (dir+3)%4, time + 1));
                    }
                }
            }
            else {
                if(isMove(x,y,(dir+2)%4)){
                    if(visited[y][x][(dir+2)%4] == -1 || visited[y][x][(dir+2)%4] > time + 1) {
                        visited[y][x][(dir+2)%4] = time + 1;
                        queue.offer(new robot(x, y, (dir+2)%4, time + 1));
                    }
                }
                if(isMove(x,y,(dir+1)%4)){
                    if(visited[y][x][(dir+1)%4] == -1 || visited[y][x][(dir+1)%4] > time + 1) {
                        visited[y][x][(dir+1)%4] = time + 1;
                        queue.offer(new robot(x, y, (dir+1)%4, time + 1));
                    }
                }
            }

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        matrix = new int[m][n];
        visited = new int[m][n][4];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                matrix[i][j] = sc.nextInt();
                Arrays.fill(visited[i][j], -1);
            }
        }

        int y = sc.nextInt()-1;
        int x = sc.nextInt()-1;
        int dir = sc.nextInt() -1;
        int end_y = sc.nextInt()-1;
        int end_x = sc.nextInt()-1;
        int end_dir = sc.nextInt()-1;
        end = new robot(end_x,end_y,end_dir,0);
        bfs(x,y,dir);
        System.out.println(result);
    }
}
