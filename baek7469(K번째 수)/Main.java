import java.util.*;

public class Main {
    static int[] array;
    static int[] sorted;
    static ArrayList<Integer>[] list;
    static void init(int node, int start, int end){
        if(start == end){
            list[node].add(array[start]);
            return;
        }
        if(start < end) {
            int mid = (start + end) / 2;
            init(node * 2, start, mid);
            init(node * 2 + 1, mid + 1, end);
            merge(node, start, mid, end);

        }
    }

    static int Q(int node, int start, int end, int left, int right, int value){
        if(left > end || right < start){
            return 0;
        }
        else if(left <= start && right >= end){
            return upper_bound(node, value);
        }
        int mid = (start+end)/2;
        return Q(node*2,start,mid,left,right, value) + Q(node*2 + 1, mid + 1, end, left,right, value);
    }

    static int search(int n, int left, int right, int k){
        int count = 0;
        int s = -1000000000;
        int e = 1000000000;
        int mid;
        while(s<=e){

            mid = (s+e)/2;
            count = Q(1, 0, n-1, left, right, mid);
            if(count < k){
                s = mid + 1;
            }
            else
                e = mid - 1;
        }
        return s;
    }

    public static int upper_bound(int node, int value)
    {
        int mid = 0, s = 0, e = list[node].size();
        while(s < e)
        {
            mid = (s + e) / 2;
            if(list[node].get(mid) <= value) {
                s = mid + 1;
            }
            else {
                e = mid;
            }
        }
        return e;
    }

    static void merge(int node, int start,int mid, int end){

        int i = start;
        int j = mid + 1;
        int k = start;
        while(i <= mid && j <= end){
            if(array[i] <= array[j])
                sorted[k++] = array[i++];
            else
                sorted[k++] = array[j++];
        }
        if(i > mid){
            for(int t = j; t<=end; t++){
                sorted[k++] = array[t];
            }
        }
        else {
            for(int t = i; t<= mid; t++){
                sorted[k++] = array[t];
            }
        }

        for(int t = start; t<=end; t++){
            array[t] = sorted[t];
            list[node].add(sorted[t]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        array = new int[n];
        list = new ArrayList[n*4];
        sorted = new int[n];
        for(int i=0; i<n; i++){
            array[i] = sc.nextInt();
        }
        for(int i=1; i<n*4; i++){
            list[i] = new ArrayList<>();
        }
        init(1, 0, n-1);

        for(int t = 0; t<m; t++){
            int i = sc.nextInt()-1;
            int j = sc.nextInt()-1;
            int k = sc.nextInt();

            System.out.println(search(n, i, j, k));
        }
    }
}