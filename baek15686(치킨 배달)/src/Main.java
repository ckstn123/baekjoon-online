import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static int result = Integer.MAX_VALUE;
    static LinkedList<Dot> chickens = new LinkedList<>();
    static LinkedList<Dot> homes = new LinkedList<>();
    static LinkedList<Dot> select = new LinkedList<>();

    public static class Dot{
        int x,y;
        Dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void dfs(int idx, int chick_count,int M){
        int sum = 0;

        if(chick_count == M){
            for(int i = 0; i<homes.size(); i++){
                int temp = Integer.MAX_VALUE;
                Dot home = homes.get(i);
                for(int j = 0; j<select.size(); j++){
                    Dot chik = select.get(j);
                    int d = Math.abs(home.x-chik.x) + Math.abs(home.y-chik.y);
                    if(temp > d){
                        temp = d;
                    }
                }
                sum += temp;
            }

            if(result > sum){
                result = sum;
                return;
            }
        }

        if(idx >= chickens.size())//인덱스가 치킨 집 수보다 클 경우
            return;

        select.add(chickens.get(idx));
        dfs(idx+1, chick_count+1, M); //치킨 집을 고를 경우

        select.pollLast();
        dfs(idx+1, chick_count, M);//치킨 집을 고르지 않을 경우
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] city = new int[N+1][N+1];

        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                city[i][j] = sc.nextInt();
                if(city[i][j] == 1){
                    Dot dot = new Dot(j,i);
                    homes.add(dot);
                }
                if(city[i][j] == 2){
                    Dot dot = new Dot(j,i);
                    chickens.add(dot);
                }
            }
        }
        dfs(0,0,M);

        System.out.println(result);
    }
}
