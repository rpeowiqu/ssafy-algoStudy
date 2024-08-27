package augFourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class baekjoon1339 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		String[] words = new String[num];
		int[] len = new int[num];
		int max = 0;
		for(int i=0; i < num; i++) {
			words[i] = br.readLine();
			len[i] = words[i].length();
			max = Math.max(max, len[i]);
		}
		
		int[][] values = new int[num][max];
		
	}
}
