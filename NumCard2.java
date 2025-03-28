package DivideandConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumCard2 {


	//찾으려는 값의 '맨 앞의 인덱스 - 맨 뒤의 인덱스 + 1 = 찾는 값들의 개수'
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] num=new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		
		//중요: 오름차 정렬
		Arrays.sort(num);

		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			
			int find=Integer.parseInt(st.nextToken());
			
			bw.write(FindEndIdx(num,find)-FindStartIdx(num,find)+" ");
			
		}
		br.close();
        bw.flush();
        bw.close();
	}
	
	//두 함수 다 left와 right를 갖게해 찾는 값의 인덱스를 리턴하는 함수이지만 차이가 있다.
	//찾았다면 right를 땡겨와 앞에 있는 값의 인덱스를 찾는 함수
	private static int FindStartIdx(int[] arr,int find) {
		int left = 0;
		
		//원래 length-1을 해야하지만 그냥 사용함으로서 +1을 한 셈이다.
		int right = arr.length;

		while(left<right) { 
			int mid = (left+right)/2;
			if(find<=arr[mid]) {	//찾거나 값이 더 왼쪽에 있다면
				right=mid;
			}
			else {					//찾는 값이 오른쪽에 있다면   
				left = mid+1;
			}
		}
		
		return left;
	}
	
	//찾았다면 left를 땡겨와 맨 뒤에 있는 인덱스를 찾는 함수
	private static int FindEndIdx(int[] arr,int find) {
		int left = 0;
		
		int right = arr.length;

		while(left<right) { 
			int mid = (left+right)/2;
			
			//대소부호만 달라짐
			if(find<arr[mid]) { //찾는 값이 보다 왼쪽에 있다면
				right=mid;
			}
			else {              //찾거나 오른쪽에 있다면
				left = mid+1;
			}
		}
		
		return left;
	}
	
	
}