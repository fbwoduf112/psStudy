import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> arr;
	static int cnt = 0;
	static int ans[];
	static boolean visit[];
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<>();
		visit = new boolean[n+1];
		ans = new int[n+1];
		//배열 속 배열 추가
		for(int i=0; i<=n; i++) arr.add(new ArrayList<Integer>());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			//y를 해킹 시 x도 해킹 가능
			arr.get(y).add(x);
		}
		for(int i=1; i<n+1; i++) {
			dfs(i);
			ans[i] = cnt;
			cnt = 0;
			for(int j=1; j<visit.length; j++) visit[j] = false;
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<ans.length; i++) {
			if(ans[i] > max) max = ans[i];
		}
		for(int i=0; i<ans.length; i++) {
			if(ans[i] == max) System.out.print(i + " ");
		}
		//for(int i:ans)System.out.println(ans[i]);
		//		int max = ans[1];
//		for(int i=1; i<ans.length; i++) {
//			if(ans[i] == max) {
//				System.out.print(i + " ");
//			}
//		}
		
	}
	
	static void dfs(int start) {
		visit[start] = true;
		cnt++;
		
		for(int next : arr.get(start)) {
			if(!visit[next]) {
				dfs(next);
			}
		}
	}
}