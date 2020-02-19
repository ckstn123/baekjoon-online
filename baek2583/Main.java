import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int K;
    static int num = 1;
    static int[][] matrix;
    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<block> queue = new LinkedList<>();
    static PriorityQueue<Integer> result = new PriorityQueue<>();
    static class block{
        int x, y;
        block(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs(int x, int y){

        visited[x][y] = 1;//방문했다고 표시
        queue.offer(new block(x,y));//큐에 추가
        while(!queue.isEmpty()){
            block temp = queue.poll();
            int tempx = temp.x;
            int tempy = temp.y;
            for(int dir = 0; dir<4; dir++) {
                int dis_x = tempx + dx[dir];
                int dis_y = tempy + dy[dir];
                if(dis_x >= 0 && dis_x < N && dis_y >= 0 && dis_y < M){
                    if(visited[dis_x][dis_y] != 1 && matrix[dis_x][dis_y] == 0){//방문하지도 않았고 그려진 영역도 아니면
                        num++; //분리된 영역 개수 +1
                        bfs(dis_x,dis_y);
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        matrix = new int[N][M];
        visited = new int[N][M];
        for(int i = 0; i<K; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for(int y = y1; y<y2; y++){
                for(int x = x1; x<x2; x++){
                    matrix[x][y] = 1;
                }
            }
        }
        for(int i = 0; i<M; i++){
            for(int j = 0; j<N; j++){
                if(matrix[j][i] == 0 && visited[j][i] == 0){//분리된 영역의 시작
                    bfs(j,i);
                    result.offer(num);//각 영역의 넓이 추가
                    num = 1;
                }
            }
        }
        System.out.println(result.size());
        while(!result.isEmpty()){
            System.out.print(result.poll() + " ");
        }
    }
}
