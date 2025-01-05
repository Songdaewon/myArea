package Part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeFactorization {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int so = 2;
		while(n!=1) {
			
			if(n%so==0) {
				System.out.println(so);
				n/=so;
				so=2;
			}
			else ++so;
		}
	}

}
