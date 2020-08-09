import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int k;
    static boolean[] visited;
    static class position{
        int x,time;
        position(int x, int t){
            this.x = x;
            time = t;
        }
    }

    static boolean check(int x){
        if(x < 0 || x > 100001 || visited[x])
            return false;
        return true;
    }

    static void bfs(){
        Queue<position> queue = new LinkedList<>();
        queue.offer(new position(n, 0));
        visited[n] = true;
        while(!queue.isEmpty()){
            position temp = queue.poll();
            if(temp.x == k){
                System.out.println(temp.time);
                return;
            }
            int x = temp.x * 2;
            if(check(x)){
                queue.add(new position(x, temp.time));
                visited[x] = true;
            }
            x = temp.x - 1;
            if(check(x)){
                queue.add(new position(x, temp.time+1));
                visited[x] = true;
            }
            x = temp.x + 1;
            if(check(x)){
                queue.add(new position(x, temp.time+1));
                visited[x] = true;
            }

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[100002];
        bfs();
    }
}
