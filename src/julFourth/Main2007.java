package julFourth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main2007 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		for(int t=0; t < testCase; t++) {
			String wordRepeat = br.readLine();
			boolean end = false;
			for(int i=1; i < 30; i++) {
				if(wordRepeat.charAt(i) == wordRepeat.charAt(0)) {
					if(i < 16 && wordRepeat.substring(0, i).equals(wordRepeat.substring(i, 2 * i))) {
						bw.write("#" + (t + 1) + " " + i + "\n");
						end = true;
						break;
					} else if(wordRepeat.substring(0, 30 - i).equals(wordRepeat.substring(i, 30))) {
						bw.write("#" + (t + 1) + " " + i + "\n");
						end = true;
						break;
					}
				}
			}

			if(!end) {
				bw.write("#" + (t + 1) + " " + 30 + "\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
