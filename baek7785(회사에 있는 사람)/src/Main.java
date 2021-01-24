import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String check = st.nextToken();
            if(check.equals("enter")){
                map.put(name,1);
            }
            else if(check.equals("leave")){
                map.remove(name);
            }
        }
        Object[] result = map.keySet().toArray();
        Arrays.sort(result);

        for(int i = result.length-1; i>=0; i--){
            System.out.println(result[i]);
        }
    }
}
