import java.util.*;

public class Main {
    static int n;
    static int m;
    static int near = 0;
    static int person_count = 0;
    static int[] dx = {0,-1,1,0};
    static int[] dy = {-1,0,0,1};
    static int[][] matrix;
    static boolean[][] visited;
    static taxi baek;
    static ArrayList<person> list = new ArrayList<>();
    static Queue<person> near_list;

    static class taxi{
        int x,y,fuel,use;
        person p;
        public taxi(int x, int y, int fuel, int use, person p) {
            this.x = x;
            this.y = y;
            this.fuel = fuel;
            this.use = use;
            this.p = p;
        }
    }

    static class person{
        int x1,y1,x2,y2;

        public person(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    static boolean bfs(){
        Queue<taxi> queue = new LinkedList<>();
        queue.offer(baek);
        while(!queue.isEmpty()){
            taxi cur = queue.poll();
            if(cur.fuel < 0){
                break;
            }
            if(cur.p == null){
                if(near_list.isEmpty()){
                    for(int i = 0; i<list.size(); i++){
                        //탑승
                        if(cur.x == list.get(i).x1 && cur.y == list.get(i).y1){
                            near_list.offer(list.get(i));
                            near = cur.fuel;
//                            baek = new taxi(cur.x, cur.y, cur.fuel, cur.use, list.get(i));
//                            list.remove(i);
//                            return false;
                        }
                    }
                }
                else {
                    if(near == cur.fuel){
                        for(int i = 0; i<list.size(); i++){
                            //탑승
                            if(cur.x == list.get(i).x1 && cur.y == list.get(i).y1){
                                near_list.offer(list.get(i));

                            }
                        }
                    }
                    else if(near > cur.fuel){
                        continue;
                    }
                }

            }
            else {
                //하차
                if(cur.x == cur.p.x2 && cur.y == cur.p.y2){
                    person_count--;
                    baek = new taxi(cur.x, cur.y, cur.fuel + (cur.use*2), 0, null);
                    return false;
                }
            }
            for(int dir = 0; dir<4; dir++){
                int x = cur.x + dx[dir];
                int y = cur.y + dy[dir];
                if(x < 1 || x >= n+1 || y < 1 || y >= n+1 || matrix[y][x] == 1 || visited[y][x])
                    continue;
                visited[y][x] = true;
                if(cur.p == null){
                    queue.offer(new taxi(x,y,cur.fuel-1, cur.use, cur.p));
                }
                else {
                    queue.offer(new taxi(x, y, cur.fuel - 1, cur.use + 1, cur.p));
                }
            }
        }

        if(near_list.isEmpty()){
            return true;
        }
        person p = near_list.poll();

        baek = new taxi(p.x1, p.y1, near, 0, p);
        if(!list.isEmpty()){
            list.remove(p);
        }
        return false;
    }

    static Comparator<person> comp = (a,b) -> {
        if(a.y1 == b.y1){
            return a.x1 - b.x1;
        }
        return a.y1 -b.y1;
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int f = sc.nextInt();
        matrix = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int y = sc.nextInt();
        int x = sc.nextInt();
        baek = new taxi(x,y,f,0,null);

        for(int i = 0; i<m; i++){
            int y1 = sc.nextInt();
            int x1 = sc.nextInt();
            int y2 = sc.nextInt();
            int x2 = sc.nextInt();
            list.add(new person(x1,y1,x2,y2));
        }

        person_count = list.size();
        while(person_count > 0){
            visited = new boolean[n+1][n+1];
            near_list = new PriorityQueue<>(comp);
            if(bfs()){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(baek.fuel);
    }
}
