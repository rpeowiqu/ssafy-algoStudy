package augSecond;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class swea1959 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		for(int t=1; t < test + 1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ALen = Integer.parseInt(st.nextToken()); // arrA 길이
			int BLen = Integer.parseInt(st.nextToken()); // arrB 길이
			
			int[] arrA = new int[ALen];
			int[] arrB = new int[BLen];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i < ALen; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i < BLen; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			
			if(ALen < BLen) { // arrB가 더 크면
				for(int i=0; i < BLen - ALen + 1; i++) { // arrB 앞에서부터
					int sum = 0;
					for(int j=0; j < ALen; j++) { // arrA값 곱해서 sum 구하기
						sum += arrB[i + j] * arrA[j];
					}
					max = Math.max(max, sum); // max값 갱신
				}
			} else { // arrA가 더 크면
				for(int i=0; i < ALen - BLen + 1; i++) { // arrA 앞에서부터
					int sum = 0;
					for(int j=0; j < BLen; j++) { // arrB값 곱해서 sum 구하기
						sum += arrA[i + j] * arrB[j];
					}
					max = Math.max(max, sum); // max값 갱신
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
}
