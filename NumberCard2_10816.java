package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard2_10816 {
    static int n, m;
    static int[] arrN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arrN = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            sb.append(Upper(target)-Lower(target)+" ");

        }

        System.out.println(sb);



    }

    static int Upper(int target) {
        int left = 0;
        int right = n;
        while (left < right) {

            int mid = (left+right) / 2;
            if(target<arrN[mid]){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }

        return left;
    }

    static int Lower(int target) {
        int left = 0;
        int right = n;
        while (left < right) {

            int mid = (left+right) / 2;
            if(target<=arrN[mid]){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }

        return left;



    }
}
