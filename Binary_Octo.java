package Part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Binary_Octo {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = "20";
	    
	    int i = Integer.parseInt(a,17);
	    String oc = Integer.toString(i,8);
	    System.out.println(i);
	    System.out.println(oc);
	}

}
