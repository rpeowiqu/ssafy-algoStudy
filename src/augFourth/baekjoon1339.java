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
        int[] alphabets = new int[26]; // ���ĺ� ����ġ ���� �迭
        for(int i=0; i < words; i++) {
            String word = br.readLine();
            for(int j=0; j < word.length(); j++) {
                char curAlp = word.charAt(j);
                alphabets[curAlp - 'A'] += (int)Math.pow(10, word.length() - j - 1); // ���ĺ� ����ġ ���(�� �ڸ�����ŭ ���ϱ�)
            }
        }
        Arrays.sort(alphabets);

        int num = 9;
        int idx = 25;
        int maxSum = 0;
        while(alphabets[idx] != 0) {
            maxSum += alphabets[idx--] * num--; // ����ġ ���� �ͺ��� 9 �����ؼ� ���ϱ�
        }

        System.out.println(maxSum);
    }
}