package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Triangle_1932 {
	static Integer dp[][];
	static int arr[][];
	static int n=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dp=new Integer[n][n];
		arr=new int[n][n];
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
		
			for(int j=0;j<i+1;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		
		}
		
		for(int i=0;i<n;i++) {
			dp[n-1][i]=arr[n-1][i];
		}
		
		System.out.println(find(0,0));
	}
	
	static int find(int d,int idx) {
		
		if(d==n-1) {
			return dp[d][idx];
		}
		
		if(dp[d][idx]==null) {
			dp[d][idx]=Math.max(find(d+1,idx), find(d+1,idx+1))+arr[d][idx];
		}
		
		return dp[d][idx];
	}

}
