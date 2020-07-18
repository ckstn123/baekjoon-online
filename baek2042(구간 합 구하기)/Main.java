import java.util.Scanner;

public class Main {
    static long[] array;
    static long[] stree;

    static long init(int node, int start, int end){
        if(start == end){
            return stree[node] = array[start];
        }
        int mid = (start+end)/2;
        return stree[node] = init(node*2, start, mid) + init(node*2 + 1, mid + 1, end);
    }
    static long sum(int node, int start, int end, int left, long right){
        if(right < start || left > end){
            return 0;
        }
        else if(left <= start && right >= end){
            return stree[node];
        }
        else {
            int mid = (start+end)/2;
            return sum(node*2, start, mid, left, right) + sum(node*2 + 1, mid+1, end, left, right);
        }
    }

    static void update(int node, int index, long diff, int start, int end){
        if(index < start || index > end){
            return;
        }

        stree[node] += diff;

        if(start != end) {
            int mid = (start + end) / 2;
            update(node * 2, index, diff, start, mid);
            update(node * 2 + 1, index, diff, mid + 1, end);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        array = new long[N];
        stree = new long[N*4];
        for(int i = 0; i<N; i++){
            array[i] = sc.nextLong();
        }
        init(1, 0, N-1);
        for(int i = 0; i<M+K; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextLong();
            if(a == 1){
                long diff = c - array[b-1];
                array[b-1] = c;
                update(1, b-1, diff, 0, N-1);
            }
            else if(a == 2){
                System.out.println(sum(1,0, N-1, b-1, c-1));
            }
        }
    }
}
