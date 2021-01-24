import java.util.*;

public class Main {
    static int n;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] matrix;
    static Queue<virus> virusQueue;
    static class virus{
        int x,y,num;

        public virus(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static Comparator<virus> comp = (a,b) -> {
        return a.num - b.num;
    };

    static Queue<virus> bfs(){
        Queue<virus> queue = new PriorityQueue<>(comp);
        while(!virusQueue.isEmpty()){
            virus temp = virusQueue.poll();
            for(int i = 0; i<4; i++){
                int x = temp.x +dx[i];
                int y = temp.y + dy[i];
                if(x < 0 || x >= n || y < 0 || y >= n || matrix[y][x] != 0){
                    continue;
                }
                queue.offer(new virus(x,y, temp.num));
                matrix[y][x] = temp.num;
            }
        }
        return queue;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt();
        matrix = new int[n][n];

        virusQueue = new PriorityQueue<>(comp);
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                matrix[i][j] = sc.nextInt();
                if(matrix[i][j] != 0){
                    virusQueue.offer(new virus(j,i,matrix[i][j]));
                }
            }
        }
        int s = sc.nextInt();
        int y = sc.nextInt()-1;
        int x = sc.nextInt()-1;
        for(int i = 0; i<s; i++){
            virusQueue = bfs();
            if(matrix[y][x] != 0){
                System.out.println(matrix[y][x]);
                return;
            }
        }
        System.out.println(matrix[y][x]);
    }
}
