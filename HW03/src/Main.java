import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static class Queue<E>{
		int front; 	
		int rear;
		E[] data;	
		int size;

		Queue(int a){
			front = rear = 0;
			size = a*2;
			data = (E[]) new Object[size];		
		}

		public void add(E v) {
			data[rear] = v;
			rear = (rear+1)%size;		
		}	

		public void remove() {
			data[front] = null;
			front = (front+1)%size;
		}
		public E peek() {
			return data[front];
			}
		public boolean empty() {
			return front == rear;		
		}	
		public int size() {
			return (rear - front +size) % size;
		}
	}

	 static class Stack<E> {
			E[] data; 
			int top;	
			Stack() {
				data =(E[])new Object[100000];
				top = -1;
			}
			public void push(E v) {
				top++;
				data[top] = v;
			}
			public void pop() {
				data[top]=null;
				top--;
			}
			public E top() {
				return data[top];
			}
			//스택이 비어있는지 검사
			public boolean empty() {
				return top == -1;
			}
			public int size() {
				return top+1;
			}
	 }
		
	
	public static void main(String[] args) {
		
		
		Stack <Integer> stack = new Stack();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("n을 입력하세요.");
		int n = sc.nextInt();
		
		Queue <Integer> que = new Queue(n);

		Random rand = new Random();
		int r = 0;
		
		sc.close();
		
		for(int i=0; i<n; i++) {
			r= rand.nextInt(10000);
			System.out.println("Rand : "+ r);
			que.add(r);
			r=0;
		}
		
		// 스택 최상위 숫자가 큐에서 꺼낸 숫자보다 작은 경우, 스택에서 숫자를 꺼내 큐에 넣습니다.
	
		for(int i =0; i<que.size; i++) {	
			if(que.peek() > stack.top()) {
			que.add(stack.top());
			stack.pop();
				if(stack.empty() || que.peek() < stack.top() ) {
					stack.push(que.peek());
					que.remove();}
				}
			stack.push(que.peek());
			que.remove();
		}
			
			
		for(int i=0; i<stack.size(); i++) {
			System.out.println(stack.top());
			stack.pop();
		}
		
	}
}

