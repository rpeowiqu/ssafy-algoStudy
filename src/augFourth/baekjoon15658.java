package augFourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon15658 {
	static int max, min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[num];
		for(int i=0; i < num; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int[] operators = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
		
		calculate(0, num - 1, 1, nums[0], nums, operators);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void calculate(int depth, int limit, int idx, int num, int[] nums, int[] operators) {
		if(depth == limit) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		if(idx == nums.length) return;
		
		for(int i=0; i < 4; i++) {
			if(operators[i] != 0) {
				operators[i]--;
				if(i == 0) calculate(depth + 1, limit, idx + 1, num + nums[idx], nums, operators);
				else if(i == 1) calculate(depth + 1, limit, idx + 1, num - nums[idx], nums, operators);
				else if(i == 2) calculate(depth + 1, limit, idx + 1, num * nums[idx], nums, operators);
				else calculate(depth + 1, limit, idx + 1, num / nums[idx], nums, operators);
				operators[i]++;
			}
		}
	}
}
