import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int sq;
    static int C;
    static int[] result;
    static int[] hat;
    static int[] count;
    static class query implements Comparable<query>{
        int start, end, idx;
        public query(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }

        @Override
        public int compareTo(query o) {
            if((start-1)/sq != (o.start-1)/sq){
                return (start - 1)/sq - (o.start - 1)/sq;
            }
            return end - o.end;
        }
    }

    static void add(int index){
        count[hat[index]]++;
    }

    static void erase(int index){
        count[hat[index]]--;
    }
    static void go_query(query prev, query cur){
        int s = prev.start;
        int left= cur.start;
        int e = prev.end;
        int right = cur.end;

        for(int i = s; i<left; i++){
            erase(i);
        }
        for(int i = s-1; i>=left; i--){
            add(i);
        }
        for(int i = e+1; i<=right; i++){
            add(i);
        }
        for(int i = e; i>right; i--){
            erase(i);
        }
        for(int i = 1; i<=C; i++){
            if(count[i] > (cur.end - cur.start + 1)/2){
                result[cur.idx] = i;
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        C = sc.nextInt();
        hat = new int[N+1];
        count = new int[C+1];
        for(int i = 1; i<=N; i++){
            hat[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        result = new int[M+1];
        sq = (int)Math.sqrt(N);
        query[] queries = new query[M+1];
        for(int i = 1; i<=M; i++){
            int left = sc.nextInt();
            int right = sc.nextInt();
            queries[i] = new query(left, right, i);
        }
        queries[0] = new query(0,0,0);
        Arrays.sort(queries);

        for(int i = 1; i<=M; i++){
            query prev = queries[i-1];
            query cur= queries[i];
            go_query(prev, cur);

        }
        for(int i = 1; i<=M; i++){
            if(result[i] != 0)
                System.out.println("yes " + result[i]);
            else
                System.out.println("no");
        }
    }
}
