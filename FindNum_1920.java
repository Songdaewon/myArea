package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNum_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN); //이분탐색을 위한 정렬

        int M = Integer.parseInt(br.readLine());
        int[] arrM = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        boolean isFind = false;
        StringBuffer sb = new StringBuffer();

        int idxM=0;      //순서대로 검색할 M의 요소 인덱스
        int target;      //검색할 요소

        while(idxM<M) {
            target = arrM[idxM];

            int left=0;      //N의 맨 왼쪽 인덱스
            int right=N-1;   //N의 맨 오른쪽 인덱스

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arrN[mid] > target){ //답은 왼편에 있을 것
                    right=mid-1;
                }
                else if (arrN[mid] < target){ //답은 오른편에 있을 것
                    left=mid+1;
                }
                else{
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                sb.append("1\n");
                isFind = false;
            }
            else
                sb.append("0\n");

            idxM++;
        }

        System.out.println(sb.toString());
    }
}
