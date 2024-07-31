package sepFourth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main2005 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for(int t=0; t < testCase; t++) {
			int size = Integer.parseInt(br.readLine());
			int[] preLine = new int[10];
			preLine[0] = 1;
			bw.write("#" + (t + 1) + "\n" + 1 + "\n");

			for(int i=1; i < size; i++) {
				bw.write(1 + " ");
				int[] line = new int[i + 1];
				for(int j=0; j < i; j++) {
					line[j + 1] = preLine[j + 1] + preLine[j];
				}

				for(int j=1; j < i + 1; j++) {
					preLine[j] = line[j];
					bw.write(line[j] + " ");
				}
				bw.write("\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
