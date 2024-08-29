package augFourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class baekjoon1339 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int words = Integer.parseInt(br.readLine());
        int[] alphabets = new int[26]; // 알파벳 가중치 담을 배열
        for(int i=0; i < words; i++) {
            String word = br.readLine();
            for(int j=0; j < word.length(); j++) {
                char curAlp = word.charAt(j);
                alphabets[curAlp - 'A'] += (int)Math.pow(10, word.length() - j - 1); // 알파벳 가중치 계산(각 자릿수만큼 더하기)
            }
        }
        Arrays.sort(alphabets);

        int num = 9;
        int idx = 25;
        int maxSum = 0;
        while(alphabets[idx] != 0) {
            maxSum += alphabets[idx--] * num--; // 가중치 높은 것부터 9 대입해서 더하기
        }

        System.out.println(maxSum);
    }
}