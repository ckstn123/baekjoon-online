import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2; i<=N; i++){
            boolean flag = true;
            for(int j = 2; j*j <= i; j++){
                if(i%j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                list.add(i);
            }

        }

        int s=0,e=0,sum=0;
        while(s<=e){
            if(sum >= N){
                if(sum == N){
                    result++;
                }
                sum -= list.get(s++);

            }
            else if(e >= list.size())
                break;
            else {
                sum += list.get(e++);
            }
        }
        System.out.println(result);
    }
}
