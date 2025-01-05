package Part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindPrime {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a =Integer.parseInt(st.nextToken());
		int b =Integer.parseInt(st.nextToken());
		
		for(int i=a;i<=b;i++) {
			if(i==1) continue;
			
			boolean isp = true;
			for(int j=2;j<=Math.sqrt(i);j++) {
				
				if(i%j==0) {
					isp=false;
					break;
				}
			}
			if(isp==true) {
				System.out.println(i);
			}		
		}
	}

}
