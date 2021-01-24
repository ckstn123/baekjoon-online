import java.util.Scanner;

public class Main {
    static int result = 0;
    static void combination(int n, int r){
        if(r > n){
            return;
        }
        if(r == n){
            result++;
        }

        for(int i = 1; i<=3; i++){
            combination(n, r+i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t<T; t++){
            int n = sc.nextInt();
            combination(n , 0);
            System.out.println(result);
            result = 0;
        }
    }
}
