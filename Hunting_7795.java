package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//배열 내 위치 찾는 건 low <= hi 사용
public class Hunting_7795 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int al = Integer.parseInt(st.nextToken());
			int bl = Integer.parseInt(st.nextToken());
			
			int a[] = new int[al];
			int b[] = new int[bl];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<al;i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<bl;i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			//b정렬 후 a값 기준으로 b를 이분 탐색
			Arrays.sort(b);
			int temp=0;
			for(int i=0;i<al;i++) {
				
				int low=0;
				int hi = bl-1;
				int cnt=0;
				
				while(low<=hi) {
					
					int mid = (low+hi)/2;
					//b값 보다 a가 크다면 쌍 하나 발견 성공
					if(b[mid]<a[i]) {
						low=mid+1; //더 높은 값 탐색
						cnt=mid+1; //해당 값보다 크다면 그 밑에 있는 값들 보다 큰 것이니 탐색을 안해도 된다.
					}
					//아니라면 더 낮은 값과의 비교
					else
						hi=mid-1;
				}
				temp+=cnt;
			}
			result.append(temp+"\n");
			
		}
		System.out.println(result);
	}

}
