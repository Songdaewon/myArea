package a;

import java.io.*;
import java.util.*;
public class pp {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String str = br.readLine();
	    String answer="";
	    for(int i =0; i<str.length(); i++) {
			if(str.indexOf(str.charAt(i))==i)
				answer +=str.charAt(i);
		}
	    System.out.println(answer);
	    }
	}