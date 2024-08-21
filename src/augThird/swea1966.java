package augThird;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t < T + 1; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");
			int N = Integer.parseInt(br.readLine());
			int[] nums = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);
			for(int i=0; i < N; i++) {
				sb.append(nums[i] + " ");
			}
			
			System.out.println(sb.toString());
		}
	}
}
