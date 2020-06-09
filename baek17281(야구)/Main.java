import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] order = new int[9];
    static boolean[] visited = new boolean[9];
    static int[][] matrix;
    static int N;
    static int max = 0;
    void select(int count){
        if(count == 9){
            solve();
            return;
        }

        if(count == 3){
            count = count+1;
        }

        for(int i = 1; i<9; i++){
            if(!visited[i]){
                visited[i] = true;
                order[count] = i;
                select(count+1);
                visited[i] = false;
            }
        }
    }

    void solve(){
        int[] position = new int[3]; //각 루마다 주자가 있는지
        int score = 0;
        int count = 0;
        int out = 0;
        for(int i = 0; i<N; i++){
            out = 0;
            Arrays.fill(position,0);
            while(out < 3){
                if(matrix[i][order[count]] == 0)
                    out++;
                else if(matrix[i][order[count]] == 4){
                    score++;
                    for(int j = 0; j<3; j++){
                        if(position[j] == 1){
                            score++;
                            position[j] = 0;
                        }
                    }
                }
                else{
                    for(int t = 2; t>=0; t--){
                        if(position[t] == 1){
                            if(t + matrix[i][order[count]] >= 3){
                                score++;
                            }
                            else {
                                position[t + matrix[i][order[count]]] = 1;
                            }
                            position[t] = 0;
                        }
                    }
                    position[matrix[i][order[count]]-1] = 1;
                }
                count = (count+1)%9;
            }
        }
        if(max < score)
            max = score;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        matrix = new int[N][9];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<9; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        order[3] = 0;
        visited[0] = true;

        main.select(0);
        System.out.println(max);
    }
}
