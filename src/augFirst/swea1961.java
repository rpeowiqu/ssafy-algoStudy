package augFirst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class swea1961 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		for(int t=1; t < test + 1; t++) {
			int size = Integer.parseInt(br.readLine());
			int[][] arr = new int[size][size];
			
			for(int i=0; i < size; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j < size; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#" + t);
			
			for(int i=0; i < size; i++) {
				for(int j=0; j < size; j++) {
					System.out.print(arr[size - 1 - j][i]);
				}
				
				System.out.print(" ");
				for(int j=0; j < size; j++) {
					System.out.print(arr[size - 1 - i][size - 1 - j]);
				}
				
				System.out.print(" ");
				for(int j=0; j < size; j++) {
					System.out.print(arr[j][size - 1 - i]);
				}
				
				System.out.println();
			}
		}
	}
}
