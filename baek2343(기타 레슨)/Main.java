import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int max = 0;
        int sum = 0;
        int result = 0;
        int[] lesson = new int[N];
        for(int i = 0; i<N; i++){
            lesson[i] = sc.nextInt();
            sum += lesson[i];
            max = Math.max(max, lesson[i]);
        }

        int left = max;
        int right = sum;
        int mid = 0;
        int size;
        while(left<=right){
            mid = (left+right)/2;
            sum = 1;
            size = mid;
            for(int temp : lesson){
                if(size >= temp){
                    size -= temp;
                }
                else {
                    sum++;
                    size = mid - temp;
                }
            }

            if(sum <= M){
                right = mid - 1;
                result = mid;
            }
            else {
                left = mid + 1;

            }
        }
        System.out.println(result);
    }
}
