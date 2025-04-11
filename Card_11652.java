package LineUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Card_11652 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		long arr[] = new long[n];
		for(int i=0;i<n;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		
		int count[] = new int[n];
		count[0]=1;
		
		int max=1;
		long maxN=arr[0];
		for(int i=1;i<n;i++) {
			count[i]=1;
			if(arr[i]==arr[i-1])
				count[i]=count[i-1]+1;
			
			if(count[i]>max) {
				max=count[i];
				maxN=arr[i];
			}
		}
		
		bw.write(maxN+"");
		br.close();
		bw.flush();
		bw.close();
		
	}

}
