import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();
        int[] volumes = new int[N+1];
        int[][] dp = new int[N+1][M+1];
        int max = -1;
        for(int i = 1; i<=N; i++){
            volumes[i] = sc.nextInt();
        }
        dp[0][S] = 1;
//
        for(int i = 1; i<=N; i++){ //전체 곡만큼 반복
            for(int j = 0; j <= M; j++){ //가능한 전체 볼륨 체크
                if(dp[i-1][j] == 1 && j + volumes[i] <= M){
                    dp[i][j + volumes[i]] = 1;
                }
                if(dp[i-1][j] == 1 && j - volumes[i] >= 0){
                    dp[i][j - volumes[i]] = 1;
                }
            }

        }
        //마지막 곡 최댓값
        for(int i = 0; i<=M; i++){
            if(dp[N][i] == 1){
                max = i;
            }
        }
        //마지막 곡을 연주할 수 있는지 없는지
        if(max != -1){
            System.out.println(max);
        }
        else
            System.out.println("-1");
    }
}
