package augFirst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class swea1979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		for(int t=1; t < test + 1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			int[][] puzzle = new int[size][size];
			
			for(int i=0; i < size; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j < size; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			for(int i=0; i < size; i++) {
				for(int j=0; j < size; j++) {
					int len = 0;
					if(puzzle[i][j] == 1) {
						while(j < size && puzzle[i][j] == 1) {
							j++;
							len++;
						}
						if(len == length) {
							answer++;
						}
					}
				}
			}
			
			for(int j=0; j < size; j++) {
				for(int i=0; i < size; i++) {
					int len = 0;
					if(puzzle[i][j] == 1) {
						while(i < size && puzzle[i][j] == 1) {
							i++;
							len++;
						}
						if(len == length) {
							answer++;
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}
}
