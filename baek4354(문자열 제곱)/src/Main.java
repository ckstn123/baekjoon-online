import java.util.Scanner;

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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String word = sc.next();

            if(word.equals(".")){
                return;
            }
            int[] pi = getPi(word);
            int len = word.length();
            int num = pi[len-1];
            if(len%(len-num) != 0)
                System.out.println(1);
            else
                System.out.println(len/(len-num));
        }
    }
}
