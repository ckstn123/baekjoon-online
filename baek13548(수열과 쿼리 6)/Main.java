import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int sq;
    static int[] numbers;
    static int[] count;
    static int[] max_count;
    static int[] result;
    static int max = 0;
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

        for(int i = s-1; i>=left; i--){
            add(numbers[i]);
        }
        for(int i = e+1; i<=right; i++){
            add(numbers[i]);
        }
        for(int i = s; i<left; i++){
            erase(numbers[i]);
        }
        for(int i = e; i>right; i--){
            erase(numbers[i]);
        }
    }
    static void add(int index){
        max_count[count[index]]--;
        count[index]++;
        max_count[count[index]]++;
        max = Math.max(max, count[index]);

    }

    static void erase(int index){
        max_count[count[index]]--;
        count[index]--;
        max_count[count[index]]++;
        if(max_count[max] == 0)
            max--;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        numbers = new int[N+1];
        count = new int[100001];
        max_count = new int[100001];
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
        max_count[0] = N;
        for(int i = queries[1].start; i<=queries[1].end; i++){
            add(numbers[i]);
        }
        result[queries[1].idx] = max;
        for(int i = 2; i<=M; i++){
            go_query(queries[i-1], queries[i]);
            result[queries[i].idx] = max;
        }

        for(int i = 1; i<=M; i++)
            System.out.println(result[i]);
    }
}
