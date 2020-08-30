import java.util.*;

public class Main {
    static int R;
    static int C;
    static int result = 0;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] matrix;
    static Map<Character,Integer> check = new HashMap<>();

    static void dfs(int x, int y){
        if(check.containsKey(matrix[y][x])){
            result = Math.max(result, check.size());
            return;
        }
        check.put(matrix[y][x],1);
        for(int i = 0; i<4; i++){
            int dis_x = x + dx[i];
            int dis_y = y + dy[i];
            if(dis_x < 0 || dis_x >= C || dis_y < 0 || dis_y >= R)
                continue;
            dfs(dis_x,dis_y);
        }
        check.remove((Object)matrix[y][x]);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        matrix = new char[R][C];
        for(int i = 0; i<R; i++){
            String str = sc.next();
            for(int j = 0; j<C; j++){
                matrix[i][j] = str.charAt(j);
            }
        }
        dfs(0,0);

        System.out.println(result);
    }
}
