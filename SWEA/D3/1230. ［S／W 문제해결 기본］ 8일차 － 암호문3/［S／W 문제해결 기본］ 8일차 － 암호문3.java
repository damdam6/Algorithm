
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//LinkedList구현해보기
public class Solution {

	static public class node {
		public String data;
		public node link;

		public node() {
			// TODO Auto-generated constructor stub
		}

		public node(String data) {
			this.data = data;
			this.link = null;
		}

		@Override
		public String toString() {
			return "node [data=" + data + ", link=" + link + "]";
		}
		
		

	}

	static public class LinkedL {

		private node head = new node();
		private int size = 0;

		public LinkedL() {
		}

		// 사이즈 반환
		public int size() {
			return this.size;
		}

		public node get(int idx) {
			if (size == 0)
				return null;
			if (idx < 0 || idx >= size) {
				System.out.println("값 x");
				return null;
			}
			node nw = head.link;
			for (int i = 0; i < idx; i++) {
				nw = nw.link;
			}
			return nw;
		}

		// 맨앞에 추가하기
		public void addFirst(String data) {
			node nw = new node(data);
			if (size == 0) {
				head.link = nw;
			} else {
				nw.link = head.link;
				head.link = nw;
			}
			size++;
		}

		// 맨 뒤에 추가하기
		public void addLast(String data) {
			node nw = new node(data);

			if (size == 0) {
				head.link = nw;
			} else {
				get(size - 1).link = nw;
			}
			size++;
		}

		//인덱스 따라 추가하기
		public void addidx(int idx, String data) {
			node nw = new node(data);

			if(size==0) {
				addFirst(data);
				return;
			}
			
			if (idx < 0 || idx >= size) {
				return;
			}
			if(idx ==0) {
				nw.link=head.link;
				head.link=nw;
				return;
			}

			node tmp = get(idx - 1);
			nw.link = tmp.link;
			tmp.link = nw;
			size++;

		}

		// 첫번째 삭제
		public void rmFirst() {
			if (size == 0)
				return;
			head.link = head.link.link;
			size--;
		}

		// 마지막 삭제
		public void rmLast() {
			if (size == 0)
				return;
			head.link = head.link.link;
			size--;
		}

		//인덱스 삭제
		public void rmIdx(int idx) {
			if (size == 0)
				return;
			if (idx < 0 || idx >= size) {
				return;
			}

			node tmp = get(idx - 1);
			tmp.link = tmp.link.link;
			size--;
		}
		
		//poll
		public String pollFirst() {
			node nw;
			if (size == 0)
				return null;
			nw = head.link;
			head.link = head.link.link;
			size--;
			return nw.data;
		}
		//poll
		public String pollLast() {
			node nw;
			if (size == 0)
				return null;
			nw = get(size-2).link;
			size--;
			return nw.data;
		}

		@Override
		public String toString() {
			StringBuilder ss = new StringBuilder();

			for(int i=0; i<size;i++) {
				ss.append(this.get(i).toString());
			}
			return ss.toString();
		}
		


	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//System.setIn(new FileInputStream("res/input.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {

			// 내가 만든 링크리스트 선언
			
			LinkedL LL = new LinkedL();

			// N개의 노드
			int N = Integer.parseInt(bf.readLine());

			// 각각 입력 받기
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				LL.addLast(st.nextToken());
			}
			

			// M개의 명령어
			int M = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			
			for (int i = 0; i < M; i++) {
				char check = st.nextToken().charAt(0);
				int idx;
				int cnt;

				switch (check) {
				case 'I':
					idx = Integer.parseInt(st.nextToken());
					cnt = Integer.parseInt(st.nextToken());
					for (int j = 0; j < cnt; j++) {
						LL.addidx(idx++, st.nextToken());
					}
					break;
				case 'D':
					idx = Integer.parseInt(st.nextToken());
					cnt = Integer.parseInt(st.nextToken());
					for (int j = 0; j < cnt; j++) {
						LL.rmIdx(idx);
					}
					break;

				case 'A':
					cnt = Integer.parseInt(st.nextToken());
					for (int j = 0; j < cnt; j++) {
						LL.addLast(st.nextToken());
					}
					break;

				}
			}

			sb.append("#").append(tc);
			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(LL.pollFirst());
			}
			sb.append("\n");

		}
System.out.println(sb);
	}

}

