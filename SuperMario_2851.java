package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperMario_2851{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] mush = new int[10];
		int check=0;
		for(int i=0;i<10;i++) {
			mush[i]=Integer.parseInt(br.readLine());
		}
		
		int n=0;
		for(int i=0;i<10;i++) {
			check+=mush[i];
			if(check>=100) {
				n=i;
				break;
			}
		}
		
		int x=Math.abs(100-check);
		int y=Math.abs(100-(check-mush[n]));
		if(x>y) {
			System.out.println(check-mush[n]);
		}
		else if(x<y) {
			System.out.println(check);
		}
		else if(x==y) {
			System.out.println(Math.max(check-mush[n], check));
		}
		
	}
}
