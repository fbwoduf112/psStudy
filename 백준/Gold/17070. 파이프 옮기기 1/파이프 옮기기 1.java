import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int arr[][];
	static int ans;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//무조건 밀면서 이동
		N = Integer.parseInt(st.nextToken());
		arr = new int [N+1][N+1];
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<N+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//옆은 x+1만 되면 됨
		//대각은 (x+1,y), (x+1, y+1), (x, y+1) 이 되야함
		//대각 상태 체크
		//밑은 대각 상태에서 (x, y+1)
		//끝단만 체크
		ans = 0;
		dfs(1,2,0);
		System.out.println(ans);
	}
	public static void dfs(int x, int y, int direction) {
		if(x == N && y == N) {
			ans++;
			return;
		}
		//0 가로 1 세로 2 대각
		switch(direction) {
			case 0:
				if(y+1 <= N && arr[x][y+1] == 0) {
					dfs(x, y+1, 0);
				}
				break;
			case 1:
				if(x+1 <=N && arr[x+1][y] == 0) {
					dfs(x+1, y, 1);
				}
				break;
			case 2:
				if(y+1 <= N && arr[x][y+1] == 0) {
					dfs(x, y+1, 0);
				}
				if(x+1 <= N && arr[x+1][y] == 0) {
					dfs(x+1, y, 1);
				}
				break;
		}
		if(x+1 <= N && y+1 <= N &&arr[x][y+1] == 0 && arr[x+1][y] == 0 && arr[x+1][y+1] == 0) dfs(x+1, y+1, 2);
		
	}
}
