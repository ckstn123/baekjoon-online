
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int max = 0;
        int[] temp = new int[T];
        for(int i = 0; i<T; i++){
            temp[i] = sc.nextInt();
            if(max < temp[i]){
                max = temp[i];
            }
        }

        long[] p = new long[max];

        if(max >= 1){
            p[0] = 1;
        }
        if(max >= 2){
            p[1] = 1;
        }
        if(max >= 3){
            p[2] = 1;
        }
        if(max >= 4){
            for(int i = 3; i<max; i++){
                p[i] = p[i-3] + p[i-2];
            }
        }

        for(int i = 0; i<T; i++){
            System.out.println(p[temp[i]-1]);

        }
    }
}