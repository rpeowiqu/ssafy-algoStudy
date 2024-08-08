package augSecond;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1928 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charGraph = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'}; // 인코딩 표
		StringBuilder sb = new StringBuilder(); // 디코딩 중간 이진수 변환용
		StringBuilder decodedStc = new StringBuilder(); // 답 출력용
		
		int test = Integer.parseInt(br.readLine());
		for(int t=1; t < test + 1; t++) {
			char[] encodedStc = br.readLine().toCharArray(); // 인코딩 된 문자열 char 배열로 받기
			
			int idx = 0; // 인코딩 된 문자열 디코딩 중 인덱스
			while(idx < encodedStc.length) {
				for(int i=0; i < charGraph.length; i++) {
					if(encodedStc[idx] == charGraph[i]) {
						sb.append(String.format("%6s", Integer.toBinaryString(i)).replace(" ", "0")); // 인코딩 된 문자 이진수로 변환
						break;
					}
				}
				
				if(idx % 4 == 3) { // 인코딩 된 문자 4개 변환하면
					decodedStc.append((char)Integer.parseInt(sb.toString().substring(0, 8), 2)); // 디코딩
					decodedStc.append((char)Integer.parseInt(sb.toString().substring(8, 16), 2));
					decodedStc.append((char)Integer.parseInt(sb.toString().substring(16, 24), 2));
					sb.setLength(0); // 초기화
				}

				idx++;
			}
			
			System.out.println("#" + t + " " + decodedStc);
			decodedStc.setLength(0);
		}
	}
}
