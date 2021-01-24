import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String result;
    public static boolean check(String temp){
        String compare = "";
        for(int i = temp.length() - 1; i>=0; i--){
            compare = compare + temp.charAt(i);
        }

        return compare.equals(temp);
    }
    public static void solve(String temp){

        result = temp;

        for(int i = 0; i<temp.length(); i++){
            for(int j = i; j >= 0; j--){
                result += temp.charAt(j);
            }
            if(check(result))
                return;
            result = temp;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String T = in.readLine();
        if(check(T)) {
            System.out.println(T.length());
            return;
        }
        solve(T);
        System.out.println(result.length());
    }
}
