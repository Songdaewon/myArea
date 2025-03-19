package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//여자와 남자는 2:1
//먼저 짝을 만들어 짝의 수를 저장한다->남는 찌꺼기들을 인턴쉽에 보낸다
//그래도 인턴쉽에 더 보내야 한다면 만든 짝에서 보낸다. 한 짝당 3명이니 fair--후 k에서 3을 빼주면 된다.
public class ContestOrIntern {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//여자는 짝을 이루기 위해 무조건 2명 이상이어야 한다.
		if(n<2||m<1) {
			System.out.println(0);
			return;
		}
		
		int pair = Math.min(n/2,m);
		
		//나는 n%2로 생각했었으나 완전히 틀렸었음
		//여남 비는 2:1이니 pair당 2명의 여자가 있다. 
		//여자를 기준으로 pair를 정하면 n%2로 해도 되지만 남자가 기준이라면 n%2로 하면 안된다.
		int restN = n - 2*pair;
		int restM = m-pair;

		k -= restN+restM;
		
		//k를 0으로 만들 때까지
		while(k>0) {
			pair--;
			k-=3;
		}
		
		System.out.println(pair);
	}

}
