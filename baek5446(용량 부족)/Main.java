import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static TrieNode rootNode;
    static int result = 0;
    static class TrieNode{
        private Map<Character, TrieNode> childNodes;
        boolean status;
        boolean isLastNode;

        TrieNode(){
            childNodes = new HashMap<>();
        }
        Map<Character, TrieNode> getChildNodes(){
            return this.childNodes;
        }

        void setLastNode(boolean isLastNode){
            this.isLastNode = isLastNode;
        }

        void setStatus(boolean status){
            this.status = status;
        }

    }

    static void insert(String word){
        TrieNode thisNode = rootNode;
        int length = word.length();
        for(int i = 0; i<length; i++){
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            thisNode.setStatus(true);
        }
        thisNode.setLastNode(true);

    }

    static void check(String word){
        TrieNode thisNode = rootNode;
        int length = word.length();
        for(int i = 0; i<length; i++){
            thisNode = thisNode.getChildNodes().get(word.charAt(i));
            if(thisNode == null){
                return;
            }
            thisNode.setStatus(false);
        }

    }

    static void dfs(TrieNode node){
        if(node.status){
            result++;
            return;
        }
        else if(node.isLastNode){
            result++;
        }
        for(Character temp : node.getChildNodes().keySet()){
            dfs(node.getChildNodes().get(temp));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i = 0; i<tc; i++){
            int n1 = sc.nextInt();
            result = 0;
            rootNode = new TrieNode();
            for(int j = 0; j<n1; j++){
                String word = sc.next();
                insert(word);
            }
            int n2 = sc.nextInt();
            if(n2 == 0){
                System.out.println(1);
                continue;
            }
            for(int k = 0; k<n2; k++){
                String word = sc.next();
                check(word);
            }
            dfs(rootNode);
            System.out.println(result);

        }
    }
}
