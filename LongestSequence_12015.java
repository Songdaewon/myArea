package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//
public class LongestSequence_12015 {
	
	static int n;
	static int[] seq;
	static int[] lts;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		
		seq = new int[n];
		lts = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		lts[0]=seq[0];
		int len = 1;
		//맨 처음 idx0번은 고정으로 하고, 1번 부터 전번의 값보다 더 크다면 일단 수열에 붙여넣는다.
		for(int i=1;i<n;i++) {
			int key = seq[i];
			
			if(lts[len-1]<key) {
				len++;
				lts[len-1]=key;
			}
			//더 작다면 이분 탐색
			//자신보다 작은 값이 나올 때까지 계속 탐색을 진행.
			//더 작은 값이 나왔다면 그 값 바로 뒤의 값을 대처한다.
			else {
				int lo=0;
				int hi=len;
				
				while(lo<hi) {
					int mid=(lo+hi)/2; //이분탐색
					
					if(lts[mid]>=key) {
						hi = mid;	
					}
					else{
						lo=mid+1;
					}
				}
				
				lts[lo]=key;
			}
		}
		System.out.println(len);
	}

}






