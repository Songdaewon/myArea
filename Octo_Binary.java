package Part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Octo_Binary {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String n2 = Integer.toString(n,17);
		int i = Integer.parseInt(n2);
		
		System.out.println(n2);
		System.out.println(i);
	}

}
