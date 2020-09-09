import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int sq;
    static int[] numbers;
    static int[] count;
    static int[] result;
    static int cnt = 0;
    static class query implements Comparable<query>{
        int start, end, idx;
        query(int s, int e, int i){
            start = s;
            end = e;
            idx = i;
        }

        @Override
        public int compareTo(query o) {
            if((start - 1)/sq != (o.start - 1)/sq)
                return (start - 1)/sq - (o.start - 1)/sq;
            return end - o.end;
        }
    }
    static void go_query(query prev, query cur){
        int s = prev.start;
        int left =  cur.start;
        int e = prev.end;
        int right = cur.end;

        for(int i = s; i<left; i++){
            erase(numbers[i]);
        }
        for(int i = s-1; i>=left; i--){
            add(numbers[i]);
        }
        for(int i = e+1; i<=right; i++){
            add(numbers[i]);
        }
        for(int i = e; i>right; i--){
            erase(numbers[i]);
        }
    }
    static void add(int index){
        if(++count[index] == 1){
            cnt++;
        }
    }

    static void erase(int index){
        if(--count[index] == 0){
            cnt--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        numbers = new int[N+1];
        count = new int[1000001];
        for(int i = 1; i<=N; i++){
            numbers[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        result = new int[M+1];
        query[] queries = new query[M+1];
        sq = (int)Math.sqrt(N);
        for(int i = 1; i<=M; i++){
            int left = sc.nextInt();
            int right = sc.nextInt();
            queries[i] = new query(left, right, i);
        }
        queries[0] = new query(0,0,0);
        Arrays.sort(queries);

        for(int i = 1; i<=M; i++){
            go_query(queries[i-1], queries[i]);
            result[queries[i].idx] = cnt;
        }

        for(int i = 1; i<=M; i++)
            System.out.println(result[i]);
    }
}
