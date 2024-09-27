package sepFourth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자1976 {
static int[] parent, rank;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cities = Integer.parseInt(br.readLine());
        int travel = Integer.parseInt(br.readLine());
        parent = new int[cities];
        rank = new int[cities];

        for(int i=0; i < cities; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int i=0; i < cities; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j < cities; j++) {
                int isconnect = Integer.parseInt(st.nextToken());
                if(isconnect == 1) {
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] plan = new int[travel];
        for(int i=0; i < travel; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        boolean canTravel = true;
        for(int i=0; i < travel - 1; i++) {
            if(find(plan[i] - 1) != find(plan[i + 1] - 1)) canTravel = false;
        }

        if(canTravel) System.out.println("YES");
        else System.out.println("NO");
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return;

        if(rank[x] < rank[y]) {
            rank[y] += rank[x];
            parent[x] = parent[y];
        } else {
            rank[x] += rank[y];
            parent[y] = parent[x];
        }
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}