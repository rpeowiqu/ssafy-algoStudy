package julFourth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class practice_A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		for(int t=1; t < test + 1; t++) {
			int size = Integer.parseInt(br.readLine());
			String[][] mexinos = new String[size][size];
			for(int i=0; i < size; i++) {
				mexinos[i] = br.readLine().split(" ");
			}
			
			
		}
	}
}
