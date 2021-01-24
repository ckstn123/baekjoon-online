import java.util.*;

public class Main {
    static int n;
    static int INF = Integer.MAX_VALUE-1;
    static ArrayList<edge>[] matrix;
    static int[] distance;
    static int[][] check;
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
                    check[temp.end][start] = node;
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        distance = new int[n+1];
        matrix = new ArrayList[n+1];
        check = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            distance[i] = INF;
            matrix[i] = new ArrayList<edge>();
        }
        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            matrix[a].add(new edge(b,c));
            matrix[b].add(new edge(a,c));
        }

        for(int i = 1; i<=n; i++){
            dijkstr(i);
            Arrays.fill(distance, INF);
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(i == j){
                    System.out.print("- ");
                    continue;
                }

                System.out.print(check[i][j] + " ");
            }
            System.out.println();
        }
    }
}
