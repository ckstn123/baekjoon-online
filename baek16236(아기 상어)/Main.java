import java.util.*;

public class Main {
    static int N;
    static int result = 0;
    static int count = 0;
    static int shark_size = 2;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int[][] matrix;
    static int[][] visited;
    static ArrayList<fish> fish_list = new ArrayList<>();

    static class shark{
        int x, y;
        public shark(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class fish{
        int x, y, dist;

        public fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static void bfs(int x, int y){
        Queue<shark> queue = new LinkedList<>();
        queue.offer(new shark(x,y));
        matrix[y][x] = 0;
        while (!queue.isEmpty()){
            shark temp = queue.poll();
            for(int dir = 0; dir<4; dir++){
                int dis_x = temp.x + dx[dir];
                int dis_y = temp.y + dy[dir];
                if(dis_x < 0 || dis_x >= N || dis_y < 0 || dis_y >= N || matrix[dis_y][dis_x] > shark_size || visited[dis_y][dis_x] != 0){
                    continue;
                }
                visited[dis_y][dis_x] = visited[temp.y][temp.x] + 1;
                if(matrix[dis_y][dis_x] < shark_size && matrix[dis_y][dis_x] != 0){
                    fish_list.add(new fish(dis_x, dis_y, visited[dis_y][dis_x]));
                    queue.offer(new shark(dis_x,dis_y));
                }
                else if (matrix[dis_y][dis_x] == shark_size || matrix[dis_y][dis_x] == 0)
                    queue.offer(new shark(dis_x,dis_y));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int x = 0,y = 0;
        matrix = new int[N][N];
        visited = new int[N][N];
        Comparator<fish> comp = new Comparator<fish>() {
            @Override
            public int compare(fish o1, fish o2) {
                if(o1.dist > o2.dist)
                    return 1;
                else if(o1.dist < o2.dist)
                    return -1;
                else {
                    if(o1.y > o2.y)
                        return 1;
                    else if(o1.y < o2.y)
                        return -1;
                    else {
                        if(o1.x > o2.x)
                            return 1;
                        else if(o1.x < o2.x)
                            return -1;
                        return 0;
                    }
                }
            }
        };
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                int size = sc.nextInt();
                if(size == 9){
                    x = j;
                    y = i;
                }
                matrix[i][j] = size;
            }
        }
        
        while(true){
            bfs(x,y);
            if(fish_list.size() == 0)
                break;
            fish_list.sort(comp);
            result += fish_list.get(0).dist;
            count++;
            if(shark_size == count){
                shark_size++;
                count = 0;
            }
            x = fish_list.get(0).x;
            y = fish_list.get(0).y;
            visited = new int[N][N];
            fish_list.clear();
        }
        System.out.println(result);
    }
}
