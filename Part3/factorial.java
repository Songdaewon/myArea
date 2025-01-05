package Part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class factorial {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int sum=fact(n);
		
		
		System.out.println(sum);
	}
	
	static int fact(int n) {
		if(n<=1) return 1;
		return n*fact(n-1);
	}


}
