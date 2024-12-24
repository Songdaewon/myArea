package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class NandM12 {
	static int n,m;
	static int nums[], arr[];
	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];

		st = new StringTokenizer(br.readLine());
		nums = new int[n];
		for(int i=0;i<n;i++) 
			nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);

		dfs(0);
		for(String i:set) {
			System.out.println(i);
		}
	}

	static void dfs(int depth) {
		if(depth==m) {
			for(int i=0;i<m;i++) {
				if(i==0) sb.append(arr[i]+" ");
				else if(arr[i-1]<=arr[i]) {
					sb.append(arr[i]+" ");
				}
				else if(arr[i-1]>arr[i]){
					sb.setLength(0);
					return;
				}
				
			}
			set.add(sb.toString());
			sb.setLength(0);

			return;
		}

		for(int i=0;i<n;i++) {
			arr[depth]=nums[i];
			dfs(depth+1);
		}
	}
}
