package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_14888 {
	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int number[], oper[] = new int[4];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		number = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			number[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) 
			oper[i] = Integer.parseInt(st.nextToken());


		solution(number[0], 1);

		System.out.println(max);
		System.out.println(min);
	}

	static void solution(int num, int idx) {
		if(idx==n) {
			max = Math.max(num, max);
			min = Math.min(num, min);
			return;
		}

		for(int i=0;i<4;i++) {
			if(oper[i]>0) {
				oper[i]--;

				switch(i) {
				case 0:
					solution(num + number[idx], idx + 1);
					break;
				case 1:
					solution(num - number[idx], idx + 1);
					break;
				case 2:
					solution(num * number[idx], idx + 1);
					break;
				case 3:
					solution(num / number[idx], idx + 1);
					break;
				}
				oper[i]++;
			}
		}
	}
}







