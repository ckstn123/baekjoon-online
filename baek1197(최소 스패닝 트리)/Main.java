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
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int sum = 0;
        ArrayList<edge> edges = new ArrayList<>();
        parent = new int[v+1];

        for(int i = 1; i<=v; i++){
            parent[i] = i;
        }
        for(int i = 0; i<e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new edge(a,b,c));
        }

        Comparator<edge> comp = new Comparator<edge>() {
            @Override
            public int compare(edge o1, edge o2) {
                if(o1.cost < o2.cost)
                    return -1;
                else if(o1.cost == o2.cost)
                    return 0;
                else
                    return 1;
            }
        };

        Collections.sort(edges,comp);

        for(edge temp : edges){
            if(!isSameParent(temp.start, temp.end)){
                sum += temp.cost;
                union(temp.start,temp.end);
            }
        }

        System.out.println(sum);
    }
}
