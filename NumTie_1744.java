package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NumTie_1744 {
	
	static int n;
    //양수, 큰 값 먼저 나옴
    static PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
    //음수, 작은 값 먼저 나옴
    static PriorityQueue<Integer> minus = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num<=0) { 	//0도 음수에
				minus.add(num);
			}
			else {
				plus.add(num);
			}
		}
		
		int ans = 0;
		
		while(!minus.isEmpty()) {
			int cur = minus.poll();
			
			if(minus.isEmpty()) {	//마지막 값일 때: 더한다는 선택지 말고는 없음
				ans+=cur;
				break;
			}
			
			//다음 값이 0이라면 0을 버리고 더하지 않음 = 0과 현재값을 더한 행위
			if(minus.peek()==0) {
				minus.poll();
			}
			//다음 값이 0이 아니라면 곱하면 됨
			else {					
				ans+=cur*minus.poll();
			}
		}
		
		while(!plus.isEmpty()) {
			int cur = plus.poll();
			
			if(plus.isEmpty()) {    //마지막 값
				ans += cur;
				break;
			}
			
			if(cur==1)  		    //1이라면 그냥 더하기: 곱하는 게 손해임
				ans+=1;
			else if(plus.peek()==1) //현재는 1이 아니지만 다음 값이 1이라면 둘이 더하기
				ans+=cur+plus.poll();
			else					//현재도 다음 값도 1이 아니라면 둘이 곱하기
				ans+=cur*plus.poll();
		}
		
		System.out.println(ans);
		br.close();
	}
}











