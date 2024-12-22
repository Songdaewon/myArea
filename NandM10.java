package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class NandM10 {
	static int n;
	static int m;
	static int arr[];
	static int num[];
	static int arr2[];
	static boolean visit[];
	static Set<String> set=new LinkedHashSet<>();
	static String str[];
	static StringBuilder sb= new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		num=new int[n];
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);

		arr=new int[m];
		arr2=new int[m];
		visit=new boolean[n];
		
		dfs(0);
		for(String i:set) {
			System.out.println(i);
		}
	}
	static void dfs(int depth) {
		if(depth==m) {
			for(int i=0;i<arr.length;i++) {
				arr2[i]=arr[i];
			}
			Arrays.sort(arr2);
			
			for(int i:arr2) {
				sb.append(i+" ");
			}
			set.add(sb.toString());
			sb.setLength(0);

			return;
		}

		for(int i=0;i<n;i++) {
			if(!visit[i]) 	{
				visit[i]=true;
				arr[depth]=num[i];
				dfs(depth+1);
				visit[i]=false;
			}
		}
	}

}