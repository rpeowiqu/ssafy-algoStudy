package sepThird;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선분과점11664 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] lineStart = new double[3]; // 선분 왼쪽
        double[] lineEnd = new double[3]; // 선분 오른쪽
        double[] point = new double[3]; // 점
        for(int i=0; i < 3; i++) {
            lineStart[i] = Double.parseDouble(st.nextToken());
        }
        for(int i=0; i < 3; i++) {
            lineEnd[i] = Double.parseDouble(st.nextToken());
        }
        for(int i=0; i < 3; i++) {
            point[i] = Double.parseDouble(st.nextToken());
        }

        double left = 0D;
        double right = 1D;
        double eps = 1e-10; // 오차범위 제한
        double[] line = {lineEnd[0] - lineStart[0], lineEnd[1] - lineStart[1], lineEnd[2] - lineStart[2]}; // 선분 거리
        double min = Math.min(sqrt(point, lineStart), sqrt(point, lineEnd)); // 거리값
        double[] templeft = new double[3]; // 이분탐색 할 점
        double[] tempright = new double[3]; // 이분탐색 할 점
        for(int i=0; i < 3; i++) {
            templeft[i] = lineStart[i];
            tempright[i] = lineEnd[i];
        }
        while(right - left > eps) {
            double mid = (left + right) / 2;
            double[] temp = new double[3]; // 중간 점
            temp[0] = lineStart[0] + mid * line[0];
            temp[1] = lineStart[1] + mid * line[1];
            temp[2] = lineStart[2] + mid * line[2];
            double curDis = sqrt(point, temp); // 중간까지의 거리
            double pointToLeft = sqrt(point, templeft); // 왼쪽까지 거리
            double pointToRight = sqrt(point, tempright); // 오른쪽까지 거리

            if(pointToRight - pointToLeft > eps) { // 왼쪽이랑 더 가까우면
                right = mid;
                for(int i=0; i < 3; i++) {
                    tempright[i] = temp[i];
                }
            } else if(pointToLeft - pointToRight > eps) { // 오른쪽이랑 더 가까우면
                left = mid + eps;
                for(int i=0; i < 3; i++) {
                    templeft[i] = temp[i];
                }
            } else {
                min = curDis;
                break;
            }
        }
        
        System.out.printf("%.10f", min);
    }

    static double sqrt(double[] point1, double[] point2) {
        return Math.sqrt((point2[0] - point1[0]) * (point2[0] - point1[0]) + (point2[1] - point1[1]) * (point2[1] - point1[1]) + (point2[2] - point1[2]) * (point2[2] - point1[2]));
    }
}