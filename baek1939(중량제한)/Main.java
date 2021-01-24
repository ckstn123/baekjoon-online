import java.util.*;

public class Main {
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static int N;
    static ArrayList<bridge>[] bridges;
    static boolean[] visited;

    static class bridge{
        int num , weight;
        bridge(int n, int w){
            num = n;
            weight = w;
        }
    }
    static boolean bfs(int start,int end, int weight){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int island = queue.poll();
            if(island == end){
                return true;
            }
            for(bridge temp : bridges[island]){
                if(temp.weight >= weight && !visited[temp.num]){

                    visited[temp.num] = true;
                    queue.offer(temp.num);
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        bridges = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<N+1; i++){
            bridges[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            bridges[A].add(new bridge(B,C));
            bridges[B].add(new bridge(A,C));
            max = Math.max(max, C);
            min = Math.min(min, C);
        }
        int start = sc.nextInt();
        int end = sc.nextInt();

        int left = 1;
        int right = max;
        int mid = 0;
        int result = 0;
        while(left <= right){
            mid = (left + right)/2;
            Arrays.fill(visited, false);
            if(bfs(start,end,mid)){
                left = mid + 1;
                result = mid;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}
