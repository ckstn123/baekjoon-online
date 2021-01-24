import java.util.Scanner;

public class Main {
    static int[] parent;

    static int find(int x){
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y){
            return;
        }
        parent[y] = x;
    }

    static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int k = 0; k<T; k++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int sum = 0;
            parent = new int[n+1];
            for(int i = 1; i<=n; i++){
                parent[i] = i;
            }

            for(int i=0; i<m; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(!isSameParent(a,b)){
                    sum++;
                    union(a,b);
                }
            }
            System.out.println(sum);
        }
    }
}
