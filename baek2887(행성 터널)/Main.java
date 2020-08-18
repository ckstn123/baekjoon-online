import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static int[] parent;
    static class planet{
        int x, y, z, num;
        planet(int x, int y, int z, int num){
            this.x = x;
            this.y = y;
            this.z = z;
            this.num = num;
        }
    }
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
        int n = sc.nextInt();
        int sum = 0;
        int count = 0;
        parent = new int[n];
        ArrayList<planet> list = new ArrayList<>();
        ArrayList<edge> edges = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            parent[i] = i;
            list.add(new planet(a,b,c,i));
        }
        Comparator<planet> x_comp = (a,b) -> {
            return a.x - b.x;
        };
        Comparator<planet> y_comp = (a,b) -> {
            return a.y - b.y;
        };
        Comparator<planet> z_comp = (a,b) -> {
            return a.z - b.z;
        };
        Collections.sort(list,x_comp);
        for(int i = 0; i<n-1; i++){
            edges.add(new edge(list.get(i).num, list.get(i+1).num, list.get(i+1).x - list.get(i).x));
        }
        Collections.sort(list,y_comp);
        for(int i = 0; i<n-1; i++){
            edges.add(new edge(list.get(i).num, list.get(i+1).num, list.get(i+1).y - list.get(i).y));
        }
        Collections.sort(list,z_comp);
        for(int i = 0; i<n-1; i++){
            edges.add(new edge(list.get(i).num, list.get(i+1).num, list.get(i+1).z - list.get(i).z));
        }
        Comparator<edge> comp = (a,b) -> {
            return a.cost - b.cost;
        };
        Collections.sort(edges,comp);

        for(edge temp : edges){
            int x = temp.start;
            int y = temp.end;
            if(!isSameParent(x,y)){
                union(x,y);
                sum += temp.cost;
                count++;
            }
            if(count == n-1)
                break;
        }
        System.out.println(sum);
    }
}
