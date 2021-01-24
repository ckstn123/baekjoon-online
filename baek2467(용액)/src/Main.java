import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        int[] result = new int[2];
        for(int i = 0; i<n; i++){
            numbers[i] = sc.nextInt();
        }

        int left = 0;
        int right = n-1;
        long sum = 0;
        long min = Long.MAX_VALUE;
        while(left < right){
            sum = numbers[left] + numbers[right];
            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                result[0] = numbers[left];
                result[1] = numbers[right];
            }

            if(sum < 0){
                left++;
            }
            else if(sum > 0){
                right--;
            }
            else {
                result[0] = numbers[left];
                result[1] = numbers[right];
                break;
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
}
