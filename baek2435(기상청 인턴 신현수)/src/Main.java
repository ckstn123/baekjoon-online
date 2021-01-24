import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max = 0;
        int window = 0;
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<K; i++){
            window += numbers[i];
        }
        max = window;
        for(int i = 0; i<N-K; i++){
            max = Math.max(max, window);
            window += numbers[i+K] - numbers[i];
        }
        max = Math.max(max, window);
        System.out.println(max);
    }
}
