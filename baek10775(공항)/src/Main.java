import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        boolean[] gates = new boolean[G+1];
        int result = 0;

        for(int i = 0; i<P; i++){
            int gi = Integer.parseInt(br.readLine());
            int check = result;
            for(int j = gi; j>0; j--){
                if(!gates[j]){
                    gates[j] = true;
                    result++;
                    break;
                }
            }
            if(check == result){
                break;
            }
        }

        System.out.println(result);
    }
}
