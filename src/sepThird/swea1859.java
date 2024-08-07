package sepThird;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class swea1859 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		for(int t=1; t < test + 1; t++) {
			int days = Integer.parseInt(br.readLine());
			int[] prices = new int[days];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i < days; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			
			long benefit = 0;
			int idx = 0;
			while(idx < days) {
				int max = 0;
				int curIdx = idx;
				for(int i=idx; i < days; i++) {
					max = Math.max(max, prices[i]);
					if(max == prices[i]) idx = i;
				}
				
				for(int i=curIdx; i < idx; i++) {
					benefit += (long)(max - prices[i]);
				}
				
				idx++;
			}
			
			bw.write("#" + t + " " + benefit + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
