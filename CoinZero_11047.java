package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinZero_11047 {
	static int n,k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int coin[] = new int[n];
		
		for(int i=0;i<n;i++) {
			coin[i]=Integer.parseInt(br.readLine());
		}
		
		int count=0;
		for(int i=n-1;i>=0;i--) {
			if(coin[i]<=k) {
				count+=k/coin[i];
				k=k%coin[i];
			}
		}
		System.out.println(count);
	}

}
