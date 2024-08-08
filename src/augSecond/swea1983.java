package augSecond;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1983 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		for(int t=1; t < test + 1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int students = Integer.parseInt(st.nextToken()); // 학생 수
			int target = Integer.parseInt(st.nextToken()); // 학점 알고 싶은 학생 번호
			int[] grades = new int[students]; // 학생 점수 배열
			
			for(int i=0; i < students; i++) {
				st = new StringTokenizer(br.readLine());
				int midExam = Integer.parseInt(st.nextToken());
				int finExam = Integer.parseInt(st.nextToken());
				int assign = Integer.parseInt(st.nextToken());
				
				grades[i] = (int)Math.round(midExam * 0.35 + finExam * 0.45 + assign * 0.20); // 학생 점수 추가
			}
			
			int targetGrade = grades[target - 1]; // 학점 알고자 하는 학생 점수
			
			Arrays.sort(grades);
			int targetIdx = 0; // 학점 알고자 하는 학생 순위
			
			for(int i=0; i < students; i++) {
				if(grades[i] == targetGrade) {
					targetIdx = i / (students / 10); // 학점 알고자 하는 학생 학점 인덱스
				}
			}
			
			String[] grade = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
			System.out.println("#" + t + " " + grade[targetIdx]);
		}
	}
}
