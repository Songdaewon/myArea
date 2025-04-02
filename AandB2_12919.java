package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//A와 B 1과 2 풀이가 다른 이유
//1은 뒤만 보면 되어서 나뉘는 부분 없이 하나만 하면 된다.
//2는 앞과 뒤를 동시에 봐야 하며 둘 중 하나만 가능하여
//앞을 먼저 할지 뒤를 먼저 할 지에 따라 정답일 수도 있고, 아닐 수 있기에 dfs가 맞다.
public class AandB2_12919 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String t = br.readLine();

		System.out.println(dfs(s,t));
	}

	private static int dfs(String s, String t) {
		
		if(s.length()==t.length()) {
			if(s.equals(t))
				return 1;
			else
				return 0;
		}
		
		//A분기와 B분기 둘 중 하나만 성공해도 1이 되기에 재귀에서 1이 리턴 아니면 0
		int ans = 0;
		
		//맨 앞이 B라면 B 제거 후 뒤집기
		if(t.charAt(0)=='B') {
			StringBuilder sb = new StringBuilder(t.substring(1));
			ans += dfs(s, sb.reverse().toString());
		}
		//A는 그냥 지우기
		if(t.charAt(t.length()-1)=='A') {
			ans += dfs(s, t.substring(0,t.length()-1));
		}
		return ans>0 ? 1:0;
	}

}








