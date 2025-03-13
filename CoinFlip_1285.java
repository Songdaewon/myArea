package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//각 행과 열에는 뒤집거나, 뒤집지 않거나 두 가지의 경우의 수 존재 2^N
//N<=20이므로 행과 열 모두 따진다면 2^40으로 시간초과 발생. 행과 열 중 하나의 경우의 수만 찾기
//행을 기준으로 문제를 푼다.

//N이 3일시 (1000==8) 
//for(int i=0; i < (1<<N); i++) == 0 ~ 2^N-1,  1<<N 대신 (int)Math.pow(2, N) 사용 가능
//N이 3일때, 0 ~ 7
public class CoinFlip_1285 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());
		char coin[][] = new char[n][n];

		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				coin[i][j] = s.charAt(j);
			}
		}

		int min = Integer.MAX_VALUE;
		for(int i=1;i<(int)Math.pow(2, n);i++) {

			int sum=0;
			for(int j=0;j<n;j++) {
				int back=0;
				for(int k=0;k<n;k++) {
					char cur = coin[k][j];
					
					//i의 이진수 값과 1이 하나라도 겹친다면 그 행을 뒤집는다.
					if((i&(int)Math.pow(2, k))!=0) {
						cur = reverse(cur);
					}
					if(cur == 'T')
			            back++;
				}
				//이번엔 열을 뒤집을지 말지를 정한다
				//해당 열의 T와 H를 비교한다. T가 더 적으면 그대로 더한다.
				//T의 개수와 H의 개수 중 더 적은 것을 더하는 것인데,
				//H보다 T가 많으면 H의 수를 넣는다. == 그 열을 뒤집고, T의 수를 넣은 것이다.
				sum += Math.min(back, n-back);
			}
			min = Math.min(min, sum);
		}
		System.out.println(min);

	}

	private static char reverse(char cur) {
		if(cur=='T')
			return 'H';
		else
			return 'T';
	}

}
