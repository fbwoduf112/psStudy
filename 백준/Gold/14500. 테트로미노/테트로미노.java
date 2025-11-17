import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int max = Integer.MIN_VALUE;
	static int arr[][];
	static boolean check[][];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		check = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				check[i][j] = true;
				dfs(j, i, 1, arr[i][j]);
				check[i][j] = false;
			}
		}
		
		System.out.println(max);
	}
	
	static void dfs(int x, int y, int depth, int sum) {
		
		if(depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nowX = x + dx[i];
			int nowY = y + dy[i];
			
			if(!validateNumber(nowX, nowY)) continue;
			
			if(!check[nowY][nowX]) {
				
				if(depth == 2) {
					check[nowY][nowX] = true;
					dfs(x, y, depth+1, sum+arr[nowY][nowX]);
					check[nowY][nowX] = false;
				}
				
				check[nowY][nowX] = true;
				dfs(nowX, nowY, depth+1, sum+arr[nowY][nowX]);
				check[nowY][nowX] = false;
			}
		}
		
	}
	static boolean validateNumber(int x, int y) {
		if(x >= M || x < 0 || y >= N || y < 0) return false;
		else return true;
	}
}