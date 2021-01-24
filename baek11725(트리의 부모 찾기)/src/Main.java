import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int[] parents = new int[N+1];
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

        for(int i = 2; i<=N; i++){
            System.out.println(parents[i]);
        }
    }
}
