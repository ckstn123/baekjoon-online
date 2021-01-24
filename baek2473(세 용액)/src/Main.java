import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        int[] result = new int[3];
        for(int i = 0; i<n; i++){
            numbers[i] = sc.nextInt();
        }
        
        Arrays.sort(numbers);
        long sum = 0;
        long min = Long.MAX_VALUE;
        for(int i = 0; i<n-2; i++){
            int left = i+1;
            int right = n-1;
            while(left < right){
                sum = (long)numbers[left] + numbers[i] + numbers[right];
                if(Math.abs(sum) < min){
                    min = Math.abs(sum);
                    result[0] = numbers[i];
                    result[1] = numbers[left];
                    result[2] = numbers[right];
                }

                if(sum > 0){
                    right--;
                }
                else if(sum < 0){
                    left++;
                }
                else {
                    System.out.println(numbers[i] + " " + numbers[left] + " " + numbers[right]);
                    return;
                }

            }
        }

        System.out.println(result[0] + " " + result[1] + " " + result[2]);

    }
}
