import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M;
    static int N;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] matrix;
    static ArrayList<cabbage> list = new ArrayList<>();
    static class cabbage{
        int x,y;
        cabbage(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y){
        matrix[y][x] = 2;
        Queue<cabbage> queue = new LinkedList<>();
        queue.offer(new cabbage(x,y));
        while(!queue.isEmpty()){
            cabbage temp = queue.poll();

            for(int dir = 0; dir<4; dir++){
                int dis_x = temp.x + dx[dir];
                int dis_y = temp.y + dy[dir];
                //상하좌우 확인
                if(dis_x < 0 || dis_x >= M || dis_y < 0 || dis_y >= N)
                    continue;
                //방문하지 않은 배추라면
                if(matrix[dis_y][dis_x] == 1){
                    //방문 표시
                    matrix[dis_y][dis_x] = 2;
                    queue.add(new cabbage(dis_x,dis_y));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int T = sc.nextInt();
        int[] result = new int[T];
        for(int tc = 0; tc<T; tc++){
            M = sc.nextInt();
            N = sc.nextInt();
            int K = sc.nextInt();
            int answer = 0;
            matrix = new int[N][M];
            for(int i = 0; i<K; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                matrix[y][x] = 1;
                list.add(new cabbage(x,y));
            }
            for(cabbage temp : list){

                int x = temp.x;
                int y = temp.y;
                //해당 배추에 방문하지 않았다면
                if(matrix[y][x] == 1){
                    answer++;
                    bfs(x,y);
                }
            }
            result[tc] = answer;
            list.clear();
        }
        for(int i = 0; i<T; i++){
            System.out.println(result[i]);
        }
    }
}
