import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        for(int i = 0; i<8; i++){
            String line = br.readLine();
            int start = 0;
            if(i % 2 == 1){
                start = 1;
            }
            for(int j = start; j<8; j+=2){
                if(line.charAt(j) == 'F')
                    result++;
            }
        }

        System.out.println(result);
    }
}
