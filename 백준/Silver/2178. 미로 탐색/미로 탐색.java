import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static boolean check[][];
	static int N, M;
	static int [] dx = {-1, 1, 0, 0 };
	static int [] dy = {0, 0, -1, 1 };
	public static void main(String[] args) throws IOException {	 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		check = new boolean[N+1][M+1];
		for(int i=1; i<N+1; i++) {
			String str = br.readLine();
			for(int j=1; j<M+1; j++) {
				arr[i][j] = str.charAt(j-1) - '0';
			}
		}
		check[1][1] = true;
		BFS(1, 1);
		System.out.println(arr[N][M]);
	}
	static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= M+1 || nextY >=N+1)
					continue;
				if(check[nextY][nextX] || arr[nextY][nextX] == 0)
					continue;
				q.add(new int[] {nextX, nextY});
				arr[nextY][nextX] = arr[nowY][nowX] + 1;
				check[nextY][nextX] = true;
			}
		}
	}
}