import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	// br을 static 변수로 올리고 한 번만 생성합니다.
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine()); // static br을 사용
		
		for(int i=0; i<N-1; i++) {
			sb.append(Test());
			sb.append("\n");
		}
		sb.append(Test());
		System.out.println(sb);
		
	}
	static String Test() throws IOException {
		Deque <Integer> dq = new LinkedList<Integer>();
		// 여기서 br을 새로 생성하는 라인을 삭제합니다.
		String command = br.readLine(); // static br을 사용
		int size = Integer.parseInt(br.readLine()); // static br을 사용
		
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
		
		// --- 런타임 에러 수정 후 '틀렸습니다'가 날 수 있는 부분 ---
		int dqSize = dq.size();
		StringBuilder ans = new StringBuilder();
		ans.append("[");
		
		if(dqSize > 0) { // 덱이 비어있지 않을 때만 poll 실행
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
			ans.append(dq.poll()); // 마지막 원소 추가
		}
		
		ans.append("]");
		return ans.toString();
	}
}