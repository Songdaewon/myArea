package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Router_2110 {

public static int[] house;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		house = new int[N];
		
		for(int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house);	
		
		
		int lo = 1;		
		int hi = house[N - 1] - house[0] + 1;	
		
		while(lo < hi) {	
			int mid = (hi + lo) / 2;
			
			if(canInstall(mid) < M) {
				hi = mid;
			}
			else {
				lo = mid + 1;
			}
		}
		System.out.println(lo - 1);
	}
	
	public static int canInstall(int distance) {
		
		int count = 1;
		int lastLocate = house[0];
		
		for(int i = 1; i < house.length; i++) {
			int locate = house[i];
		
			if(locate - lastLocate >= distance) {
				count++;
				lastLocate = locate;
			}
		}
		return count;
		
	}
}
