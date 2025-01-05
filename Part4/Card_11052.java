package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Card_11052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] p = new int[n+1];
		int[] d = new int[n+1];

		for(int i=1;i<=n;i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		
		//d 배열에는 카드를 사는 경우의 수들을 넣는다.
		//d[1]은 카드 한장을 사는 경우이니 무조건 첫번째 것이 들어감
		//d[2]는 카드가 2개 들어있는 팩과 d[1]을 두번 사는 경우의 수를 비교하는 것이다.
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				d[i] = Math.max(d[i], d[i-j]+p[j]);
			}

		}
		System.out.println(d[n]);
	}

}
