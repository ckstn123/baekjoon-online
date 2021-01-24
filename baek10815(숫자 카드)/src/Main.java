import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        for(int i = 0; i<N; i++){
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);
        int M = sc.nextInt();
        for(int i = 0; i<M; i++){
            int left = 0;
            int right = N-1;
            int mid = 0;
            int n = sc.nextInt();
            boolean flag = false;
            while (left <= right) {
                mid = (left+right)/2;
                if(numbers[mid] == n){
                    flag = true;
                    break;
                }
                else if(numbers[mid] < n){
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }

            if(flag){
                System.out.print("1 ");
            }
            else {
                System.out.print("0 ");
            }
        }
    }
}
