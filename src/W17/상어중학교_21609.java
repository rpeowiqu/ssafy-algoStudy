import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

class Main {
    static int N, M, score, blocks;
    static int[][] field, copied;
    static boolean[][] visited, checkBlock;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        score = 0; // 점수
        blocks = 0; // 일반 블록 개수
        field = new int[N][N]; // 맵
        copied = new int[N][N]; // 돌릴 때 쓸거

        for(int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                if(field[i][j] > 0) blocks++; // 일반 블록 개수 세기
            }
        }

        play(); // 플레이
        System.out.println(score);
    }

    static void play() {
        while(true) {
            checkBlock = new boolean[N][N]; // 일반블록만 bfs 체크용
            int max = 0;
            int rainbowBlocks = 0; // 무지개 블록 수
            int[] idx = new int[2];
            for(int i=0; i < N; i++) {
                for(int j=0; j < N; j++) {
                    if(field[i][j] <= 0 || checkBlock[i][j]) continue; // 체크한 부분이면 넘어가
                    int[] size = findBlock(i, j); // 블록 크기 체크
                    int blockSize = size[0] + size[1]; // size[0]은 무지개 블록 수, [1]은 일반 블록 수

                    if((max > blockSize) || // 이미 최대 크기가 있거나
                        (max == blockSize && rainbowBlocks > size[0]) || // 최대 크기와 같은데 무지개 수가 더 작거나
                        (max == blockSize && rainbowBlocks == size[0] && idx[0] > i) || // 위와 같은데 행이 더 작거나
                        (max == blockSize && rainbowBlocks == size[0] && idx[0] == i && idx[1] > j) // 위와 같은데 열이 더 작으면
                      ) continue; // 넘어가
                    max = blockSize; // 위 과정 다 넘겼으면 최대 갱신
                    rainbowBlocks = size[0]; // 무지개 블록 수 갱신
                    idx[0] = i; // 행 갱신
                    idx[1] = j; // 열 갱신
                }
            }
            if(max < 2) return; // 다 체크했는데 최대 블록 크기가 2보다 작으면 더이상 할 수 없는 것이므로 끝냄

            int[] removed = removeBlock(idx); // 블록 제거
            score += max * max; // 점수 계산
            blocks -= removed[1]; // 일반 블록 수 계산
            doGravity(); // 아래로 내리기
            doSpin(); // 돌리기
            doGravity(); // 아래로 내리기
            
            if(blocks <= 0) return; // 만약 일반 블록 수가 다 떨어졌으면 무지개 블록 남아있어도 끝난것
        }
    }

    static int[] findBlock(int y, int x) { // 일반 bfs
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][N];
        int color = field[y][x];
        int[] cnt = new int[2];
        cnt[1] = 1;
        queue.offer(new int[] {y, x});
        visited[y][x] = true;
        checkBlock[y][x] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i=0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(!check(ny, nx) || visited[ny][nx] || (field[ny][nx] != 0 && field[ny][nx] != color)) continue;
                if(field[ny][nx] == 0) cnt[0]++;
                else cnt[1]++;
                queue.offer(new int[] {ny, nx});
                visited[ny][nx] = true;
                if(field[ny][nx] > 0) checkBlock[ny][nx] = true;
            }
        }

        return cnt;
    }

    static int[] removeBlock(int[] arr) { // bfs 돌리면서 빈 공간 -2로 만들기
        Queue<int[]> queue = new LinkedList<>();
        int color = field[arr[0]][arr[1]];
        int[] blocks = new int[2];
        blocks[1]++;
        queue.offer(arr);
        field[arr[0]][arr[1]] = -2;
        while(!queue.isEmpty()) {
            int cur[] = queue.poll();
            for(int i=0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(!check(ny, nx) || (field[ny][nx] != 0 && field[ny][nx] != color)) continue;
                if(field[ny][nx] > 0) blocks[1]++;
                else blocks[0]++;
                field[ny][nx] = -2;
                queue.offer(new int[] {ny, nx});
            }
        }

        return blocks;
    }

    static void doGravity() { // 아래로 내리기
        for(int i=0; i < N; i++) {
            int emptyIdx = N; // 현재 내려갈 위치 지정(처음에는 범위 바깥으로 지정)
            for(int j=N - 1; j >= 0; j--) {
                if(field[j][i] == -1) { // 만약 안 내려가는 검은 블록이면
                    emptyIdx = N; // 범위 바깥으로 지정
                    continue;
                }
                if(emptyIdx == N && field[j][i] == -2) emptyIdx = j; // 일반 블록이 내려갈 수 있는 가장 아래 위치면 갱신
                if(emptyIdx < N && field[j][i] >= 0) { // 일반 블록이 내려갈 수 있는 위치가 있고 현재 일반 블록이면 블록 내려버리기
                    field[emptyIdx--][i] = field[j][i];
                    field[j][i] = -2;
                }
            }
        }
    }

    static void doSpin() { // 돌리기
        for(int i=0; i < N; i++) {
            for(int j=0; j < N; j++) {
                copied[i][j] = field[j][N - 1 - i];
            }
        }
        
        for(int i=0; i < N; i++) {
            System.arraycopy(copied[i], 0, field[i], 0, N);
        }
    }

    static boolean check(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }

    static void printField() { // 이건 디버깅용으로 만들어놓은 것
        for(int i=0; i < N; i++) {
            for(int j=0; j < N; j++) {
                if(field[i][j] >= 0) System.out.print(" " + field[i][j] + " ");
                else if(field[i][j] > -2) System.out.print(field[i][j] + " ");
                else System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
