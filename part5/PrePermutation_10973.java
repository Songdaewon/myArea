package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrePermutation_10973 {
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

		int i=num.length-1;
		while(i>0&&num[i-1]<num[i]) 
			i--;

		if(i==0)
			return false;
		
		int j=num.length-1;
		while (num[i - 1] <= num[j]) j--;
		
		swap(i-1,j);
		
		j = num.length - 1;
        while (i < j) {
            swap(i, j);
            i++; j--;
        }

        return true;
	}
	static void swap(int a, int b) {
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }
}

