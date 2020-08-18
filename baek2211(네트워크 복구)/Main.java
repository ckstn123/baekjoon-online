import java.util.*;

public class Main {
    static int[] parent;
    static int[] distance;
    static ArrayList<edge>[] matrix;
    static int INF = 987654321;
    static class edge{
        int end, cost;
        edge(int e, int c){
            end = e;
            cost = c;
        }
    }
    static Comparator<edge> comp = (a,b) -> {
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
                if(distance[matrix[node].get(i).end] > matrix[node].get(i).cost + cost){
                    distance[matrix[node].get(i).end] = matrix[node].get(i).cost + cost;
                    parent[matrix[node].get(i).end] = node;
                    pq.offer(new edge(matrix[node].get(i).end, distance[matrix[node].get(i).end]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n+1];
        distance = new int[n+1];
        matrix = new ArrayList[n+1];

        for(int i = 1; i<=n; i++){
            distance[i] = INF;
            matrix[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            matrix[a].add(new edge(b,c));
            matrix[b].add(new edge(a,c));
        }

        dijkstra(1);
        System.out.println(n-1);
        for(int i = 2; i<=n; i++){
            System.out.println(parent[i] + " " + i);
        }

    }
}