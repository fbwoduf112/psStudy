import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PointXY {
	int x;
	int y;
	
	public PointXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int x, y;
	static int nextX[] = {0, 0, 1, -1};
	static int nextY[] = {1, -1, 0, 0};
	static int arr[][];
	static Queue<PointXY> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		arr = new int[y+1][x+1];
		for(int i=1; i<=y; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=x; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) queue.add(new PointXY(j, i));
			}
		}
		System.out.println(bfs());
	}
	
	static int bfs() {
		while(!queue.isEmpty()) {
			PointXY point = queue.poll();
			for(int i=0; i<4; i++) {
				int moveX = point.x + nextX[i];
				int moveY = point.y + nextY[i];
				if(check(moveX, moveY)) {
					queue.add(new PointXY(moveX, moveY));
					arr[moveY][moveX] = arr[point.y][point.x] + 1;
				}
			}
		}
		int result = Integer.MIN_VALUE;
		for(int i=1; i<=y; i++) {
			for(int j=1; j<=x; j++) {
				if(arr[i][j] == 0) return -1;
				result = Math.max(result, arr[i][j]);
			}
		}
		if(result == 1) return 0;
		return result-1;
	}
	
	static boolean check(int nextX, int nextY) {
		if(nextX < 1 || nextX > x || nextY < 1 || nextY > y) return false;
		if(arr[nextY][nextX] == 0) return true;
		else return false;
	}
}