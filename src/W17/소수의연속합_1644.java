import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N + 1];
        int[] prime = new int[N + 1];
        int idx = 0;
        num[0]--;
        num[1]--;

        for(int i=2; i < N + 1; i++) { // 차례로 보면서
            if(num[i] == 0) { // 몫이 없으면(== 소수이면)
                int j = 1; // 몫
                while(i * j < N + 1) {
                    num[i * j++]--; // 소수의 배수 다 체크
                }
                prime[idx++] = i // 소수니까 체크
            }
        }

        int cnt = 0;
        int left = 0;
        int right = 0;
        int sum = idx == 0 ? 0 : prime[0];
        
        while(left < idx + 1) {
            if(sum == N) { // 소수의 연속합으로 나타나면
                cnt++; // 개수 체크
                sum -= prime[left++]; // 왼쪽 수 빼기
            } else if(sum > N) { // 합이 더 크면
                sum -= prime[left++]; // 왼쪽 수 빼기
            } else { // 합이 더 작으면
                if(left >= idx - 1) { // 왼쪽 포인터가 끝이거나 하나 전인 경우
                    sum -= prime[left++]; // 합에서 빼기
                } else { // 왼쪽 포인터가 충분히 더 남았으면
                    sum += prime[++right]; // 오른쪽 더하기
                }
            }
        }
        
        System.out.println(cnt);
    }
}
