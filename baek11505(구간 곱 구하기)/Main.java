import java.util.Scanner;

public class Main {
    static int N;
    static int[] array;
    static long[] segTree;
    static int INF = 1000000007;
    static long init(int node, int start, int end){
        if(start == end){
            return segTree[node] = array[start];
        }
        int mid = (start+end)/2;
        return segTree[node] = (init(node*2, start, mid) * init(node*2 + 1, mid+1, end))%INF;
    }

    static long sum(int node, int start, int end, int left, int right){
        if(right < start || left > end){
            return 1;
        }
        else if(left <= start && right >= end){
            return segTree[node];
        }
        int mid = (start + end)/2;
        return (sum(node*2, start, mid,left,right) * sum(node*2 + 1, mid+1, end,left,right))%INF;
    }

    static long update(int node, int index, int start, int end, int value){
        if(index < start || index > end){
            return segTree[node];
        }
        else if(start == end){
            return segTree[node] = value;
        }
        int mid = (start+end)/2;
        return segTree[node] = (update(node * 2, index,start,mid,value) * update(node*2 + 1,index,mid + 1,end,value))%INF;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        array = new int[N];
        segTree = new long[N*4];
        for(int i = 0; i<N; i++){
            array[i] = sc.nextInt();
        }
        init(1,0,N-1);
        for(int i = 0; i<M+K; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a == 1){
                update(1,b-1,0,N-1,c);
                array[b-1] = c;
            }
            else if(a == 2){
                System.out.println(sum(1,0,N-1,b-1, c-1));
            }
        }
    }
}
