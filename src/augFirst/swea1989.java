package augFirst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class swea1989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		end : for(int t=1; t < test + 1; t++) {
			String word = br.readLine();
			
			for(int i=0; i < word.length() / 2; i++) {
				if(word.charAt(i) != word.charAt(word.length() - 1 - i)) {
					System.out.println("#" + t + " 0");
					continue end;
				}
			}
			
			System.out.println("#" + t + " 1");
		}
	}
}
