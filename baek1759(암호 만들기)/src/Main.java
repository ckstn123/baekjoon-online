import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int C;
    static String[] alpa;
    static boolean[] visited;
    static ArrayList<String> result = new ArrayList<>();

    static void combination(int start, int count){
        if(count == L){
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i<C; i++){
                if(visited[i]){
                    temp.append(alpa[i]);
                }
            }
            String str = temp.toString();
            if(str.contains("a") || str.contains("e") || str.contains("i") || str.contains("o") || str.contains("u")){
                if(str.length() < 7){
                    int mo = 0;
                    if(str.contains("a"))
                        mo++;
                    if(str.contains("e"))
                        mo++;
                    if(str.contains("i"))
                        mo++;
                    if(str.contains("o"))
                        mo++;
                    if(str.contains("u"))
                        mo++;
                    if(str.length() - mo < 2)
                        return;
                }
                result.add(temp.toString());
            }

            return;
        }

        for(int i = start; i<C; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(i+1, count+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpa = new String[C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<C; i++){
            alpa[i] = st.nextToken();
        }
        Arrays.sort(alpa);
        combination(0,0);
        Collections.sort(result);
        for(String str : result){
            System.out.println(str);
        }
    }
}
