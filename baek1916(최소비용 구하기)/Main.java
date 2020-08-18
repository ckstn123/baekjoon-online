import java.util.*;

public class Main {
    static int INF = Integer.MAX_VALUE-1;
    static ArrayList<edge>[] matrix;
    static int[] distance;

    static class edge{
        int end, cost;
        edge(int e, int c){
            end = e;
            cost = c;
        }
    }
    static Comparator<edge> comp = (a, b) -> {
        return a.cost - b.cost;
    };

    static void dijkstra(int x){
        Queue<edge> pq = new PriorityQueue<>(comp);
        distance[x] = 0;
        pq.offer(new edge(x, 0));
        while(!pq.isEmpty()){
            int node = pq.peek().end;
            int cost = pq.peek().cost;
            pq.poll();
            for(int i = 0; i<matrix[node].size(); i++){
                int next = matrix[node].get(i).end;
                int temp_cost = matrix[node].get(i).cost;
                if(distance[next] > temp_cost + cost){
                    distance[next] = temp_cost + cost;
                    pq.offer(new edge(next, distance[next]));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        matrix = new ArrayList[N+1];
        distance = new int[N+1];
        for(int i = 1; i<=N; i++){
            matrix[i] = new ArrayList<>();
            distance[i] = INF;
        }
        for(int i = 0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            matrix[a].add(new edge(b,c));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        dijkstra(start);
        System.out.println(distance[end]);
    }
}
