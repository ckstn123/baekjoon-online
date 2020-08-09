import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static int[] parent;
    static class edge{
        int start, end, cost;
        edge(int s, int e, int c){
            start = s;
            end = e;
            cost = c;
        }
    }

    static int find(int x){
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y)
            return;
        else
            parent[y] = x;
    }

    static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y)
            return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sum = 0;
        ArrayList<edge> edges = new ArrayList<>();
        parent = new int[n+1];

        for(int i = 1; i<=n; i++){
            parent[i] = i;
        }
        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new edge(a,b,c));
        }
        Comparator<edge> comp = (a,b) -> {
            return a.cost - b.cost;
        };

        Collections.sort(edges, comp);
        for(edge temp : edges){
            int x = temp.start;
            int y = temp.end;
            int cost = temp.cost;
            if(!isSameParent(x,y)){
                union(x,y);
                sum += cost;
            }
        }

        System.out.println(sum);
    }
}
