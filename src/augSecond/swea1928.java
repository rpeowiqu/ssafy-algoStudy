package augSecond;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1928 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charGraph = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
		StringBuilder sb = new StringBuilder();
		StringBuilder decodedStc = new StringBuilder();
		
		int test = Integer.parseInt(br.readLine());
		for(int t=1; t < test + 1; t++) {
			char[] encodedStc = br.readLine().toCharArray();
			
			int idx = 0;
			while(idx < encodedStc.length) {
				for(int i=0; i < charGraph.length; i++) {
					if(encodedStc[idx] == charGraph[i]) {
						sb.append(String.format("%6s", Integer.toBinaryString(i)).replace(" ", "0"));
						break;
					}
				}
				
				if(idx % 4 == 3) {
					decodedStc.append((char)Integer.parseInt(sb.toString().substring(0, 8), 2));
					decodedStc.append((char)Integer.parseInt(sb.toString().substring(8, 16), 2));
					decodedStc.append((char)Integer.parseInt(sb.toString().substring(16, 24), 2));
					sb.setLength(0);
				}

				idx++;
			}
			
			System.out.println("#" + t + " " + decodedStc);
			decodedStc.setLength(0);
		}
	}
}
