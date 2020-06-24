import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int R;
    static int S;
    static int[] dx = {-1,0,1,1,1,0,-1,-1};
    static int[] dy = {1,1,1,0,-1,-1,-1,0};
    static char[][] matrix;
    static boolean[][][] visited;
    static int size;
    static int max = 0;
    static int before_max = 0;
    static ArrayList<point> people = new ArrayList<>();
    static ArrayList<point> list;
    public static class point{
        int x,y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void check(){
        int count = 0;
        for(point temp : people){
            int x = temp.x;
            int y = temp.y;
            for(int dir = 0; dir<8; dir++){
                int dis_x = x + dx[dir];
                int dis_y = y + dy[dir];

                if(dis_x < 0 || dis_x >= S || dis_y < 0 || dis_y >= R || visited[dis_y][dis_x][(dir+4)%8]){
                    continue;
                }

                if(matrix[dis_y][dis_x] == 'o' && !visited[y][x][dir]){
                    count++;
                    visited[y][x][dir] = true;
                    visited[dis_y][dis_x][(dir+4)%8] = true;
                }
            }
        }
        if(count > before_max)
            before_max = count;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        R = Integer.parseInt(s.split(" ")[0]);
        S = Integer.parseInt(s.split(" ")[1]);
        list = new ArrayList<point>();
        matrix = new char[R][S];
        visited = new boolean[R][S][8];
        for(int i = 0; i<R; i++){

            String temp = bf.readLine();

            for(int j = 0; j<S; j++){
                matrix[i][j] = temp.charAt(j);
                if(temp.charAt(j) == '.'){
                    list.add(new point(j,i));
                }
                else
                    people.add(new point(j,i));
            }
        }
        check();
        size = list.size();

        for(int i = 0; i<size; i++){
            int count = 0;

            point temp = list.get(i);
            int x = temp.x;
            int y = temp.y;
            for(int dir = 0; dir<8; dir++){
                int dis_x = x + dx[dir];
                int dis_y = y + dy[dir];

                if(dis_x < 0 || dis_x >= S || dis_y < 0 || dis_y >= R){
                    continue;
                }

                if(matrix[dis_y][dis_x] == 'o'){
                    count++;
                }
            }
            if(max < count)
                max = count;
        }

        System.out.println(before_max+max);
    }
}
