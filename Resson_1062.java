package part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Resson_1062 {
	static int n,k;
	static String word[];
	static boolean alpha[] = new boolean[26];
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        word = new String[n];
        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();
        }
        //맨 앞 anta와 tica는 항상 사용됨, 총 필요 단어는 5개로 최소 k는 자동으로 5다.
        alpha['a' - 'a'] = true;
        alpha['n' - 'a'] = true;
        alpha['t' - 'a'] = true;
        alpha['i' - 'a'] = true;
        alpha['c' - 'a'] = true;
        
        if(k<5) {
        	System.out.println(max);
        }
        else {
        	dfs(0,0);
        	System.out.println(max);
        }
	}
	static void dfs(int idx,int cnt) {
		//+5는 a,n,t,i,c, 단어를 요구 개수만큼 배웠다면 이제 최댓값을 갱신할 차례
		if (cnt + 5 == k) {
            countWord();
            return;
        }
		
		for(int i=idx;i<26;i++) {
			if(alpha[i]) { //이미 배운 단어는 패스
				continue;
			}
			else {
				alpha[i]=true;
				//예를 들어 가장 먼저 배우는 단어는 b니까
				//다음 dfs에선 b 이후에 배우는 단어들 부터 for문을 돌림
				dfs(i+1,cnt+1);
				//최댓값 갱신 후, 경우의 수를 처음부터 갱신하기 위해 false로 초기화
				alpha[i]=false;
			}
		}
	}
	public static void countWord() {
		int cnt=0;
		for(int i=0;i<n;i++) {
			char[] alphas = word[i].toCharArray();
			boolean flag = true;
			
			for(char c:alphas) {
				//만약 이미 배운 문자들로 주어진 문자열을 만들 수 없다면
				if(!alpha[c-'a']) {
					flag=false;
					break;
				}
			}
			//만약 문자열을 구성할 수 있다면
			if(flag) {
				cnt++;
			}
		}
		max=Math.max(max, cnt);
	}

}









