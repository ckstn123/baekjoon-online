import java.util.Scanner;

public class Main {
    static int[] getPi(String str){
        int[] pi = new int[str.length()];
        int j = 0;
        for(int i = 1; i<str.length(); i++){
            while(j > 0 && str.charAt(i) != str.charAt(j)){
                j = pi[j-1];
            }
            if(str.charAt(i) == str.charAt(j)){
                pi[i] = ++j;
            }
        }
        return pi;
    }

    static boolean kmp(String word, String str){
        int[] pi = getPi(str);
        int j = 0;
        for(int i = 0; i<word.length(); i++){
            while (j > 0 && word.charAt(i) != str.charAt(j)){
                j = pi[j-1];
            }
            if(word.charAt(i) == str.charAt(j)){
                if(j == str.length()-1){
                    return true;
                }
                else
                    j++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String str = sc.next();
        if(kmp(word,str))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
