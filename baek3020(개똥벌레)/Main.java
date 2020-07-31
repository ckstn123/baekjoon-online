import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int result = 0;
        int N = sc.nextInt();
        int H = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for(int i=0; i<N; i++){
            if(i%2 == 0){
                a.add(sc.nextInt());
            }
            else
                b.add(sc.nextInt());
        }
        Collections.sort(a);
        Collections.sort(b);

        for(int i = 1; i<=H; i++) {
            int left = 0;
            int right = a.size()-1;
            int mid = 0;
            int a_sum = 0;
            while (left <= right) {
                mid = (left + right) / 2;

                if(a.get(mid) >= i){
                    a_sum = a.size()-mid;
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }

            int b_sum = 0;
            left = 0;
            right = b.size()-1;
            while(left<=right){
                mid = (left+right)/2;

                if(H-b.get(mid) < i){
                    b_sum = b.size()-mid;
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            if(min >= a_sum + b_sum){
                if(min == a_sum + b_sum) {
                    result++;
                }
                else {
                    min = a_sum + b_sum;
                    result = 1;
                }
            }
        }
        System.out.println(min + " " + result);
    }
}
