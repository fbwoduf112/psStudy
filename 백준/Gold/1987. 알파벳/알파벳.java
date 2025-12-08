import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static char arr[][];
	static boolean visited[];
	static int max = Integer.MIN_VALUE;
	static int R,C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		visited = new boolean[26];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		visited[arr[0][0] -'A'] = true;
		backTracking(0,0, 1);
		System.out.println(max);
		
	}	
	static void backTracking(int x, int y, int cnt) {
		//오른쪽
		max = Math.max(max, cnt);
		if(x+1 < C) {
			int temp = arr[y][x+1] - 'A';
			if(!visited[temp]) {
				visited[temp] = true;
				backTracking(x+1, y, cnt+1);
				visited[temp] = false;
			}
			
		}
		//왼쪽
		if(x-1 >= 0) {
			int temp = arr[y][x-1] - 'A';
			if(!visited[temp]) {
				visited[temp] = true;
				backTracking(x-1, y, cnt+1);
				visited[temp] = false;
			}
		}
		//위
		if(y-1 >= 0) {
			int temp = arr[y-1][x] - 'A';
			if(!visited[temp]) {
				visited[temp] = true;
				backTracking(x, y-1, cnt+1);
				visited[temp] = false;
			}
		}
		//아래
		if(y+1 < R) {
			int temp = arr[y+1][x] - 'A';
			if(!visited[temp]) {
				visited[temp] = true;
				backTracking(x, y+1, cnt+1);
				visited[temp] = false;
			}
		}
		return;
	}
}