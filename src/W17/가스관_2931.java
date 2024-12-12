import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int R, C;
    static char[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // row
        C = Integer.parseInt(st.nextToken()); // col
        map = new char[R][C];
        
        for(int i=0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i < R; i++) { // map을 다 돌면서
            for(int j=0; j < C; j++) {
                if(map[i][j] == '.') { // 관이 없는 경우
                    int cnt = 0;
                    if(isLeftConnected(i, j)) cnt += 1; // 사방탐색
                    if(isRightConnected(i, j)) cnt += 3; // 두 방향으로 연결될 수 있으면 거기가 끊긴 곳이므로(가스가 새는 곳은 없음)
                    if(isUpConnected(i, j)) cnt += 5; // 홀수를 더해서 두 방향으로 연결된다면 cnt 합이 짝수일 것
                    if(isDownConnected(i, j)) cnt += 9;

                    if(cnt > 0 && cnt % 2 == 0) {
                        if(cnt == 4) sb.append(i + 1).append(" ").append(j + 1).append(" ").append("-"); // 좌우 연결
                        if(cnt == 6) sb.append(i + 1).append(" ").append(j + 1).append(" ").append(3); // 좌상 연결
                        if(cnt == 8) sb.append(i + 1).append(" ").append(j + 1).append(" ").append(2); // 우상 연결
                        if(cnt == 10) sb.append(i + 1).append(" ").append(j + 1).append(" ").append(4); // 좌하 연결
                        if(cnt == 12) sb.append(i + 1).append(" ").append(j + 1).append(" ").append(1); // 우하 연결
                        if(cnt == 14) sb.append(i + 1).append(" ").append(j + 1).append(" ").append("|"); // 상하 연결
                        if(cnt == 18) sb.append(i + 1).append(" ").append(j + 1).append(" ").append("+"); // 상하좌우 연결
                        System.out.println(sb.toString());
                        return;
                    }
                }
            }
        }
    }

    static boolean isLeftConnected(int y, int x) {
        return check(y, --x) && (map[y][x] == '-' || map[y][x] == '+' || map[y][x] == '1' || map[y][x] == '2');
    }

    static boolean isRightConnected(int y, int x) {
        return check(y, ++x) && (map[y][x] == '-' || map[y][x] == '+' || map[y][x] == '3' || map[y][x] == '4');
    }

    static boolean isUpConnected(int y, int x) {
        return check(--y, x) && (map[y][x] == '|' || map[y][x] == '+' || map[y][x] == '1' || map[y][x] == '4');
    }

    static boolean isDownConnected(int y, int x) {
        return check(++y, x) && (map[y][x] == '|' || map[y][x] == '+' || map[y][x] == '2' || map[y][x] == '3');
    }

    static boolean check(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }
}
