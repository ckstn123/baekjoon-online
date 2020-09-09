import java.util.*;

public class Main {
    static String str;
    static boolean[] check;
    static ArrayList<pair> list;
    static Set<String> set = new HashSet<>();
    static ArrayList<String> result = new ArrayList<>();
    static class pair{
        int left, right;
        pair(int l, int r){
            left = l;
            right = r;
        }
    }

    static void permutation(int start, int count, int r){
        if(count == r){
            String temp = "";

            for(int i = 0; i<str.length(); i++){
                if(!check[i]){
                    temp += str.charAt(i);
                }
            }
            set.add(temp);
            return;
        }

        for(int i = start; i<list.size(); i++){
            int left = list.get(i).left;
            int right = list.get(i).right;
            if(!check[left] && !check[right]){
                check[left] = true;
                check[right] = true;
                permutation(i+1, count+1,r);
                check[left] = false;
                check[right] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        Stack<Integer> stack = new Stack<>();
        list = new ArrayList<>();
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push(i);
            }
            if(str.charAt(i) == ')'){
                if(!stack.isEmpty())
                    list.add(new pair(stack.pop(), i));
            }
        }
        for(int i = 1; i<=list.size(); i++){
            check = new boolean[str.length()];
            permutation(0,0,i);
        }
        for(String temp : set){
            result.add(temp);
        }
        Collections.sort(result);
        for(String temp : result)
            System.out.println(temp);

    }
}
