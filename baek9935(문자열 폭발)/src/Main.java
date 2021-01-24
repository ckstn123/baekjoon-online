import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String explode = sc.next();
        StringBuilder result = new StringBuilder();
       Stack<Character> stack = new Stack<>();
       for(int i = 0; i<str.length(); i++){
           stack.push(str.charAt(i));
           int s_size = stack.size();
           if(s_size >= explode.length() && stack.peek() == explode.charAt(explode.length()-1)){
               boolean flag = false;
               int index = 0;
               for(int j = s_size - explode.length(); j<s_size-1; j++){
                    if(stack.get(j) != explode.charAt(index)){
                        flag = true;
                        break;
                    }
                    index++;
               }
               if (!flag) {
                   for(int j = 0; j<explode.length(); j++){
                       stack.pop();
                   }
               }
           }
       }
       if(stack.isEmpty()){
           System.out.println("FRULA");
           return;
       }
       for(char c : stack){
           result.append(c);
       }
        System.out.println(result);
    }
}
