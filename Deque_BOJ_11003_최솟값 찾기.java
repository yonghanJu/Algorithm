import java.io.*;
import java.util.*;

class Pair{
	int index;
	int value;
	Pair(int index, int value){
		this.index = index;
		this.value = value;}
}

public class Main {
	

	public static void main(String[] args) throws NumberFormatException, IOException {

		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n =Integer.valueOf(token.nextToken());
		int l =Integer.valueOf(token.nextToken());
		int index =0;
		token = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Pair> dq = new ArrayDeque<Pair>();
		
		while(token.hasMoreTokens()) {
			int now = Integer.valueOf(token.nextToken());
			while(!dq.isEmpty() && dq.peekLast().value > now) dq.pollLast();
			dq.addLast(new Pair(++index,now));   // 현재 값 추가
	        if(index-dq.peekFirst().index == l ) dq.pollFirst(); // 만약 길이가 더 길다면 맨 왼쪽에 값 제거
	        sb.append(dq.peekFirst().value).append(' ');
		}
		
		System.out.println(sb);
	}

}
