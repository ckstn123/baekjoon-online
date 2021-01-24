import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int INF = 10000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(matrix[i][j] == 0)
                    matrix[i][j] = INF;
            }
        }

        for(int k = 0; k<N; k++){
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    matrix[i][j] = Math.min(matrix[i][k] + matrix[k][j], matrix[i][j]);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        while(st.hasMoreTokens()){
            int end = Integer.parseInt(st.nextToken()) - 1;
            if(matrix[start][end] >= INF && start != end){
                System.out.println("NO");
                return;
            }
            start = end;
        }

        System.out.println("YES");
    }
}
