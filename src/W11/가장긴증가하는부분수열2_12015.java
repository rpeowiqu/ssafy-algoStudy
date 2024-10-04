package W11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열2_12015 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] seq = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < size; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> partialSeq = new ArrayList<>();
        partialSeq.add(seq[0]);
        root: for(int i=1; i < size; i++) {
            int len = partialSeq.size();
            if(seq[i] > partialSeq.get(len - 1)) partialSeq.add(seq[i]);
            else {
                int left = 0;
                int right = len;
                while(left < right) {
                    int mid = (left + right) / 2;
                    int cur = partialSeq.get(mid);
                    if(seq[i] == cur) continue root;
                    else if(seq[i] > cur) left = mid + 1;
                    else right = mid;
                }
                partialSeq.set(left, seq[i]);
            }
        }

        System.out.println(partialSeq.size());
    }
}
