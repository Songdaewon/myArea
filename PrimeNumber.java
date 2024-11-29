package Part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimeNumber {
	//소수와 1를 제외한 일반 자연수들은 2와 자신들의 제곱근 사이에서 약수를 갖는다. 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int p=0;
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			boolean isp=true;
			if(num==1) continue;
			
			for(int i=2;i<=Math.sqrt(num);i++) {

				if(num%i==0) {
					isp=false;
					break;
				}
				
			}
			if(isp==true)
				p++;
		}
		System.out.println(p);
	}
}
