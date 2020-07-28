import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int[] array = new int[N];
        for(int i = 0; i<N; i++){
            array[i] = sc.nextInt();
        }

        int s = 0, e = 0;
        long sum = 0;
        while(s <= e){
            if(sum >= S){
                min = Math.min(min, e-s);
                sum -= array[s++];
            }
            else if(e >= N){
                break;
            }
            else {
                sum += array[e++];
            }
        }
        if(min == Integer.MAX_VALUE){
            System.out.println(0);
            return;
        }
        System.out.println(min);
    }
}
