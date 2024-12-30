package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MakePassword {
	static int l,c;
	static boolean[] visit;
	static String[] arr;
	static StringBuilder sb= new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		visit = new boolean[c];
		arr = new String[c];


		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0;i<c;i++) {
			arr[i]=st2.nextToken().toString();
		}
		Arrays.sort(arr);
		dfs(0,0);


	}
	static void dfs(int start, int count) {
		if(count == l) { 
			int a=0;
			int b=0;
			int i=0;
			for(String s:arr) {
				if(visit[i++]) {
					sb.append(s);

					if(s.equals("a")||s.equals("e")||s.equals("i")||s.equals("o")||s.equals("u")) {
						a++;
					}
					else {
						b++;
					}
				}
			}
			if (a >= 1 && b >= 2) {
				System.out.println(sb);
			}
			sb.setLength(0);

		}

		for(int i=start;i<c;i++) {
			if(!visit[i]) {
				visit[i]=true;
				dfs(i+1,count+1);
				visit[i]=false;
			}
		}
	}
}
