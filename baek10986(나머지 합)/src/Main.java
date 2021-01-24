import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long result = 0;
        int[] numbers = new int[n+1];
        long[] count = new long[m];
        for(int i = 1; i<=n; i++){
            numbers[i] = sc.nextInt();
            numbers[i] = (numbers[i] + numbers[i-1]) % m;
            if(numbers[i] == 0)
                result++;
            count[numbers[i]]++;
        }

        for(int i = 0; i<m; i++){
            result += (count[i] * (count[i] - 1))/2;
        }
        System.out.println(result);
    }
}
