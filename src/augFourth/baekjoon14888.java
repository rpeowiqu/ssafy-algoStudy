package augFourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon14888 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int[] numbers = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i < num; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		int[] opers = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i < 4; i++) {
			opers[i] = Integer.parseInt(st.nextToken());
		}
		
		
	}
}
