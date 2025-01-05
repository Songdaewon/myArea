package part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Inequality_2529 {
	
	static int k;
	static boolean v[];
	static String a[];

	static List<String> list = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		v = new boolean[10];
		a = new String[k];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++) {
			a[i]=st.nextToken();
		}
		
		dfs("",0);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}

	static void dfs(String str,int idx) {
		if(idx==k+1) {
			list.add(str);
			return;
		}
		
		for(int i=0;i<10;i++) {
			if(!v[i]) {
				if(idx==0||check(Character.getNumericValue(str.charAt(idx-1)),i ,a[idx-1])) {
					v[i]=true;
					dfs(str+i,idx+1);
					v[i]=false;
				}
			}
		}
	}
	static boolean check(int a,int b,String ine) {
		
		if(ine.equals(">")) {
			if(a<b) return false;
		}
		else if(ine.equals("<")) {
			if(a>b) return false;
		}
		
		return true;
	}
}
