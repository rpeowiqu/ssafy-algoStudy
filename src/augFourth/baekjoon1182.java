package augFourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1182 {
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[num];
		for(int i=0; i < num; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0, 0, target, nums);
		if(target == 0) ans--;
		System.out.println(ans);
	}
	
	static void subset(int idx, int sum, int target, int[] nums) {
		if(idx == nums.length) {
			if(sum == target) {
				ans++;
			}
			return;
		}
		
		subset(idx + 1, sum + nums[idx], target, nums);
		subset(idx + 1, sum, target, nums);
	}
}
