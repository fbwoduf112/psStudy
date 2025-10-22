import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	static boolean visit [];
	static int parent [];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		visit = new boolean[n+1];
		parent = new int[n+1];
		for(int i=0; i<=n; i++) arr.add(new ArrayList<>());
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.get(x).add(y);
			arr.get(y).add(x);
		}
		dfs(1);
		for(int i=2; i<n+1; i++) System.out.println(parent[i]);
	}
	static void dfs(int num) {
		visit[num] = true;
		
		for(int i:arr.get(num)) {
			if(!visit[i]) {
				parent[i]=num;
				dfs(i);
			}
		}
	}
}