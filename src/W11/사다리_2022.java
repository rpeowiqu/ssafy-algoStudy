package W11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class »ç´Ù¸®_2022 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        double left = 0;
        double right = Math.min(x, y);
        double eps = 1e-6;
        while(right - left > eps) {
            double mid = (left + right) / 2;
            double leftside = x * Math.sin(Math.acos(mid / x));
            double rightside = y * Math.sin(Math.acos(mid / y));
            double crossing = leftside * rightside / (leftside + rightside);
            if(crossing - c > eps) left = mid;
            else if(c - crossing > eps) right = mid;
            else {
                break;
            }
        }

        System.out.printf("%.3f", left);
    }
}
