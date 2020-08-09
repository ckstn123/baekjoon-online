import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int max = 200001;
    static int[] parent;
    static int[] sum;

    static int find(int x){
        if(x==parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y)
            return;
        parent[y] = x;
        sum[x] += sum[y];
        sum[y] = 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String a;
        String b;
        for(int t = 0; t<n; t++){
            int m = sc.nextInt();
            Map<String, Integer> map = new HashMap<>();
            parent = new int[max];
            sum = new int[max];
            int idx = 1;
            for(int i = 1; i<max; i++){
                parent[i] = i;
                sum[i] = 1;
            }
            for(int i = 0; i<m; i++){
                a = sc.next();
                b = sc.next();

                if(!map.containsKey(a))
                    map.put(a,idx++);
                if(!map.containsKey(b))
                    map.put(b,idx++);
                union(map.get(a), map.get(b));
                System.out.println(sum[parent[map.get(a)]]);
            }

        }
    }
}
