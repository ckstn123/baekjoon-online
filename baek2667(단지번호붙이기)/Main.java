import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N;
    static int[][] matrix;
    static ArrayList<Integer> house_list = new ArrayList<>();
    static class house{
        int x,y;
        house(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static void bfs(int x, int y, int num){
        int count = 1;
        Queue<house> queue = new LinkedList<>();
        queue.offer(new house(x,y));
        matrix[y][x] = num;
        while(!queue.isEmpty()){
            house temp = queue.poll();
            for(int dir = 0; dir<4; dir++) {
                int dis_x = temp.x + dx[dir];
                int dis_y = temp.y + dy[dir];
                if (dis_x < 0 || dis_x >= N || dis_y < 0 | dis_y >= N || matrix[dis_y][dis_x] != -1)
                    continue;
                matrix[dis_y][dis_x] = num;
                queue.offer(new house(dis_x,dis_y));
                count++;
            }
        }
        house_list.add(count);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        for(int i = 0; i<N; i++){
            String str = br.readLine();
            for(int j = 0; j<N; j++){
                matrix[i][j] = str.charAt(j) - '0';
                if(matrix[i][j] == 1){
                    matrix[i][j] = -1;
                }
            }
        }

        for(int i = 0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if(matrix[i][j] == -1){
                    bfs(j,i,num);
                    num++;
                }
            }
        }
        Collections.sort(house_list);
        System.out.println(house_list.size());
        for(int count : house_list){
            System.out.println(count);
        }
    }
}
