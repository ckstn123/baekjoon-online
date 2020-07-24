import java.util.Scanner;

public class Main {
    static long[] array;
    static long[] min_stree;

    static long min_init(int node, int start, int end){
        if(start == end){
            return min_stree[node] = array[start];
        }
        int mid = (start+end)/2;
        return min_stree[node] = Math.min(min_init(node*2, start, mid) , min_init(node*2 + 1, mid + 1, end));
    }

    static long min_check(int node, int start, int end, int left, int right){
        if(left > end || right < start){
            return Long.MAX_VALUE;
        }
        else if(left <= start && right >= end){
            return min_stree[node];
        }
        int mid = (start+end)/2;
        return Math.min(min_check(node*2, start, mid, left, right), min_check(node*2 + 1, mid + 1, end, left, right));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        array = new long[N];
        min_stree = new long[N*4];

        for(int i = 0; i<N; i++){
            array[i] = sc.nextLong();
        }
        min_init(1, 0, N-1);

        for(int i = 0; i<M; i++){
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            System.out.println(min_check(1, 0, N-1, a, b));
        }
    }
}
