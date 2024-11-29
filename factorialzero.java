package Part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class factorialzero {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int zcount=0;
		
		while(n>=5) {
			
			zcount += n/5;
			n = n/5;
			
		}
		
		System.out.println(zcount);
	}
}
