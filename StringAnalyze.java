package a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringAnalyze {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while ((s = br.readLine()) != null) {
			int a = 0;
			int A = 0;
			int num = 0;
			int space = 0;
			
			for(int i=0;i<s.length();i++) {
				char ch = s.charAt(i);
				if(ch>='a'&& ch<='z') a++;
				else if(ch>='A'&& ch<='Z') A++;
				else if(Character.isDigit(ch)) num++;
				else if(ch==' ') space++;
			}
			
			System.out.println(a+" "+A+" "+num+" "+space);
		}
	}

}
