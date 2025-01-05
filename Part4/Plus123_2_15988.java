package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Plus123_2_15988 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int[] ns = new int[1000001];
		ns[1]=1;
		ns[2]=2;
		ns[3]=4;
		while(t-->0) {
			
			int n = Integer.parseInt(br.readLine());
			
			for(int i=4;i<=1000000;i++) {
				if(ns[i]!=0) continue;
				ns[i] = (ns[i-1]+ns[i-2]+ns[i-3]);
			}
			System.out.println(ns[n] % 1000000009);
		}
	}

}
