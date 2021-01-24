import java.util.*;
import java.io.*;

public class Main {
    static int height;
    static int[] depth;
    static int[][] parents;
    static boolean[] visited;
    static ArrayList<Integer>[] matrix;

    static void dfs(int x, int dep){
        visited[x] = true;
        depth[x] = dep;
        for(int next : matrix[x]){
            if(!visited[next]){
                dfs(next,dep+1);
                parents[next][0] = x;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        height = (int) Math.ceil(Math.log(N) / Math.log(2));
        parents = new int[N+1][height];
        depth = new int[N+1];
        visited = new boolean[N+1];
        matrix = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            matrix[i] = new ArrayList<>();
        }
        for(int i = 0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a].add(b);
            matrix[b].add(a);
        }

        dfs(1,0);

        //부모 설정
        for(int i = 0; i<height-1; i++){
            for(int j = 2; j<=N; j++){
                parents[j][i+1] = parents[parents[j][i]][i];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(depth[a] < depth[b]){
                int temp = b;
                b = a;
                a = temp;
            }
            for (int j = height-1; j>=0; j--) {
                int diff = depth[a] - depth[b];

                if ((diff&(1<<j)) !=0) {
                    a = parents[a][j];
                }
            }

            if(a != b){
                for(int j = height-1; j>=0; j--){
                    if(parents[a][j] == parents[b][j]){
                        continue;
                    }
                        a = parents[a][j];
                        b = parents[b][j];
                }
                a = parents[a][0];
            }

            System.out.println(a);
        }

    }
}
