import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 10000 - sc.nextInt() * 10;
        int result = 0;
        int[] money = {5000, 1000, 500, 100, 50, 10};
        for(int temp : money){
            while(N/temp != 0) {
                result += N / temp;
                N = N % temp;
            }
        }

        System.out.println(result);
    }
}
