package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Procession_1080 {
	static int n,m;
	static int[][] a,b;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		a = new int[n][m];
		b = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				b[i][j] = str.charAt(j) - '0';
			}
		}
		
		int cnt=0;
		
		//행렬 크기가 1 1,2 2면 작동을 안함 그래서 -1이 나옴
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				//두 개의 행렬이 다를때
				if (a[i][j] != b[i][j] && i + 2 < n && j + 2 < m) {
					for(int r=i; r<=i+2; r++) {
						for(int c=j; c<=j+2; c++) {
							//1이면 0, 0이면 1
							a[r][c] = a[r][c]==0 ? 1:0;
						}
					}
					cnt++;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(a[i][j]!=b[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
