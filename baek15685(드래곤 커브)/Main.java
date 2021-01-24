import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] matrix;
    static void curve(int x, int y, int d, int g){
        ArrayList<Integer> list = new ArrayList<>();
        matrix[y][x] = 1;
        list.add(d);
        x = x + dx[d];
        y = y + dy[d];
        matrix[y][x] = 1;

        for(int i = 0; i<g; i++){
            int size = list.size();
            for(int t = size-1; t>=0; t--){
                d = list.get(t);
                d = (d+1)%4;
                x += dx[d];
                y += dy[d];
                matrix[y][x] = 1;
                list.add(d);
            }
        }
    }

    static int check(){
        int count = 0;
        for(int i = 0; i<100; i++){
            for(int j = 0; j<100; j++){
                if(matrix[i][j] == 1 && matrix[i][j+1] == 1 && matrix[i+1][j] == 1 && matrix[i+1][j+1] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        matrix = new int[101][101];
        for(int i = 0; i<N;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();
            curve(x,y,d,g);
        }
        System.out.println(check());
    }
}
