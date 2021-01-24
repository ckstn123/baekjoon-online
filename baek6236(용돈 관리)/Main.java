import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] money = new int[N];
        int result = 0;
        int total = 0;
        int max = 0;
        for(int i = 0; i<N; i++){
            money[i] = sc.nextInt();
            total += money[i];
            max = Math.max(max , money[i]);
        }
        int left = max;
        int right = 100000 * 10000;
        int mid = 0;

        while(left <= right){
            int sum = 1;

            mid = (left+right)/2;
            int diff = mid;
            for(int temp : money){
                if(temp <= diff){
                    diff -= temp;
                }
                else {
                    sum++;
                    diff = mid - temp;
                }
            }
            if(sum <= M){
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
