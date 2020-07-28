import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static int A;
    static int B;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static robot[] robot_list;
    static class robot{
        int x, y, dir;
        robot(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static boolean simulation(int id, char status, int count){

        for(int j = 0; j<count; j++){
            robot temp = robot_list[id];
            if(status == 'L'){
                int dir = (temp.dir + 3)%4;
                robot_list[id] = new robot(temp.x,temp.y,dir);
            }
            else if(status == 'R'){
                int dir = (temp.dir + 1)%4;
                robot_list[id] = new robot(temp.x,temp.y,dir);
            }
            else if(status == 'F'){
                int x = temp.x + dx[temp.dir];
                int y = temp.y + dy[temp.dir];

                if(x < 0 || x >= A || y < 0 || y >= B){
                    System.out.println("Robot " + (id+1) + " crashes into the wall");
                    return true;
                }
                if(matrix[y][x] != 0){
                    System.out.println("Robot " + (id+1) + " crashes into robot " + matrix[y][x]);
                    return true;
                }
                matrix[temp.y][temp.x] = 0;
                matrix[y][x] = id+1;
                robot_list[id] = new robot(x,y,temp.dir);
            }
        }

        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        matrix = new int[B][A];
        robot_list = new robot[N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            char str = st.nextToken().charAt(0);
            int dir = 0;
            if(str == 'E')
                dir = 0;
            else if(str == 'S')
                dir = 1;
            else if(str == 'W')
                dir = 2;
            else if(str == 'N')
                dir = 3;
            robot_list[i] = new robot(x,y,dir);
            matrix[y][x] = i+1;
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken()) - 1;
            char ch = st.nextToken().charAt(0);
            int count = Integer.parseInt(st.nextToken());
            if(simulation(id,ch,count)){
                return;
            }
        }
        System.out.println("OK");
    }
}
