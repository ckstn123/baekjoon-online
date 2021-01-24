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
        String str = sc.next();
        int max = 0;
        for(int i = 0; i<str.length(); i++){
            String word = str.substring(i);
            int[] pi = getPi(word);

            for(int count : pi){
                max = Math.max(max, count);
            }
        }

        System.out.println(max);
    }
}
