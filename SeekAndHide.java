package Part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SeekAndHide {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] dis = new int[n];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			dis[i]=Math.abs(s-Integer.parseInt(st2.nextToken()));
		}
		
		int g=dis[0];
		for(int i=0;i<n;i++) {
			g = Gcd(g,dis[i]);
		}
		
		System.out.println(g);
		
	}
	static int Gcd(int a,int b) {
		if(a%b==0) return b;
		
		return Gcd(b,a%b);
		
	}
}
