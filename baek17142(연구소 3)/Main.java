import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int count0 = 0;
    static int min = Integer.MAX_VALUE;

    static int[][] matrix;
    static boolean[] visited;
    static ArrayList<virus> virus_list;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static class virus{
        int x,y,time;
        virus(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static void dfs(int count, int index, int M){
        if(count == M){
            int result = solve();
            if(result > 0){
                if(min > result)
                    min = result;
            }
            return;
        }
        for(int i = index; i<virus_list.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(count+1, i+1, M);
                visited[i] = false;
            }

        }
    }

    static int solve(){
        int n = matrix.length;
        int cnt = 0;
        boolean[][] matrix_visited = new boolean[n][n];
        Queue<virus> queue = new LinkedList<>();
        for(int i = 0; i<visited.length; i++){
            if(visited[i]){
                int x = virus_list.get(i).x;
                int y = virus_list.get(i).y;
                matrix_visited[y][x] = true;
                queue.offer(new virus(x,y,0));
            }
        }
        while(!queue.isEmpty()){
            virus temp = queue.poll();
            if(temp.time >= min-1){
                return 0;
            }
            for(int dir = 0; dir<4; dir++){
                int dis_x = temp.x + dx[dir];
                int dis_y = temp.y + dy[dir];
                if(dis_x < 0 || dis_x >= n || dis_y < 0 || dis_y >= n || matrix[dis_y][dis_x] == -1 || matrix_visited[dis_y][dis_x])
                    continue;

                matrix_visited[dis_y][dis_x] = true;

                if(matrix[dis_y][dis_x] == 0){
                    cnt++;
                    if(cnt == count0){
                        return temp.time+1;
                    }
                }
                queue.offer(new virus(dis_x, dis_y, temp.time+1));
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        matrix = new int[N][N];
        visited = new boolean[10];
        virus_list = new ArrayList<>();

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                matrix[i][j] -= sc.nextInt();
                if(matrix[i][j] == 0){
                    count0++;
                }
                if(matrix[i][j] == -2){
                    virus_list.add(new virus( j, i, 0));
                }
            }
        }
        if(count0 == 0){
            System.out.println(0);
            return;
        }
        dfs(0,0,M);

        if(min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }
}
