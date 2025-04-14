package BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
숫자를 이어붙였을 때
한자리 수 1~9는 1자리씩 9개 == 9*1줄
두자리 수 10~99는 2자리씩 90개 == 90*2줄
세자리 수 100~999는 3자리씩 900개 == 900*3줄
......
이 코드는 k에 맞춰 자릿수들을 스킵하고,
목표로 한 곳의 숫자만 때고 그 숫자의 필요한 하나의 부분만 때서 답으로 제출하는 코드이다.
*/
public class NumContinue_1790 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long tmp_k = k; //간추릴 인덱스
        long len = 1;   //스킵할 자릿수
        long num_cnt = 9;
        long res = 0;	//몇 자리수들을 지나쳐왔고, 현재 위치한 수를 표기하는 변수(인덱스가 아니라 실제 수)
        
        
        //먼저 한 자리에서 몇 n 자리 수를 스킵할 수 있는 지 검사
        //예제에서 k=23이니 한 자리 수들 9*1줄을 스킵가능하니
        //더 가야할 인덱스(tmp_k)는 14가 된다
        while(tmp_k > num_cnt * len)
        {
            tmp_k -= num_cnt * len;
            res += num_cnt;
            
            num_cnt *= 10;
            len++;
        }
        
        //실제 수를 구하기 위한 +1, 2자리를 수를 지나왔다면 99를 지나왔으니 100부터 이동하는 것
        //(tmp_k-1): res는 현재 위한 곳의 수를 '통째'로 가져와야함
        //예시로 k가 11면 res는 10을 가져오고 밑의 코드에서 
        res = (res+1) + ((tmp_k-1) / len);

        if(res > n) System.out.print(-1);
        else
        {
            int idx = (int)((tmp_k-1) % len);
            System.out.print(String.valueOf(res).charAt(idx));
        }
	}

}
