package a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		String[] str = new String[s.length()];
		
		for(int i=0;i<s.length();i++) {
			str[i] = s.substring(i, s.length());
		}
		
		Arrays.sort(str);
		
		for(String i : str) {
			System.out.println(i);
		}
		
	}

}
