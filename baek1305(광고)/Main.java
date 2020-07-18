import java.util.Scanner;

public class Main {

    static int[] getPi(String word){
        int len = word.length();
        int[] pi = new int[len];
        int j = 0;
        for(int i = 1; i<len; i++){
            while(j>0 && word.charAt(i) != word.charAt(j)){
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
        int L = sc.nextInt();
        String word = sc.next();
        int[] pi = getPi(word);

        System.out.println(L - pi[L-1]);
    }
}
