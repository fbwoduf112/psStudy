import java.io.*;
import java.util.*;

public class Main {
	static int arr[][];
	static int ans[][];
	static int n, m;
	static boolean check[][];
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        ans = new int[n][m];
        check = new boolean[n][m];
        int startX = 0;
        int startY = 0;
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j] == 2) {
        			startX = j;
        			startY = i;
        		} else if(arr[i][j] == 0) check[i][j] = true;
        	}
        }
        
        bfs(startX, startY);
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(!check[i][j]) {
        			ans[i][j] = -1;
        		}
        		System.out.print(ans[i][j] + " ");	
        	}
            System.out.println();
        }
	}
    	static void bfs(int x, int y) {
    		Queue <Point> q = new LinkedList<>();
    		q.add(new Point(x, y));
    		check[y][x] = true;
    		
    		while(!q.isEmpty()) {
    			Point currentPoint = q.poll();
    			for(int i=0; i<4; i++) {
    				int nextX = currentPoint.getX() + dx[i];
    				int nextY = currentPoint.getY() + dy[i];
    				
    				if(nextX >= 0 && nextX < m && nextY >= 0 && nextY <n) {
    					if(!check[nextY][nextX] && arr[nextY][nextX] == 1) {
    						check[nextY][nextX] = true;
    						ans[nextY][nextX] = ans[currentPoint.getY()][currentPoint.getX()] + 1;
    						q.add(new Point(nextX, nextY));
    					}
    				}
    			}
    		}
    	}
    	
        static class Point {
        	int x;
        	int y;
        	
        	public Point(int x, int y) {
        		this.x = x;
        		this.y = y;
        }
        	public int getX() {
        		return x;
        	}
        	public int getY() {
        		return y;
        	}
        }

}
