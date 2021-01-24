import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static HashMap<Integer, check> visited;
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<String> result = new ArrayList<>();
    static class check {
        int index, count;

        public check(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
    static void dfs(int count){
        if(count == N * 2){
            StringBuilder sb = new StringBuilder();
            for(int num : stack){
                sb.append(num);
                sb.append(" ");
            }

            result.add(sb.toString());
            return;
        }
        for(int i = 0; i<N; i++){
            if(!visited.containsKey(numbers[i])){
                visited.put(numbers[i], new check(count,1));
                stack.push(numbers[i]);
                dfs(count+1);
                stack.pop();
                visited.remove(numbers[i]);
            }
            else {
                if(visited.get(numbers[i]).count == 1 && visited.get(numbers[i]).index + numbers[i] + 1 == count){
                    int prev = visited.get(numbers[i]).index;
                    stack.push(numbers[i]);
                    visited.put(numbers[i], new check(count,2));
                    dfs(count + 1);
                    stack.pop();
                    visited.put(numbers[i], new check(prev,1));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];
        visited = new HashMap<>();
        for(int i = 0; i<N; i++){
            numbers[i] = sc.nextInt();
        }
        dfs(0);
        if(result.isEmpty()){
            System.out.println(-1);
            return;
        }
        Comparator<String> comp = (a,b) -> {
            if(a.length() < b.length()){
                return a.length() - b.length();
            }
            else if(a.length() > b.length()){
                return b.length() - a.length();
            }
            else {
                return a.compareTo(b);
            }
        };
        result.sort(comp);
        System.out.println(result.get(0));
    }
}
