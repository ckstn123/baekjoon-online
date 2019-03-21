import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String temp;
		String[] T;
		String A;
		String B;
		temp=in.nextLine();
		
		T = temp.split(" ");
		A = T[0];
		B = T[1];
		if(A.length()>10000 && B.length()>10000)
			return;
		
		long result = 0;
		for(int i = 0; i<A.length(); i++) {
			for(int j = 0; j<B.length(); j++)
				result += (A.charAt(i) - '0') * (B.charAt(j) -'0');
		}

		System.out.println(result);

	}

}
