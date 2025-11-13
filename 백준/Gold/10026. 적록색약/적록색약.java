import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
	static int cnt = 0;
	static int nextX[] = {0, 0, 1, -1};
	static int nextY[] = {1, -1, 0, 0};
	static char arr[][];
	static int n;
	static boolean check[][];
	static Queue<PointXY> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new char [n][n];
		check = new boolean[n][n];
		//R, G, B 채움
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		//아직 방문하지 않은 곳을 q에 추가 후에 방문 로직
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!check[i][j]) {
					check[i][j] = true;
					q.add(new PointXY(j , i));
					bfs();
				}
			}
		}
		System.out.print(cnt + " ");
		cnt = 0;
		check = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 'G') {
					arr[i][j] = 'R';
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!check[i][j]) {
					check[i][j] = true;
					q.add(new PointXY(j , i));
					bfs();
				}
			}
		}
		System.out.print(cnt);
	}
	
	static void bfs() {
		//q가 빌때까지
		while(!q.isEmpty()) {
			//point구함
			PointXY pointXY = q.poll();
			//현재 x, y
			int x = pointXY.x;
			int y = pointXY.y;
			//방문 표시함
			
			//왼쪽, 오른쪽, 위, 아래 방문
			for(int i=0; i<4; i++) {
				//이동 위치
				int moveX = x + nextX[i];
				int moveY = y + nextY[i];
				//방문 했는지, 유효 범위인지 체크 check();
				if(check(moveX, moveY)) {
					//현재 색깔과 이동 색깔이 같은지 체크
					if(checkColor(arr[pointXY.y][pointXY.x], arr[moveY][moveX])) {
						//캍으면 타고 들어가야함 q에 체크 추가
						check[moveY][moveX] = true;
						q.add(new PointXY(moveX, moveY));
					}	
				}
			}
		}
		//끝나면 카운트 증가
		cnt++;
	}
	
	static boolean check(int moveX, int moveY) {
		if(moveX < 0 || moveX >= n || moveY < 0 || moveY >= n) return false;
		if(check[moveY][moveX]) return false;
		return true;
	}
	
	static boolean checkColor(char nowColor, char moveColor) {
			if(nowColor == moveColor) return true;
			else return false;
		
		}
	}