import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int result = 0;
    static void dfs(int x, int count){
        boolean flag = false;
        for(int i = 0; i<tree[x].size(); i++){
            if(!visited[tree[x].get(i)]){
                visited[tree[x].get(i)] = true;
                flag = true;
                dfs(tree[x].get(i), count+1);
            }
        }
        if(!flag){
            result += count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i = 1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        visited[1] = true;
        dfs(1,0);
        if(result % 2 == 0){
            System.out.println("No");
        }
        else
            System.out.println("Yes");
    }
}
