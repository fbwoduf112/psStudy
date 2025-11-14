import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int arr[];
	static String check[];
	static char lan[] = {'D', 'S', 'L', 'R'};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			arr = new int[10001];
			check = new String[10001];
			check[n] = "";
			bfs(n, m);
		}
		
		
	}
	//n는 원본 숫자, m는 목표 숫자
	static void bfs(int n, int m) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		while(true) {
			//큐에 DSLR순으로 넣음. 후에 방문 표시
			int num = q.poll();
			
			//방문 한 곳이면 안함;
			for(int i=0; i<4; i++) {
				int visitNum = numberCheck(num, lan[i]);
				if(check[visitNum] == null) {
					q.add(visitNum);
					if(check[num] != null) check[visitNum] = check[num]+lan[i];
					else check[visitNum] = String.valueOf(lan[i]);
				}
				if(visitNum == m) {
					System.out.println(check[visitNum]);
					break;
				}
			}
			if(check[m] != null) break;
			
		}
	}
	static int numberCheck(int num, char func) {
		if(func == 'D') {
			num = (num * 2) % 10000;
			
		}
		else if(func == 'S') {
			if(num == 0) num = 9999;
			else num -= 1;
		}
		else if(func == 'L') {
			if(num < 1000) num = num * 10;
			else if(num % 1000 == 0) num = num / 1000;
			else {
				int temp = num / 1000;
				num = num % 1000;
				num = (num * 10) + temp;
			}
			
		}
		else {
			if(num < 1000) {
				//ex 0999
				//temp = 9
				int temp = num % 10;
				//temp = 9000
				temp = temp * 1000;
				//num = 99
				num = num / 10;
				num = num + temp;
			}
			else if(num % 1000 == 0) {
				//ex 2000
				num = num / 10;
			}
			else {
				//ex) 1234
				int temp = num % 10;
				temp = temp * 1000;
				num = num / 10;
				num = temp + num;
			}
		}
		return num;
	}
}