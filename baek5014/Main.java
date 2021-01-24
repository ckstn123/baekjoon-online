import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();
        int S = sc.nextInt();
        int G = sc.nextInt();
        int U = sc.nextInt();
        int D = sc.nextInt();
        int stair; //현재 층을 나타냄
        int[] count = new int[F+1];
        boolean[] visited = new boolean[F+1];
        Queue<Integer> q = new LinkedList<>();

        q.add(S); //시작 층을 큐에 저장
        visited[S] = true; //시작 층 방문
        while(!q.isEmpty()){
            stair = q.poll();

            if(stair == G){ //목적지에 도착하면
                System.out.println(count[stair]);
                return;
            }

            int up = stair + U; //위로 갈 층
            if(up <= F){
                if(visited[up] == false){// 방문하지 않았다면
                    q.add(up);
                    visited[up] = true; //방문했다고 표시
                    count[up] = count[stair] + 1;// 버튼 카운트 증가
                }

            }

            int down = stair - D;
            if(down >= 1){
                if(visited[down] == false){
                    q.add(down);
                    visited[down] = true;
                    count[down] = count[stair] + 1;
                }
            }

        }

        System.out.println("use the stairs");
    }
}
// 10 1 10 2 1
// 100 2 1 1 0