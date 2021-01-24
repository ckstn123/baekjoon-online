import java.util.*;

public class Main {
    static int[] dist;
    static int[] answer;
    static ArrayList<Integer>[] matrix;
    static Queue<subject> queue = new LinkedList<>();
    static class subject{
        int num, semester;

        public subject(int num, int semester) {
            this.num = num;
            this.semester = semester;
        }
    }

    static void bfs(){
        while(!queue.isEmpty()){
            subject cur = queue.poll();
            answer[cur.num] = Math.max(answer[cur.num], cur.semester);
            for(int next : matrix[cur.num]){
                dist[next]--;
                if(dist[next] == 0)
                    queue.offer(new subject(next, cur.semester+1));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        dist = new int[n];
        answer = new int[n];
        matrix = new ArrayList[n];
        for(int i = 0; i<n; i++){
            matrix[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            matrix[a].add(b);
            dist[b]++;
        }

        for(int i = 0; i<n; i++){
            if(dist[i] == 0){
                queue.offer(new subject(i, 1));
            }
        }
        Arrays.fill(answer,1);
        bfs();
        for(int num : answer){
            System.out.print(num + " ");
        }
    }
}
