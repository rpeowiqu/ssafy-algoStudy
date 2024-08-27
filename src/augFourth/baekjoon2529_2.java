package augFourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2529_2 {
	static String min;
	static String max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		String[] inequality = br.readLine().split(" ");
		int[] selected = new int[num + 1];
		boolean[] visited = new boolean[10];
		min = "10000000000";
		max = "0";
		
		dfs(0, num + 1, inequality, selected, visited);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void dfs(int depth, int limit, String[] inequality, int[] selected, boolean[] visited) {
		if(depth == limit) {
			for(int i=0; i < limit - 1; i++) {
				if(inequality[i].equals("<") && selected[i] > selected[i + 1]) return;
				if(inequality[i].equals(">") && selected[i] < selected[i + 1]) return;
			}
			
			String temp = "";
			for(int i=0; i < limit; i++) {
				temp += Integer.toString(selected[i]);
			}
			min = String.format("%0" + limit + "d", Math.min(Long.parseLong(min), Long.parseLong(temp)));
			max = String.format("%0" + limit + "d", Math.max(Long.parseLong(max), Long.parseLong(temp)));
			return;
		}
		
		for(int i=0; i < 10; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[depth] = i;
				dfs(depth + 1, limit, inequality, selected, visited);
				visited[i] = false;
			}
		}
	}
}
