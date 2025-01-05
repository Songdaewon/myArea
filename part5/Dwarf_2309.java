package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Dwarf_2309 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dwarf[]=new int[9];
		int sum=0;
		
		for(int i=0;i<9;i++) {
			dwarf[i]=Integer.parseInt(br.readLine());
			sum+=dwarf[i];
		}
		
		int spy1=0,spy2=0;
		for(int i=0;i<8;i++) {
			if(spy1!=0&&spy2!=0) break;
			
			for(int j=1;j<9;j++) {
				if(sum-dwarf[i]-dwarf[j]==100) {
					spy1=dwarf[i];
					spy2=dwarf[j];
					break;
				}
			}
		}
		Arrays.sort(dwarf);
		for(int i=0;i<9;i++) {
			if(dwarf[i]!=spy1&&dwarf[i]!=spy2)
				System.out.println(dwarf[i]);
		}
	}

}
