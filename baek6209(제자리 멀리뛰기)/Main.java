import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] stones = new int[n+2];
        stones[0] = 0;
        stones[n+1] = d;
        for(int i = 1; i<=n; i++){
            stones[i] = sc.nextInt();
        }
        Arrays.sort(stones);

        int s = 1;
        int e = d;
        int mid = 0;
        while(s<=e){
            mid = (s+e)/2;
            int stone = 0; //출발 돌섬 위치
            int count = 0;
            int min = d;
            for(int i = 1; i<=n; i++){
                //돌섬 제거
                if(stones[i] - stone < mid){
                    //돌섬을 제거하면 출발할 돌섬은 그대로이므로 stone을 변경하지 않는다.
                    count++;
                }
                else {
                    //제거하지 않았다면 바로 최소거리인지 확인
                    min = Math.min(min, stones[i] - stone);
                    stone = stones[i]; //아동했으므로 출발 돌섬 위치 변경
                }
            }

            if(count <= m){
                s = mid + 1;
                max = Math.max(max, min);
            }
            else {
                e = mid - 1;

            }
        }
        System.out.println(max);
    }
}
