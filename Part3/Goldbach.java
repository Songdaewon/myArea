package Part3;

import java.io.*;


public class Goldbach {
	static int max =1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//에라토스테네스의 체 = 해당 범위의 소수들을 한 번에 구할 수 있게하는 알고리즘
		//제일 작은 소수들을 제외하고 그 소수들의 배수들을 뺀 "나머지와 제일 작은 소수들이 그 범위의 소수다"
		boolean[] isp = new boolean[max+1];
		for(int i=2;i<=max;i++) {
			isp[i]=true;
		}
		for(int i=2;i<=Math.sqrt(max);i++) {
			for(int j=i*2;j<=max;j+=i) {
				if(!isp[j]) continue;
				isp[j]=false;
			}
		}

		while(true) {
			int n = Integer.parseInt(br.readLine());
			boolean gold = false;
			if(n==0) break;

			
			//i가 소수여야 n-i가 성립됨
			//두 수의 차가 가장 큰 것을 찾는 거고 결국 n-i를 하기에
			//작은 소수 부분만 찾으면 됨(n/2)
			for(int i=3;i<=n/2;i++) {
				if(isp[i]&&isp[n-i]) {
					System.out.println(n+" = "+i+" + "+(n-i));
					gold = true;
					break;
				}
			}
			if(!gold) {
				System.out.println("Goldbach's conjecture is wrong.");
				break;
			}
		}
		
		br.close();
	}

}
