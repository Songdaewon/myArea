package Part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LCM {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int gcd = getGCD(a,b);
			
			System.out.println(a*b/gcd);
		}
	}
	
	public static int getGCD(int a, int b) {
		if(a%b==0) {
			return b;
		}
		return getGCD(b,a%b);
	}

}
