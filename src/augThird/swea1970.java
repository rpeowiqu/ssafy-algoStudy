package augThird;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1970 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t < T + 1; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + "\n");
			int N = Integer.parseInt(br.readLine());
			int[] money = new int[8];
			while(N > 0) {
				int tmp = 0;
				if(N >= 50000) {
					tmp = N / 50000;
					N %= 50000;
					money[0] += tmp;
				} else if(N >= 10000) {
					tmp = N / 10000;
					N %= 10000;
					money[1] += tmp;
				} else if(N >= 5000) {
					tmp = N / 5000;
					N %= 5000;
					money[2] += tmp;
				} else if(N >= 1000) {
					tmp = N / 1000;
					N %= 1000;
					money[3] += tmp;
				} else if(N >= 500) {
					tmp = N / 500;
					N %= 500;
					money[4] += tmp;
				} else if(N >= 100) {
					tmp = N / 100;
					N %= 100;
					money[5] += tmp;
				} else if(N >= 50) {
					tmp = N / 50;
					N %= 50;
					money[6] += tmp;
				} else {
					tmp = N / 10;
					N %= 10;
					money[7] += tmp;
				}
			}
			
			for(int i=0; i < 8; i++) {
				sb.append(money[i] + " ");
			}
			
			System.out.println(sb.toString());
		}
	}
}
