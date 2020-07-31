import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M;
    static int N;
    static int num = 0;//안 익은 토마토 개수
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] matrix;
    static Queue<tomato> queue = new LinkedList<>();
    static class tomato{
        int x,y,time;
        tomato(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static void bfs(){
        int count = 0;
        while(!queue.isEmpty()){
            tomato temp = queue.poll();
            for(int dir = 0; dir<4; dir++) {
                int dis_x = temp.x + dx[dir];
                int dis_y = temp.y + dy[dir];
                if (dis_x < 0 || dis_x >= M || dis_y < 0 | dis_y >= N || matrix[dis_y][dis_x] != 0)
                    continue;
                matrix[dis_y][dis_x] = 1;
                count++;
                if(count == num){
                    System.out.println(temp.time+1);
                    return;
                }
                queue.offer(new tomato(dis_x,dis_y,temp.time+1));
            }
        }
        System.out.println(-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        int count = 0; //빈 칸 개수
        matrix = new int[N][M];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                matrix[i][j] = sc.nextInt();
                if(matrix[i][j] == 1){
                    queue.offer(new tomato(j,i,0));
                }
                else if(matrix[i][j] == -1){
                    count++;
                }
                else
                    num++;
            }
        }
        if(queue.size() == 0){
            System.out.println(-1);
            return;
        }
        if(queue.size() == M*N-count){
            System.out.println(0);
            return;
        }
        bfs();

    }
}
