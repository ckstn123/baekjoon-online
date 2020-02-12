import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static class block{
        int x;
        int y;
        block(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] matrix;
    static int[][] visited;
    static Stack<block> stack = new Stack<>();
    static int max = 0;
    static int N;
    static int M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void recursive(int x, int y, int count, int sum){
        sum += matrix[x][y];

        //종료부
        if(count == 3){
            if(max < sum)
                max = sum;
            return;
        }
        stack.push(new block(x,y));
        visited[x][y] = 1;
        for(int i = 0; i<stack.size(); i++){
            for(int dir = 0; dir<4; dir++){

                int temp_x = stack.get(i).x + dx[dir];
                int temp_y = stack.get(i).y + dy[dir];
                if(temp_x >= 0 && temp_x < M && temp_y >= 0 && temp_y < N){
                    if(visited[temp_x][temp_y] == 0){
                        recursive(temp_x,temp_y,count + 1, sum);//분할부
                    }
                }
            }
        }

        visited[x][y] = 0;
        stack.pop();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        matrix = new int[M][N];
        visited = new int[M][N];
        for(int j = 0; j<N; j++){
            for(int i = 0; i<M; i++){
                matrix[i][j] = sc.nextInt();
            }
        }

        for(int j = 0; j<N; j++){
            for(int i = 0; i<M; i++){
                recursive(i,j,0,0);
            }
        }

        System.out.println(max);
    }
}
