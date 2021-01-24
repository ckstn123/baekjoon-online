import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dist = new int[n+1];
        ArrayList<Integer>[] matrix = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            matrix[i] = new ArrayList<>();
        }
        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            matrix[a].add(b);
            dist[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            if(dist[i] == 0){
                queue.offer(i);
                System.out.print(i + " ");
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : matrix[cur]){
                dist[next]--;
                if(dist[next] == 0){
                    System.out.print(next + " ");
                    queue.offer(next);
                }

            }
        }
    }
}
