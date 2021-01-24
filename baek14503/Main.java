import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int r;
    static int c;
    static int d;
    static int result;
    static int[][] matrix;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};


    public static void solve(int x, int y){

        while(true){
            int check = 0;

            for(int dir = 0; dir<4; dir++) {
                int dis_x;
                int dis_y;
                if (d - 1 < 0) {
                    d = 4 + d -1;

                } else {
                    d = d - 1;
                }
                dis_x = x + dx[d];
                dis_y = y + dy[d];

                if (dis_x >= 0 && dis_x < M && dis_y >= 0 && dis_y < N) {
                    if (matrix[dis_x][dis_y] == 0) { //왼쪽 방향으로 가서 청소
                        matrix[dis_x][dis_y] = 2;
                        x = dis_x;
                        y = dis_y;
                        check = 1;
                        break;
                    }
                    else if(matrix[dis_x][dis_y] == 1 || matrix[dis_x][dis_y] == 2)
                        continue;
                }
            }

            if(check == 0){ //네 방향 모두 청소가 이미 되어있거나 벽인 경우
                if(matrix[x + dx[(d+2)%4]][y + dy[(d+2)%4]] == 2){
                    x = x + dx[(d+2)%4];
                    y = y + dy[(d+2)%4];
                }
                //뒤쪽 방향이 벽
                else if(matrix[x + dx[(d+2)%4]][y + dy[(d+2)%4]] == 1){
                    return;
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d =sc.nextInt();
        matrix = new int[M][N];

        for(int j = 0; j<N; j++){
            for(int i = 0; i<M; i++){
                matrix[i][j] = sc.nextInt();
            }
        }
        matrix[c][r] = 2; //처음 시작 위치 청소
        solve(c,r);
        for(int j = 0; j<N; j++){
            for(int i = 0; i<M; i++){
                if(matrix[i][j] == 2)
                    result++;
            }
        }
        System.out.println(result);
    }
}
