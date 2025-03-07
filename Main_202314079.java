package lab3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_202314079 {

	public static void main(String[] args) throws IOException {
		System.out.println("lab3_2:송대원");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int nums[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//배열
		for(int i=0;i<n;i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		
		//최솟값 찾기
		int min = nums[0];
		for(int i=1;i<n;i++) {
			if(min>nums[i]) {
				min=nums[i];
			}
		}
		
		//최솟값을 저장한 인덱스 찾기
		for(int i=0;i<n;i++) {
			if(min==nums[i]) {
				System.out.print(i+" ");
			}
		}
	}

}