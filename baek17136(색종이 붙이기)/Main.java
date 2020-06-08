import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] matrix = new int[10][10];
    static int[] paper = new int[6];
    static int min = Integer.MAX_VALUE;

    public void paste(int x, int y, int size, int n){
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                matrix[y+i][x+j] = n;
            }
        }
    }

    public boolean check(int x, int y, int size){
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                if(x+j < 0 || x+j >= 10 || y+i < 0 || y+i >= 10 || matrix[y+i][x+j] == 0)
                    return false;
            }
        }
        return true;
    }

    public void dfs(int x, int y, int count){
        if(x == 10){
            dfs(0,y+1,count);
            return;
        }

        if(y >= 10){
            if(min > count){
                min = count;
            }
            return;
        }
        if(min <= count){
            return;
        }

        if(matrix[y][x] == 1){
            for(int i = 5; i>=1; i--){
                if(paper[i] > 0 && check(x,y,i)){
                    paste(x,y,i,0);
                    paper[i]--;
                    dfs(x+1,y,count+1);
                    paste(x,y,i,1);
                    paper[i]++;
                }
            }
        }
        else {
            dfs(x+1,y,count);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        Arrays.fill(paper,5);
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        main.dfs(0,0,0);
        if(min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }
}
