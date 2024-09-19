package julyFourth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for(int t=0; t < testCase; t++) {
			String[] size = br.readLine().split(" ");
			int areaSize = Integer.parseInt(size[0]);
			int racketSize = Integer.parseInt(size[1]);
			int[][] area = new int[areaSize][areaSize];

			for(int i=0; i < areaSize; i++) {
				String[] row = br.readLine().split(" ");
				for(int j=0; j < areaSize; j++) {
					area[i][j] = Integer.parseInt(row[j]);
				}
			}

			int maxKill = 0;
			for(int i=0; i < areaSize - racketSize + 1; i++) {
				for(int j=0; j < areaSize - racketSize + 1; j++) {
					int curKill = 0;
					for(int y = 0; y < racketSize; y++) {
						for(int x = 0; x < racketSize; x++) {
							curKill += area[i + y][j + x]; 
						}
					}

					maxKill = Math.max(maxKill, curKill);
				}
			}

			bw.write("#" + (t + 1) + " " + maxKill + "\n");
		}
		bw.flush();
		bw.close();
	}
}

