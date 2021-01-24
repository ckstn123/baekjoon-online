import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[] array;
    static int[] segment;

    static int init(int node, int start, int end){
        if(start == end){
            return segment[node] = array[start];
        }

        int mid = (start + end)/2;
        return segment[node] = init(node*2, start, mid) + init(node*2 + 1, mid + 1, end);
    }

    static int sum(int node, int start, int end, int left, int right){
        if(left > end || right < start){
            return 0;
        }
        else if(left <= start && right >= end){
            return segment[node];
        }
        int mid = (start + end)/2;
        return sum(node*2, start, mid, left, right) + sum(node*2 + 1, mid + 1, end, left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        array = new int[n];
        segment = new int[4*n];
        for(int i = 0; i<n; i++){
            array[i] = sc.nextInt();
        }
        init(1, 0, n-1);
        for(int i = 0; i<m; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            System.out.println(sum(1, 0, n-1, a, b));
        }
    }
}
