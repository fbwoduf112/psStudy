import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N-1; i++) {
			sb.append(Test());
			sb.append("\n");
		}
		sb.append(Test());
		System.out.println(sb);
		
	}
	static String Test() throws IOException {
		Deque <Integer> dq = new LinkedList<Integer>();
		String command = br.readLine();
		int size = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
		for(int i=0; i<size; i++) {
			dq.add(Integer.parseInt(st.nextToken()));
		}
		int check = 1;
		//홀수는 정방향, 짝수는 역방향
		for(int i=0; i<command.length(); i++) {
			if(command.charAt(i) == 'R') {
				check++;
			}
			else if(command.charAt(i) == 'D' && dq.size() > 0) {
				if(check % 2 == 0) {
					dq.pollLast();
				}
				else if(check % 2 == 1) {
					dq.pollFirst();
				}
			}
			else return "error";
		}
		int dqSize = dq.size();
		StringBuilder ans = new StringBuilder();
		ans.append("[");
		if(dqSize > 0) {
			for(int i=0; i<dqSize-1; i++) {
				if(check % 2 == 0) {
					ans.append(dq.pollLast());
					ans.append(",");
				}
				else if(check % 2 == 1) {
					ans.append(dq.pollFirst());
					ans.append(",");
				}
			}
			ans.append(dq.poll());
		}
		ans.append("]");
		return ans.toString();
	}
}