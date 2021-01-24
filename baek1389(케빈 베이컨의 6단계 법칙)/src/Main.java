import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int result = 0;
        int[][] matrix = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            Arrays.fill(matrix[i], 10000);
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            matrix[A][B] = 1;
            matrix[B][A] = 1;
        }

        for(int k = 1; k<=N; k++){
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=N; j++){
                    matrix[i][j] = Math.min(matrix[i][k] + matrix[k][j], matrix[i][j]);
                }
            }
        }

        for(int i = 1; i<=N; i++){
            int sum = 0;
            for(int j = 1; j<=N; j++){
                if(i != j){
                    sum += matrix[i][j];
                }
            }
            if(min > sum){
                min = sum;
                result = i;
            }
        }

        System.out.println(result);
    }
}
