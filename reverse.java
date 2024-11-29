package a;

import java.util.*;
public class reverse {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		scan.nextLine();
		
		while(n>0) {
			n--;
			String str = scan.nextLine();
			
			StringTokenizer tok = new StringTokenizer(str);
			StringBuilder sb = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			
			while(tok.hasMoreTokens()) {
				sb.append(tok.nextToken());
				sb2.append(sb.reverse()+" ");
				sb.setLength(0);
			}
			
			System.out.println(sb2);
		}
	}

}
