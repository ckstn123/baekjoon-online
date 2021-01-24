import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] parents;
    static boolean[] visited;
    static int find(int x){
        if(visited[x]){
            return x;
        }
        visited[x] = true;
        if(x == 1){
            return 1;
        }
        return find(parents[x]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        parents = new int[N+1];
        ArrayList<Integer>[] matrix = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            matrix[i] = new ArrayList<>();
        }
        for(int i = 0; i<N-1; i++){
            line = br.readLine();
            int a = Integer.parseInt(line.split(" ")[0]);
            int b = Integer.parseInt(line.split(" ")[1]);
            matrix[a].add(b);
            matrix[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while(!queue.isEmpty()){
            int parent = queue.poll();
            for(int next : matrix[parent]){
                if(parents[next] == 0){
                    parents[next] = parent;
                    queue.offer(next);
                }
            }
        }
        line = br.readLine();
        int M = Integer.parseInt(line);
        for(int i = 0; i<M; i++){
            line = br.readLine();
            visited = new boolean[N+1];
            int a = Integer.parseInt(line.split(" ")[0]);
            find(a);
            int b = Integer.parseInt(line.split(" ")[1]);
            System.out.println(find(b));
        }
    }
}
