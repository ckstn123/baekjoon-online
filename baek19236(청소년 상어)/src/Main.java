import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int max = 0;
    static int[] dx = {0,-1,-1,-1,0,1,1,1};
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int[][] matrix;
    static boolean[] isAlive;
    static fish[] list;
    static class fish{
        int x,y,dir;

        public fish(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static void dfs(int x, int y, int num, int dir){
        int[][] temp_matrix = new int[4][4];
        for(int i = 0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                temp_matrix[i][j] = matrix[i][j];
            }
        }
        fish[] temp_list = new fish[17];
        for(int i = 1; i<17; i++){
            temp_list[i] = list[i];
        }

        for(int i = 1; i<17; i++){
            if(!isAlive[i])
                continue;

            for(int j = 0; j<8; j++) {
                int temp_dir = (list[i].dir + j)%8;
                int dis_x = list[i].x + dx[temp_dir];
                int dis_y = list[i].y + dy[temp_dir];

                if (dis_x < 0 || dis_x >= 4 || dis_y < 0 || dis_y >= 4 || matrix[dis_y][dis_x] == -1) {
                    continue;
                }
                matrix[list[i].y][list[i].x] = 0;

                if(matrix[dis_y][dis_x] == 0){
                    list[i].x = dis_x;
                    list[i].y = dis_y;
                }
                else {
                    fish temp = list[matrix[dis_y][dis_x]];
                    temp.x = list[i].x;
                    temp.y = list[i].y;
                    matrix[list[i].y][list[i].x] = matrix[dis_y][dis_x];
                    list[i].x = dis_x;
                    list[i].y = dis_y;
                }
                matrix[dis_y][dis_x] = i;
                list[i].dir = temp_dir;
                break;
            }
        }
        print();
        for(int t = 1; t<4; t++){

            int dis_x = x + dx[dir]*t;
            int dis_y = y + dy[dir]*t;

            if(dis_x < 0 || dis_x >= 4 || dis_y < 0 || dis_y >= 4)
                break;

            if(matrix[dis_y][dis_x] == 0)
                continue;

            matrix[y][x] = 0;
            int eat = matrix[dis_y][dis_x];
            isAlive[eat] = false;
            matrix[dis_y][dis_x] = -1;
            dfs(dis_x,dis_y, num + eat, list[eat].dir);
            isAlive[eat] = true;
            matrix[dis_y][dis_x] = eat;
            matrix[y][x] = -1;

        }
        for(int i = 0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = temp_matrix[i][j];
            }
        }

        for(int i = 1; i<17; i++){
            list[i] = temp_list[i];
        }

        max = Math.max(max, num);
    }
    public static void print() {
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        matrix = new int[4][4];
        list = new fish[17];
        isAlive = new boolean[17];
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                int num = sc.nextInt();
                int dir = sc.nextInt()-1;
                matrix[i][j] = num;
                list[num] = new fish(j,i,dir);
            }
        }
        Arrays.fill(isAlive, true);
        int eat = matrix[0][0];
        isAlive[eat] = false;
        matrix[0][0] = -1;
        dfs(0,0,eat,list[eat].dir);
        System.out.println(max);
    }
}