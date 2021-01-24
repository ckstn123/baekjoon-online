import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int INF = 987654321;
    static class edge{
        int end, cost;
        edge(int e, int c){
            end = e;
            cost = c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] dist = new long[N+1];
        ArrayList<edge>[] matrix = new ArrayList[N+1];
        for(int i = 1 ; i<=N; i++){
            matrix[i] = new ArrayList<>();
        }
        for(int i = 0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            matrix[a].add(new edge(b,c));
        }
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for(int i = 0 ; i<N; i++){
            for(int j = 1; j<=N; j++){
                for(edge temp : matrix[j]){
                    if(dist[j] != INF && dist[temp.end] > dist[j] + temp.cost){
                        dist[temp.end] = dist[j] + temp.cost;

                        if(i == N-1){
                            System.out.println(-1);
                            return;
                        }
                    }
                }
            }
        }

        for(int i = 2; i<=N; i++){
            if(dist[i] == INF)
                System.out.println(-1);
            else
                System.out.println(dist[i]);
        }
    }
}
