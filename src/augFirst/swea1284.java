package augFirst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class swea1284 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		for(int t=1; t < test + 1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int companyA = Integer.parseInt(st.nextToken());
			int companyBBasic = Integer.parseInt(st.nextToken());
			int companyBLimit = Integer.parseInt(st.nextToken());
			int companyBAddit = Integer.parseInt(st.nextToken());
			int usedWater = Integer.parseInt(st.nextToken());
			
			int ifA = usedWater * companyA;
			int ifB = 0;
			if(usedWater > companyBLimit) {
				ifB = companyBBasic + companyBAddit * (usedWater - companyBLimit);
			} else {
				ifB = companyBBasic;
			}
			
			System.out.println("#" + t + " " + Math.min(ifA, ifB));
		}
	}
}
