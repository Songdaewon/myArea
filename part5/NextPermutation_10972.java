package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NextPermutation_10972 {
	static int n;
	static int[] num;

	static boolean found = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		num = new int[n];	
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}

		if (dfs()) {
			StringBuilder sb = new StringBuilder();
			for (int i : num) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}
	static boolean dfs() {
		
		//1.순열 중에서 내림차 부분을 찾고,
		//내림이 끝나는 부분의 인덱스를 i에 저장
		//ex 7 2 3 '(6) 5 4 1'
		//i = 3
		int i=num.length-1;
		while(i>0&&num[i-1]>num[i]) 
			i--;
		//1-2. 모든 부분이 내림차라면 제일 큰 수라 -1 출력
		if(i==0)
			return false;
		
		//2.A[j] > A [i-1]을 만족하면 j--를 한다.
		//7 2 (3) 6 5 (4) 1
		//j = 5
		int j=num.length-1;
		while (num[i - 1] >= num[j]) j--;
		
		//3. num[i-1]과 num[j]를 바꾼다.
		//7 2 (4) 6 5 (3) 1
		swap(i-1,j);
		
		//4. num[i]부터 num[num.length - 1]까지 뒤집는다.
		//7 2 4 '1 3 5 6'
		j = num.length - 1;
        while (i < j) {
            swap(i, j);
            i++; j--;
        }
        //이러면 나온다.
        return true;
	}
	static void swap(int a, int b) {
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }
}
