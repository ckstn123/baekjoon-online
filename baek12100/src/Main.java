import java.util.Scanner;

public class Main {
    static int result = 0;
    static class block{
        int num, col;
        block(int n, int c){
            num = n;
            col = c;
        }
    }
    public static block[][] deepCopy(block[][] src){
        if(src == null) return null;
        block[][] dest = new block[src.length][src[0].length];

        for(int i=0; i<src.length; i++) {
            for(int j=0; j<src[i].length; j++)
                dest[i][j] = new block(src[i][j].num, src[i][j].col);
        }
        return dest;
    }
    public static void move(int N, block[][] matrix, int dir, int count){
        for(int i = 0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j].col = 0;
            }
        }
        if(dir == 0){//오른쪽
            for(int i = 0; i<N; i++) {
                for (int j = N-2; j >= 0; j--) {
                    int x = j + 1;
                    if(matrix[i][j].num == 0){
                        continue;
                    }
                    while(x < N){

                        if(matrix[i][x].num != 0){
                            if(matrix[i][x].num == matrix[i][j].num && matrix[i][x].col != count){
                                matrix[i][x].num += matrix[i][j].num;
                                matrix[i][x].col = count;
                                matrix[i][j].num = 0;
                                break;
                            }
                            else{
                                if(x-1 != j){
                                    matrix[i][x-1].num = matrix[i][j].num;
                                    matrix[i][j].num = 0;
                                }
                                break;
                            }
                        }
                        if(x == N-1 && matrix[i][x].num == 0){
                            matrix[i][x].num = matrix[i][j].num;
                            matrix[i][j].num = 0;
                        }
                        x++;
                    }

                }
            }
        }
        else if(dir == 1){//아래
            for(int i = 0; i<N; i++) {
                for (int j = N-2; j >= 0; j--) {
                    int y = j + 1;
                    if(matrix[j][i].num == 0){
                        continue;
                    }
                    while(y < N){

                        if(matrix[y][i].num != 0){
                            if(matrix[y][i].num == matrix[j][i].num && matrix[y][i].col != count){
                                matrix[y][i].num += matrix[j][i].num;
                                matrix[y][i].col = count;
                                matrix[j][i].num = 0;
                                break;
                            }
                            else{
                                if(y-1 != j) {
                                    matrix[y - 1][i].num = matrix[j][i].num;
                                    matrix[j][i].num = 0;
                                }
                                break;
                            }
                        }
                        if(y == N-1 && matrix[y][i].num == 0){
                            matrix[y][i].num = matrix[j][i].num;
                            matrix[j][i].num = 0;
                        }
                        y++;
                    }

                }
            }
        }
        else if(dir == 2){//왼쪽
            for(int i = 0; i<N; i++) {
                for (int j = 1; j < N; j++) {
                    int x = j - 1;
                    if(matrix[i][j].num == 0){
                        continue;
                    }
                    while(x >= 0){

                        if(matrix[i][x].num != 0){
                            if(matrix[i][x].num == matrix[i][j].num && matrix[i][x].col != count){
                                matrix[i][x].num += matrix[i][j].num;
                                matrix[i][x].col = count;
                                matrix[i][j].num = 0;
                                break;
                            }
                            else{
                                if(x+1 != j) {
                                    matrix[i][x + 1].num = matrix[i][j].num;
                                    matrix[i][j].num = 0;
                                }
                                break;
                            }
                        }
                        if(x == 0 && matrix[i][x].num == 0){
                            matrix[i][x].num = matrix[i][j].num;
                            matrix[i][j].num = 0;
                        }
                        x--;
                    }

                }
            }
        }
        else{//아래쪽
            for(int i = 0; i<N; i++) {
                for (int j = 1; j < N; j++) {
                    int y = j - 1;
                    if(matrix[j][i].num == 0){
                        continue;
                    }
                    while(y >= 0){

                        if(matrix[y][i].num != 0){
                            if(matrix[y][i].num == matrix[j][i].num && matrix[y][i].col != count){
                                matrix[y][i].num += matrix[j][i].num;
                                matrix[y][i].col = count;
                                matrix[j][i].num = 0;
                                break;
                            }
                            else{
                                if(y+1 != j) {
                                    matrix[y + 1][i].num = matrix[j][i].num;
                                    matrix[j][i].num = 0;
                                }
                                break;
                            }
                        }
                        if(y == 0 && matrix[y][i].num == 0){
                            matrix[y][i].num = matrix[j][i].num;
                            matrix[j][i].num = 0;
                        }
                        y--;
                    }

                }
            }
        }
    }
    public static void recursive(int N, block[][] matrix, int count){
        if(count > 5){
            int max = 0;
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++) {
                    if(max < matrix[i][j].num){
                        max = matrix[i][j].num;
                    }
                }
            }
            if(result < max){
                result = max;
            }
            return;
        }

        for(int dir = 0; dir<4; dir++) {
            block[][] temp = deepCopy(matrix);

            move(N,matrix,dir,count);
            recursive(N, matrix, count + 1);
            matrix = deepCopy(temp);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        block[][] matrix = new block[N][N];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                matrix[i][j] = new block(sc.nextInt(), 0);
            }
        }
        recursive(N,matrix,1);
        System.out.println(result);
    }
}
