import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        String[] words = new String[n];
        for(int i = 0; i<n; i++){
            words[i] = sc.next();
        }
        Comparator<String> comp = (a,b) -> {
            return a.length() - b.length();
        };
        Arrays.sort(words, comp);
        for(int i = 0; i<n; i++){
            boolean flag = false;
            for(int j = i+1; j<n; j++){
                if(words[j].contains(words[i])){
                    flag = true;
                    break;
                }
            }

            if(!flag){
                result++;
            }
        }

        System.out.println(result);
    }
}
