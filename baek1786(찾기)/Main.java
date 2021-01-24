import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] getPi(String P){
        int size = P.length();
        int[] pi = new int[size];
        int j = 0;
        for(int i = 1; i<size; i++){
            while(j>0 && P.charAt(i) != P.charAt(j)){
                j = pi[j-1];
            }
            if(P.charAt(i) == P.charAt(j)){
                pi[i] = ++j;
            }
        }
        return pi;
    }

    static ArrayList<Integer> KMP(String T , String P){
        ArrayList<Integer> result = new ArrayList<>();
        int T_size = T.length();
        int P_size = P.length();
        int[] pi = getPi(P);
        int j = 0;
        for(int i = 0; i<T_size; i++){
            while(j > 0 && T.charAt(i) != P.charAt(j))
                j = pi[j-1];

            if(T.charAt(i) == P.charAt(j)){
                if(j == P_size-1){
                    result.add(i-P_size+2);
                    j = pi[j];
                }
                else
                    j++;
            }
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();
        String P = br.readLine();

        ArrayList<Integer> result = KMP(T,P);
        System.out.println(result.size());
        for(int temp : result){
            System.out.print(temp + " ");
        }
    }
}
