import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] matrix = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            matrix[i] = new ArrayList<>();
        }
        for(int i = 0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a].add(b);
            matrix[b].add(a);
        }
        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i<q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            if(t == 2){
                System.out.println("yes");
                continue;
            }
            int k = Integer.parseInt(st.nextToken());
            if(t == 1){
                if(matrix[k].size() > 1)
                    System.out.println("yes");
                else
                    System.out.println("no");
            }
        }
    }
}
