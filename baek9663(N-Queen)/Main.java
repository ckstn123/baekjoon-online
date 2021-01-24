import java.util.Scanner;

public class Main {
    static int N;
    static int result = 0;
    static int[][] matrix;
    static boolean check(int x, int y){
        //가로세로 확인
        for(int i = 0; i<N; i++){
            if(matrix[y][i] == 1)
                return true;
            if(matrix[i][x] == 1)
                return true;
        }

        //대각선 확인
        for (int i = 1; i<N; i++){
            if(x + i < N && y+i < N){
                if(matrix[y+i][x+i] == 1){
                    return true;
                }
            }
            if(x + i < N && y-i >= 0){
                if(matrix[y-i][x+i] == 1){
                    return true;
                }
            }
            if(x-i >= 0 && y+i < N){
                if(matrix[y+i][x-i] == 1){
                    return true;
                }
            }
            if(x-i >= 0 && y-i >= 0){
                if(matrix[y-i][x-i] == 1){
                    return true;
                }
            }
        }
        return false;
    }
    static void dfs(int count){
        if(count == N){
            result++;
            return;
        }

        for(int i = 0; i<N; i++){
            if(!check(i,count)){
                matrix[count][i] = 1;
                dfs(count+1);
                matrix[count][i] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        matrix = new int[N][N];
        dfs(0);
        System.out.println(result);
    }
}
