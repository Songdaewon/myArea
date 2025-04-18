package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//찾으려는 값의 상한 - 하한
public class NumCard_10816 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++) {
			int find=Integer.parseInt(st.nextToken());

			sb.append(upper(arr, find)-lower(arr,find)+" ");
		}
		System.out.println(sb);
	}

	private static int lower(int[] arr, int find) {
		int lo=0;
		int hi=arr.length;
		
		while(lo<hi) {
			int mid = (lo+hi)/2;
			
			if(find<=arr[mid]) {
				hi=mid;
			}
			else {
				lo=mid+1;
			}
		}
		return lo;
	}

	private static int upper(int[] arr, int find) {
		int lo=0;
		int hi=arr.length;
		
		while(lo<hi) {
			int mid = (lo+hi)/2;
			
			if(find<arr[mid]) {
				hi=mid;
			}
			else {
				lo=mid+1;
			}
		}
		return lo;
	}

}












