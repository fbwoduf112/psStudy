import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static boolean [] check;
	static ArrayList<Integer[]> [] list;
	static int max;
	static int findNode = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		check = new boolean[N+1];
		for(int i=1; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Integer [] {end, weight});
			list[end].add(new Integer [] {start, weight});
		}
		dfs(1,0);
		max = 0;
		Arrays.fill(check, false);
		dfs(findNode, 0);
		System.out.print(max);
	}
	public static void dfs(int start, int sum) {
		check[start] = true;
		if(sum > max) {
			max = sum;
			findNode = start;
		}
		for(Integer[] temp : list[start]) {
			int next = temp[0];
			int cost = temp[1];
			if(!check[next]) {
				dfs(next, sum+cost);
			}
		}
	}
	
}