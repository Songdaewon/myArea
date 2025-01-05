package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB2_17404 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());

		int dp[][] = new int[n][3];
		int rgb[][]= new int[n][3];
		int min[]  = new int[3];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<=2;j++) {
				rgb[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//처음에 빨강을 고르고 선택을 이어나간 경우, 초록의 경우 파랑의 경우를 돌아서 봄
		for(int i=0;i<n;i++) { 
			for(int j=0;j<3;j++) {
				if(i==j) { 
					dp[0][j]=rgb[0][j];
				}
				else {//빨강이 선택됐다면 나머지 초록, 파랑은 제외됨
					dp[0][j]=1001;
				}
			}
			
			for(int j=1;j<n;j++) {
				dp[j][0]=Math.min(dp[j-1][1], dp[j-1][2])+rgb[j][0];
				dp[j][1]=Math.min(dp[j-1][0], dp[j-1][2])+rgb[j][1];
				dp[j][2]=Math.min(dp[j-1][0], dp[j-1][1])+rgb[j][2];
				
				if(j==n-1) { //마지막 색은 처음 색과 같으면 안되기에 예외처리
					if(i==0) {  //빨강일 시, 마지막은 초록 혹은 파랑
						min[0]=Math.min(dp[n-1][1], dp[n-1][2]);
					}
					else if(i==1) {  //초록
						min[1]=Math.min(dp[n-1][0], dp[n-1][2]);
					}
					else if(i==2) {  //파랑
						min[2]=Math.min(dp[n-1][1], dp[n-1][0]);
					}
				}
			}
		}
		System.out.print(Math.min(min[0],Math.min(min[1],min[2])));
	}

}
