package a;

import java.io.*;
public class Alphabet {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		
		String n = br.readLine();
		int[] alpha = new int[26];
		
		
		
		for(int i=0;i<n.length();i++) {
			char c = n.charAt(i);
			alpha[c-'a']++;
		}
		
		for(int i=0;i<26;i++) {
			System.out.print(alpha[i]+" ");
		}
		
	}

}
