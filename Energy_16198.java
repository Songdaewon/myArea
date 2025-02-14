package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Energy_16198 {
	static int n, max = Integer.MIN_VALUE;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) 
			list.add(Integer.parseInt(st.nextToken()));
		
		dfs(0);
		System.out.println(max);
	}
	static void dfs(int sum) {
		if(list.size()==2) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=1;i<list.size()-1;i++) {
			int temp = list.get(i);
			int erg = list.get(i-1)*list.get(i+1);
			list.remove(i);
			dfs(sum+erg);
			list.add(i,temp);
		}
	}
}







