import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line.split(" ")[0]);
        int M = Integer.parseInt(line.split(" ")[1]);
        int[] gems = new int[M];
        long result = 0;
        long sum = 0;
        for(int i = 0; i<M; i++){
            gems[i] = Integer.parseInt(br.readLine());
            sum += gems[i];
        }

        long left = 1;
        long right = sum;
        long mid = 0;
        while(left <= right){
            mid = (left + right)/2;
            int count = 0;
            for(int i = 0; i<M; i++){
                if(gems[i] % mid != 0){
                    count++;
                }
                count += gems[i] / mid;
                if(count > N){
                    break;
                }
            }

            if(count > N){
                left = mid + 1;
            }
            else {
                right = mid - 1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}
