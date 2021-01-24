import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        int[] numbers = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        numbers[0] = sc.nextInt();
        left[0] = numbers[0];
        for(int i = 1; i<n; i++){
            numbers[i] = sc.nextInt();
            left[i] = Math.max(numbers[i] + left[i-1], numbers[i]);
        }

        right[n-1] = numbers[n-1];
        for(int i = n-2; i>=0 ;i--){
            right[i] = Math.max(numbers[i] + right[i+1], numbers[i]);
        }

        max = left[0];
        for(int i = 1; i<n; i++){
            max = Math.max(max, left[i]);
        }

        for(int i = 1; i<n-1; i++){
            max = Math.max(max, left[i-1] + right[i+1]);
        }

        System.out.println(max);
    }
}
