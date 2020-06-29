import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] time;
    static int[] degree;
    static node[] building;

    static class node{
        ArrayList<Integer> build_list = new ArrayList<>();
    }

    static int topology(int W){

        Queue<Integer> queue = new LinkedList<>();
        int[] max = new int[degree.length];
        for(int i = 1; i<degree.length; i++){
            if(degree[i] == 0){
                queue.offer(i);
                max[i] = time[i];
            }
        }
        while(!queue.isEmpty()){
            int temp = queue.poll();
            if(temp == W){
                break;
            }

            for(int i = 0; i<building[temp].build_list.size(); i++){
                if(max[building[temp].build_list.get(i)] < max[temp] + time[building[temp].build_list.get(i)]){
                    max[building[temp].build_list.get(i)] = max[temp] + time[building[temp].build_list.get(i)];
                }
                degree[building[temp].build_list.get(i)]--;
                if(degree[building[temp].build_list.get(i)] == 0){
                    queue.offer(building[temp].build_list.get(i));
                }
            }

        }
        return max[W];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T];
        for(int i = 0; i<T; i++){
            String line = br.readLine();
            int N = Integer.parseInt(line.split(" ")[0]);
            int K = Integer.parseInt(line.split(" ")[1]);
            time = new int[N+1];
            degree = new int[N+1];
            building = new node[N+1];
            line = br.readLine();
            for(int j = 0; j<N; j++){
                time[j+1] = Integer.parseInt(line.split(" ")[j]);
                building[j+1] = new node();
            }
            for(int m = 0; m<K; m++){
                line = br.readLine();
                int X = Integer.parseInt(line.split(" ")[0]);
                int Y = Integer.parseInt(line.split(" ")[1]);
                degree[Y]++;
                building[X].build_list.add(Y);
            }
            line = br.readLine();
            int W = Integer.parseInt(line);

            result[i] = topology(W);
        }
        for(int temp : result){
            System.out.println(temp);
        }
    }
}
