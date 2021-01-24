import java.util.*;

public class Main {

    static class gem{
        int m, v;

        public gem(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long result = 0;
        gem[] gems = new gem[n];
        int[] bags = new int[k];
        for(int i = 0; i<n; i++){
            int m = sc.nextInt();
            int v = sc.nextInt();
            gems[i] = new gem(m, v);
        }

        for(int i = 0; i<k; i++){
            bags[i] = sc.nextInt();
        }

        Arrays.sort(bags);
        Comparator<gem> comp = (a,b) -> {
            return a.m - b.m;
        };
        Arrays.sort(gems,comp);
        Comparator<Integer> desc = (a,b) -> {
            return b-a;
        };
        PriorityQueue<Integer> queue = new PriorityQueue<>(desc);
        int index = 0;
        for(int i = 0; i<k; i++){
            for(int j = index; j<n; j++){
                if(gems[j].m <= bags[i]){
                    queue.offer(gems[j].v);
                    index++;
                }
                else
                    break;
            }

            if(!queue.isEmpty()){
                result += queue.poll();
            }
        }
        System.out.println(result);
    }


}
