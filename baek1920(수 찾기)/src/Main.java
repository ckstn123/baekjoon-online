import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            int target = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = N-1;
            if(target < numbers[left] || target > numbers[right]){
                System.out.println(0);
                continue;
            }
            int mid = 0;
            boolean flag = false;
            while(left <= right){
                mid = (left+right)/2;
                if(numbers[mid] == target){
                    flag = true;
                    break;
                }
                else if(numbers[mid] > target){
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            if(flag)
                System.out.println(1);
            else {
                System.out.println(0);
            }
        }
    }
}
