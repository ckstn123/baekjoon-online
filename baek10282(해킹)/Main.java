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

    static Comparator<edge> comp = (a,b) -> {
        return a.cost - b.cost;
    };
    static void dijkstr(int start){
        Queue<edge> pq = new PriorityQueue<>(comp);
        distance[start] = 0;
        pq.offer(new edge(start, 0));
        while(!pq.isEmpty()){
            int node = pq.peek().end;
            int cost = pq.peek().cost;
            pq.poll();
            for(edge temp : matrix[node]){
                if(distance[temp.end] > cost + temp.cost){
                    distance[temp.end] = cost + temp.cost;
                    pq.offer(new edge(temp.end, distance[temp.end]));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 0; tc<T; tc++){
            int n = sc.nextInt();
            int d = sc.nextInt();
            int c = sc.nextInt();
            int count = 0;
            int max = 0;
            distance = new int[n+1];
            matrix = new ArrayList[n+1];
            for(int i = 1; i<=n; i++){
                distance[i] = INF;
                matrix[i] = new ArrayList<edge>();
            }

            for(int i = 0; i<d; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int s = sc.nextInt();
                matrix[b].add(new edge(a,s));
            }

            dijkstr(c);
            for(int i = 1; i<=n; i++){
                if(distance[i] < INF){
                    count++;
                    max = Math.max(max, distance[i]);
                }
            }
            System.out.println(count + " " + max);
        }
    }
}
