import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PointXYZ {
	int x;
	int y;
	int z;
	
	public PointXYZ(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static int m, n, h;
	static int cnt = 0;
	static int arr[][][];
	static Queue<PointXYZ> queue = new LinkedList<>();
	static int nextX[] = {0, 0, 1, -1, 0, 0};
	static int nextY[] = {1, -1, 0, 0, 0, 0};
	static int nextZ[] = {0, 0, 0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		//x는 가로 y는 세로 z는 높이		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		

		arr = new int[h+1][n+1][m+1];
		
		for(int i=1; i<=h; i++) {
			for(int j=1; j<=n; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int k=1; k<=m; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());		
					if(arr[i][j][k] == 1) queue.add(new PointXYZ(k, j, i));
				}
			}
		}
		System.out.println(bfs());
		
	}
	static int bfs() {
		while(!queue.isEmpty()) {
			PointXYZ point = queue.poll();
			int x = point.x;
			int y = point.y;
			int z = point.z;
			
			for(int i=0; i<6; i++) {
				int moveX = x+nextX[i];
				int moveY = y+nextY[i];
				int moveZ = z+nextZ[i];
				if(checkPoint(moveZ, moveY, moveX)) {
					queue.add(new PointXYZ(moveX, moveY, moveZ));
					arr[moveZ][moveY][moveX] = arr[z][y][x] + 1;
				}
			}
		}
		int result = Integer.MIN_VALUE;
        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= m; k++){
                    // 하나라도 익지 않은 토마토가 있다면 -1을 반환
                    if(arr[i][j][k] == 0) return -1;
                    // 토마토가 익는데 걸리는 시간을 구함
                    result = Math.max(result, arr[i][j][k]);
                }
            }
        }
        if(result == 1) return 0;
        else return (result - 1);
	}
	
	static boolean checkPoint(int height, int row, int col) {
		if(height < 1 || height > h || row < 1 || row > n || col < 1 || col > m) return false;
		if(arr[height][row][col] == 0) return true;
		else return false;
	}
}