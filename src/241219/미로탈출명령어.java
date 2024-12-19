class Solution {
    
    static int N, M, Y, X, R, C, K, dis;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};
    static String dir;
    static String answer;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "";
        
        StringBuilder sb = new StringBuilder();
        N = n;
        M = m;
        Y = x;
        X = y;
        R = r;
        C = c;
        K = k;
        dis = Math.abs(R - Y) + Math.abs(C - X);
        dir = "dlru";
        
        if(dis > K) return "impossible";
        if(dis % 2 != K % 2) return "impossible";
        dfs(Y, X, sb);
        
        return answer;
    }
    
    static void dfs(int y, int x, StringBuilder sb) {
        if(answer.length() > 0) return;
        if(sb.length() == K && y == R && x == C) {
            answer = sb.toString();
            return;
        }
        if(sb.length() == K) return;
        int curDis = Math.abs(R - y) + Math.abs(C - x);
        if(K - sb.length() < curDis) return;
        
        for(int i=0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(check(ny, nx)) {
                sb.append(dir.charAt(i));
                dfs(ny, nx, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    
    static boolean check(int y, int x) {
        return y > 0 && y <= N && x > 0 && x <= M;
    }
}
