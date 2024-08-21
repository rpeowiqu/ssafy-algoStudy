package augThird;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1945 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t < T + 1; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");
			int N = Integer.parseInt(br.readLine());
			int[] ans = new int[5];
			while(N != 1) {
				if(N % 2 == 0) {
					N /= 2;
					ans[0]++;
				} else if(N % 3 == 0) {
					N /= 3;
					ans[1]++;
				} else if(N % 5 == 0) {
					N /= 5;
					ans[2]++;
				} else if(N % 7 == 0) {
					N /= 7;
					ans[3]++;
				} else if(N % 11 == 0) {
					N /= 11;
					ans[4]++;
				}
			}
			
			for(int i=0; i < 5; i++) {
				sb.append(ans[i] + " ");
			}
			
			System.out.println(sb.toString());
		}
	}
}
