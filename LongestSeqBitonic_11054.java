package Part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestSeqBitonic_11054 {

	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n=Integer.parseInt(br.readLine());
    	
    	int dpl[] = new int[n+1];
    	int dpr[] = new int[n+1];
    	int arr[] = new int[n+1];

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	for(int i=1;i<=n;i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
    		dpl[i]=1;
        	dpr[i]=1;
    	}
    	
    	for(int i=2;i<=n;i++) {
    		for(int j=1;j<i;j++) {
    			if(arr[i]>arr[j]&&dpl[i]<=dpl[j]) {
    				dpl[i]=dpl[j]+1;
    			}
    		}
    		
    	}
    	
		for(int i=n-1;i>=1;i--) {
			for(int j=n;j>i;j--) {
				if(arr[i]>arr[j]&&dpr[i]<=dpr[j]) {
					dpr[i]=dpr[j]+1;
				}
			}
		}
		
		int max=0;
		for(int i=1;i<=n;i++) {
			max=Math.max(dpr[i]+dpl[i], max);
		}
		System.out.println(max-1);
	}

}
