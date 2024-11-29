package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SugerDelivery_2839 {
	static int count=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		while(n>0) {
			if(n==2||n==1) {
				count=-1;
				break;
			}
			
			if(n%5==0) {
				count+=n/5;
				break;
			}
			else {
				n-=3;
				count++;
			}
		}
		System.out.println(count);
	}

}

