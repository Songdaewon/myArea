package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class W_Association_2775 {
	static int[][] apt = new int[15][15];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1;i<15;i++) {
			apt[0][i]=i;
			apt[i][1]=1;
		}
		
		for(int i=1;i<15;i++) { //i는 층
			
			for(int j=2;j<15;j++) { //j는 호
				//문제에서 제시한 규칙은 i층 바로 밑의 j호 까지 더하는 것이지만
				//바로 왼쪽 호와 밑의 층 호의 값을 더한 것도 가능하다
				apt[i][j]=apt[i-1][j]+apt[i][j-1];
				
			}
		}
		
		while(t-->0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(apt[k][n]);
		}
	}

}
