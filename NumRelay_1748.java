package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumRelay_1748 {

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num=10;
		int re=1;
		int count=0;
		for(int i=1;i<=n;i++) {
			if(i%num==0)
			{
				re++;
				num*=10;
			}
			count+=re;
		}
		
		
		System.out.println(count);
	}

}
