package augFourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon14225 {
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		min = Integer.MAX_VALUE;
		
		int num = Integer.parseInt(br.readLine());
		int[] nums = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i < num; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		int[] sortedNums = new int[num];
		for(int i=0; i < num; i++) { // dfs가 맨 뒤에서부터 하나씩 돌테니 내림차순으로 정렬
			sortedNums[i] = nums[num - 1 - i];
		}
		findMin(0, 0, sortedNums);
		System.out.println(min);
	}
	
	static void findMin(int idx, int sum, int[] arr) {
		if(idx == arr.length) {
			if(min == sum) min++;
			else min = Math.min(min, sum + 1);
			return;
		}
		
		findMin(idx + 1, sum, arr);
		findMin(idx + 1, sum + arr[idx], arr);
	}
}
