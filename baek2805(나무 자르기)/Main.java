import java.util.Arrays;
import java.util.Scanner;

//파라메트릭 서치
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M = sc.nextLong();
        long[] trees = new long[N];
        for(int i = 0; i<N; i++){
            trees[i] = sc.nextLong();
        }
        Arrays.sort(trees);
        long left = 0;
        long right = trees[N-1];
        long mid;
        long sum;
        boolean flag = false;
        while(left <= right){
            sum = 0;
            mid = (left+right)/2;
            for(long tree : trees){
                if(tree > mid){
                    sum += tree - mid;
                    if(sum > M)
                        break;
                }
            }

            if(sum == M){
                flag = true;
                System.out.println(mid);
                break;
            }
            else if(sum < M){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }

        }

        if(!flag)
            System.out.println(right);
    }
}
