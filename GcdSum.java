package Part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GcdSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		while(n-->0) {

			String num = br.readLine();
			String[] ns=num.split(" ");
			long sum=0;

			for(int i=1;i<ns.length;i++) {
				for(int j=i+1;j<ns.length;j++) {
					int a = Integer.parseInt(ns[i]);
					int b = Integer.parseInt(ns[j]);

					sum+=getGCD(a,b);
				}
			}

			System.out.println(sum);
		}

	}
	public static int getGCD(int a, int b) {
		if(a%b==0) {
			return b;
		}
		return getGCD(b,a%b);
	}
}
