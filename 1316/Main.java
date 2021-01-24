import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int count = 0;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] t = new String[n + 1];

		for (int i = 0; i <= n; i++)
			t[i] = in.nextLine();

		for (int i = 1; i <= n; i++) {
			count++;
			Loop1: for (int j = 0; j < t[i].length() - 1; j++) {
				int check = 0;
				for (int k = j + 1; k < t[i].length(); k++) {					
					if (k == j + 1) {
						if (t[i].charAt(j) == t[i].charAt(k)) {
							check = 1;
						} else
							check = 0;
					}
					if (t[i].charAt(j) == t[i].charAt(k) && check != 1) {
						count--;
						break Loop1;
					}
				}
			}
		}
		System.out.println(count);
	}
}
