package LineUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PointArray_11650 {

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
			if(a[0]==b[0]) { // 0번째 열의 값이 같다면
				return a[1]-b[1]; //1번째 열을 기준으로 정렬하고
			}
			else {
				return a[0]-b[0]; //아니라면 0번째를 기준으로 정렬
			}
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
