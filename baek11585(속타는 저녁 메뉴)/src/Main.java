import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] getPi(String word){
        int[] pi = new int[word.length()];
        int j = 0;
        for(int i = 1; i<word.length(); i++){
            while(j > 0 && word.charAt(i) != word.charAt(j)){
                j = pi[j-1];
            }
            if(word.charAt(i) == word.charAt(j)){
                pi[i] = ++j;
            }
        }
        return pi;
    }

    static int kmp(String word, String pattern){
        int[] pi = getPi(pattern);
        int j = 0;
        int count = 0;
        for(int i = 0; i<word.length(); i++){
            while(j > 0 && word.charAt(i) != pattern.charAt(j)){
                j = pi[j-1];
            }

            if(word.charAt(i) == pattern.charAt(j)){
                if(j == pattern.length() - 1){
                    count++;
                    j = pi[j];
                }
                else {
                    j++;
                }
            }
        }
        return count;
    }

    static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b,a%b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        StringBuilder word = new StringBuilder();
        while(st.hasMoreTokens()){
            word.append(st.nextToken());
        }
        word.append(word.substring(0,n-1));
        input = br.readLine();
        st = new StringTokenizer(input, " ");
        StringBuilder pattern = new StringBuilder();
        while(st.hasMoreTokens()){
            pattern.append(st.nextToken());
        }

        int num = kmp(word.toString(), pattern.toString());
        int answer = gcd(n,num);
        System.out.println(num/answer + "/" + n/answer);

    }
}
