package augSecond;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class swea1984 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		for(int t=1; t < test + 1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int total = 0; // 수 전체합 저장할 변수
			int max = 0; // 최대 수
			int min = 10000; // 최소 수
			int[] numbers = new int[10]; // 수 저장할 배열
			
			for(int i=0; i < 10; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
				total += numbers[i]; // 수 총합 계산
				max = Math.max(max, numbers[i]); // 최대 수 갱신
				min = Math.min(min, numbers[i]); // 최소 수 갱신
			}
			
			System.out.println("#" + t + " " + (int)Math.round((total - max - min) / 8.0)); // 중간 평균값 반올림 출력
		}
	}
}
