package sepThird;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class swea1926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		for(int i=1; i < num + 1; i++) {
			String[] elem = (i + "").split("");
			if((i + "").contains("3") || (i + "").contains("6") || (i + "").contains("9")) {
				for(int j=0; j < elem.length; j++) {
					if(elem[j].equals("3")) {
						bw.write("-");
					} else if(elem[j].equals("6")) {
						bw.write("-");
					} else if(elem[j].equals("9")) {
						bw.write("-");
					}
				}
				bw.write(" ");
				continue;
			}
			
			bw.write(i + " ");
		}
		
		bw.flush();
		bw.close();
	}
}
