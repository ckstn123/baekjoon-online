import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int half;
    static int[][] matrix;
    static void rotate(){
        int[][] temp_matrix = new int[N][M];

        for(int i = 0; i<half; i++) {
            int dir = 0;
            int x = i;
            int y = i;
            while(dir < 4){

                int dis_x = x + dx[dir];
                int dis_y = y + dy[dir];

                if(dir == 0){
                    if(dis_y >= N - i){
                        dir++;
                    }
                    else {
                        temp_matrix[dis_y][dis_x] = matrix[y][x];
                        x = dis_x;
                        y = dis_y;
                    }
                }
                else if(dir == 1){
                    if(dis_x >= M - i){
                        dir++;
                    }
                    else {
                        temp_matrix[dis_y][dis_x] = matrix[y][x];
                        x = dis_x;
                        y = dis_y;
                    }
                }
                else if(dir == 2){
                    if(dis_y < i){
                        dir++;
                    }
                    else {
                        temp_matrix[dis_y][dis_x] = matrix[y][x];
                        x = dis_x;
                        y = dis_y;
                    }
                }
                else {
                    if(dis_x < i){
                        dir++;
                    }
                    else {
                        temp_matrix[dis_y][dis_x] = matrix[y][x];
                        x = dis_x;
                        y = dis_y;
                    }
                }
            }
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                matrix[i][j] = temp_matrix[i][j];
            }
        }
    }

    static void print(){
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        half = Math.min(N,M)/2;
        matrix = new int[N][M];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<R; i++){
            rotate();
        }
        print();

    }
}
