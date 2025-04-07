package LineUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PointArray2_11651 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][2];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(arr,(a,b)->{
			if(a[1]==b[1]) {
				return a[0]-b[0];
			}
			else
				return a[1]-b[1];
		});
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<2;j++) {
				bw.write(arr[i][j]+" ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}