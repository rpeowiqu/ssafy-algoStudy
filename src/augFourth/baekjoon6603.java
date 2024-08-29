package augFourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon6603 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		while(!line.equals("0")) {
			StringTokenizer st = new StringTokenizer(line);
			int num = Integer.parseInt(st.nextToken());
			int[] numbers = new int[num];
			for(int i=0; i < num; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			boolean[] visited = new boolean[num];
			int[] selected = new int[6];
			int idx = 0;
			int size = 0;
			
			lotto(0, 0, numbers, selected, visited);
			sb.append("\n");
			line = br.readLine();
		}
		
		System.out.println(sb.toString());
	}
	
	static void lotto(int depth, int idx, int[] numbers, int[] selected, boolean[] visited) {
		if(depth == 6) {
			for(int i=0; i < 6; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		if(idx == numbers.length) return;
		
		selected[depth] = numbers[idx];
		lotto(depth + 1, idx + 1, numbers, selected, visited);
		lotto(depth, idx + 1, numbers, selected, visited);
	}
}
