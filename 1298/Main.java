import java.util.*;
 

public class Main {
    
    static int M;
    static int N;
    static int[][] ad;   
    static boolean[] visit; 
    static int[] avisit;
    static int[] bvisit;
    
    
    public static boolean dfs(int i){
    	if(visit[i])
    		return false;
        visit[i] = true;   // 함수 호출 시, visit 했음을 표시       
        
        for(int j = 1; j < N+1; j++){
            if(ad[i][j] == 1){  
            	if(bvisit[j] == -1 || dfs(bvisit[j])) {
            		avisit[i] = j;
            		bvisit[j] = i;
            		
            		return true;
            	}             
            }
        }
        return false;
    }
    
    public static int Match() {
    	avisit = new int[N+1];
    	bvisit = new int[N+1];
    	for(int i = 1; i<N+1; i++) {
    		avisit[i] = -1;
    		bvisit[i] = -1;
    	}
    	int count = 0;
    	
    	for(int i = 1; i<N+1; i++) {
    		for(int j = 1; j<N+1; j++)
    			visit[j] = false;
    		
    		if(dfs(i))
    			count++;
    	}
    	return count;
    }


	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		if(1<=N && N<=100)
			N=N;
		else
			return;
		M = in.nextInt();
		if(0<=M && M<=5000)
			M=M;
		else 
			return;
		//Main main = new Main(M);
		ad = new int[N+1][N+1];
		visit = new boolean[N+1];
		// HashMap<Integer,Integer> note = new HashMap<Integer,Integer>();

		for (int i = 0; i < M; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			ad[a][b] = 1;

		}
		System.out.println(Match());
		
	}
}


