package augThird;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1288 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t < T + 1; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] num = new int[10];
			
			int multiply = 1;
			int endNum = 0;
			while(true) {
				endNum = N * multiply++;
				boolean finish = true;
				String curNum = Integer.toString(endNum);
				for(int i=0; i < curNum.length(); i++) {
					if(num[curNum.charAt(i) - '0'] == 0) {
						num[curNum.charAt(i) - '0']++;
					}
				}
				
				for(int i=0; i < 10; i++) {
					if(num[i] == 0) {
						finish = false;
						break;
					}
				}
				
				if(finish) break;
			}
			
			System.out.println("#" + t + " " + endNum);
		}
	}
}
