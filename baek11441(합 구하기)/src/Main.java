import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n+1];

        for(int i = 1; i<=n; i++){
            numbers[i] = sc.nextInt();
            numbers[i] += numbers[i-1];
        }
        int m = sc.nextInt();
        for(int i = 0; i<m; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int result = numbers[end] - numbers[start-1];
            System.out.println(result);
        }
    }
}
