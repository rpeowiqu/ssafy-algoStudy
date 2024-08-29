package augFourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon14888 {
static int max, min;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[num];
        for(int i=0; i < num; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        calculate(numbers[0], 1, numbers, operators);
        System.out.println(max);
        System.out.println(min);
    }

    static void calculate(int num, int idx, int[] numbers, int[] operators) {
        if(idx == numbers.length) { // 인덱스 넘어가면 최대최소 찾기
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i=0; i < 4; i++) { // 연산자 앞에서부터 대입해서 계산
            if(operators[i] > 0) {
                operators[i]--;
                if(i == 0) calculate(num + numbers[idx], idx + 1, numbers, operators);
                else if(i == 1) calculate(num - numbers[idx], idx + 1, numbers, operators);
                else if(i == 2) calculate(num * numbers[idx], idx + 1, numbers, operators);
                else calculate(num / numbers[idx], idx + 1, numbers, operators);
                operators[i]++;
            }
        }
    }
}