import java.util.*;

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
        int tc = sc.nextInt();
        for(int test = 0; test<tc; test++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int W = sc.nextInt();
            boolean flag = false;
            int[] cycle = new int[N+1];
            int[] dist = new int[N+1];
            boolean[] visited = new boolean[N+1];

            ArrayList<edge>[] matrix = new ArrayList[N+1];
            for(int i = 1; i<=N; i++){
                matrix[i] = new ArrayList<>();
            }
            for(int i = 0; i<M; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();

                matrix[a].add(new edge(b,c));
                matrix[b].add(new edge(a,c));
            }

            for(int i = 0; i<W; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                matrix[a].add(new edge(b,-c));
            }
            for(int i = 1; i<=N; i++) {
                if(flag)
                    break;
                Arrays.fill(dist, INF);
                dist[i] = 0;
                cycle = new int[N+1];
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int start = queue.poll();
                    flag = false;
                    visited[start] = false;
                    for (edge next : matrix[start]) {
                        if (dist[next.end] > dist[start] + next.cost) {
                            dist[next.end] = dist[start] + next.cost;
                            if (!visited[next.end]) {
                                visited[next.end] = true;
                                queue.offer(next.end);
                            }
                            cycle[next.end]++;
                            if (cycle[next.end] >= N) {
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
            }
            if(flag){
                System.out.println("YES");
            }
            else
                System.out.println("NO");
        }
    }
}