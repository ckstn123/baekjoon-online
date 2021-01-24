import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N;
    static int M;

    static int max = 0;
    static int[][] matrix;
    static int[][] temp_matrix;
    static int[][] visited;
    static Queue<block> queue = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static class block{
        int x;
        int y;
        block(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void copy(int[][] array, int[][] new_array){
        for(int j = 0; j<N; j++) {
            for (int i = 0; i < M; i++) {
                new_array[i][j] = array[i][j];
            }
        }
    }
    public static void wall(int x, int y, int count){
        if(count==3){
            virus();
            return;
        }
        for(int j = y; j<N; j++, x=0){
            for(int i = x; i<M; i++){
                if(matrix[i][j] == 0){
                    matrix[i][j] = 1;
                    wall(i,j,count+1);
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void virus(){
        int safe_num = 0;
        copy(matrix, temp_matrix);
        for(int j = 0; j<N; j++){
            for(int i = 0; i<M; i++){
                if(matrix[i][j] == 2){
                    queue.add(new block(i,j));
                }
            }
        }

        while (!queue.isEmpty()){
            block temp = queue.poll();
            for(int dir = 0; dir<4; dir++) {
                int dis_x = temp.x + dx[dir];
                int dis_y = temp.y + dy[dir];
                if(dis_x >= 0 && dis_x < M && dis_y >= 0 && dis_y < N){
                    if(matrix[dis_x][dis_y] == 0){
                        matrix[dis_x][dis_y] = 2;
                        queue.add(new block(dis_x,dis_y));

                    }
                }
            }
        }
        for(int j = 0; j<N; j++){
            for(int i = 0; i<M; i++){
                if(matrix[i][j] == 0){
                    safe_num++;
                }
            }
        }
        copy(temp_matrix,matrix);
        max = Math.max(max, safe_num);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        matrix = new int[M][N];
        temp_matrix = new int[M][N];

        for(int j = 0; j<N; j++){
            for(int i = 0; i<M; i++){
                matrix[i][j] = sc.nextInt();
                temp_matrix[i][j] = matrix[i][j];

            }
        }
        for(int j = 0; j<N; j++) {
            for (int i = 0; i < M; i++) {
                if(matrix[i][j] == 0){
                    wall(i,j,0);
                }
            }
        }

        System.out.println(max);
    }
}
