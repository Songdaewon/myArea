package a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alphabet2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder s2 = new StringBuilder();
		
		String s = br.readLine();

		int[] a = new int[26];
		
		for(int i=0;i<26;i++) {
			a[i] =-1;
		}
		
		for(int i=0;i<s.length();i++) {
			
			if(s.indexOf(s.charAt(i))==i)
				s2.append(s.charAt(i));
			
			else if(s.indexOf(s.charAt(i))!=i)
				s2.append('#');
		}
		
		for(int i=0;i<s2.length();i++) {
			char ch = s2.charAt(i);
			if(ch=='#') 
				continue;
			
			int idx = ch-'a';
			a[ch-'a'] = i;
		}
		
		for(int i=0;i<26;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
