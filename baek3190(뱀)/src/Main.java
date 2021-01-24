import java.util.*;

public class Main {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static class point{
        int x, y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] matrix = new int[N][N];
        for(int i = 0; i<K; i++){
            int y = sc.nextInt()-1;
            int x = sc.nextInt()-1;
            matrix[y][x] = 1; //사과 위치
        }
        int L = sc.nextInt();
        Map<Integer, String> map = new HashMap<>();
        for(int i = 0; i<L; i++){
            int time = sc.nextInt();
            String d = sc.next();
            map.put(time, d);
        }
        Deque<point> dq = new ArrayDeque<>();
        matrix[0][0] = 2; //뱀 위치
        dq.addLast(new point(0,0));
        int dir = 0;
        int t = 0;
        int x = 0;
        int y = 0;
        while(true){
            if(map.containsKey(t)){
                if(map.get(t).equals("L")){
                    dir = (dir+3)%4;
                }
                else
                    dir = (dir+1)%4;
            }
            x = x + dx[dir];
            y = y + dy[dir];
            t++;
            if(x < 0 || x >= N || y < 0 || y >= N || matrix[y][x] == 2){
                System.out.println(t);
                return;
            }
            if(matrix[y][x] == 0){
                point temp = dq.pollFirst();
                matrix[temp.y][temp.x] = 0;
            }
            matrix[y][x] = 2;
            dq.addLast(new point(x,y));

        }
    }
}
