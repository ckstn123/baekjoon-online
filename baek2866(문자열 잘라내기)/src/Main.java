import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int R = Integer.parseInt(line.split(" ")[0]);
        int C = Integer.parseInt(line.split(" ")[1]);
        String[] words = new String[R];
        String[] str = new String[C];
        int count = 0;
        HashSet<String> set;
        for(int i = 0; i<R; i++){
            words[i] = br.readLine();
        }

        for (int i = 0; i < C; i++) {
            str[i] = "";
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                str[j] += words[i].charAt(j);
            }
        }

        while(true) {
            set = new HashSet<>();
            for (int i = 0; i < C; i++) {
                String temp = str[i].substring(count,R);
                if(!set.contains(temp)){
                    set.add(temp);
                }
                else {
                    System.out.println(count-1);
                    return;
                }
            }
            count++;
        }
    }
}
