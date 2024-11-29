package a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ROT13 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		
		for(int i=0;i<s.length();i++) {
			
			if(s.charAt(i)>='A' && s.charAt(i)<='M') {
				sb.append((char)(s.charAt(i)+13));
			}
			else if(s.charAt(i)>='N' && s.charAt(i)<='Z') {
				sb.append((char)(s.charAt(i)-13));
			}
			else if(s.charAt(i)>='a' && s.charAt(i)<='m') {
				sb.append((char)(s.charAt(i)+13));
			}
			else if(s.charAt(i)>='n' && s.charAt(i)<='z') {
				sb.append((char)(s.charAt(i)-13));
			}
			else if(s.charAt(i)==' ') {
				sb.append(" ");
			}
			else {
				sb.append(s.charAt(i));
			}
		}
		
		System.out.println(sb);
	}

}
