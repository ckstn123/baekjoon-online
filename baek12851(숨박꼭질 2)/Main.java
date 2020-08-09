import java.util.*;

public class Main {
    static int n;
    static int k;
    static int min = Integer.MAX_VALUE;
    static int[] visited;
    static Map<Integer, Integer> result = new HashMap<>();
    static class position{
        int x,time;
        position(int x, int t){
            this.x = x;
            time = t;
        }
    }

    static boolean check(int x, int time){
        if(x < 0 || x > 100001 || visited[x] < time)
            return false;
        return true;
    }

    static void bfs(){
        Queue<position> queue = new LinkedList<>();
        queue.offer(new position(n, 0));
        visited[n] = 0;
        while(!queue.isEmpty()){
            position temp = queue.poll();

            int x = temp.x - 1;
            if(check(x, temp.time+1)){
                if(x == k){
                    visited[k] = temp.time+1;
                    min = Math.min(min, temp.time + 1);
                    if(!result.containsKey(temp.time + 1))
                        result.put(temp.time + 1, 1);
                    else
                        result.put(temp.time + 1, result.get(temp.time + 1) + 1);
                }
                else {
                    queue.add(new position(x, temp.time+1));
                    visited[x] = temp.time+1;
                }
            }
            x = temp.x + 1;
            if(check(x, temp.time+1)){
                if(x == k){
                    visited[k] = temp.time+1;
                    min = Math.min(min, temp.time + 1);
                    if(!result.containsKey(temp.time + 1))
                        result.put(temp.time + 1, 1);
                    else
                        result.put(temp.time + 1, result.get(temp.time + 1) + 1);
                }
                else {
                    queue.add(new position(x, temp.time+1));
                    visited[x] = temp.time+1;
                }
            }
            x = temp.x * 2;
            if(check(x, temp.time+1)){
                if(x == k){
                    visited[k] = temp.time+1;
                    min = Math.min(min, temp.time + 1);
                    if(!result.containsKey(temp.time + 1))
                        result.put(temp.time + 1, 1);
                    else
                        result.put(temp.time + 1, result.get(temp.time + 1) + 1);
                }
                else {
                    queue.add(new position(x, temp.time+1));
                    visited[x] = temp.time+1;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        if(n == k){
            System.out.println(0);
            System.out.println(1);
            return;
        }
        visited = new int[100002];
        Arrays.fill(visited, Integer.MAX_VALUE);
        bfs();
        System.out.println(min);
        System.out.println(result.get(min));
    }
}
