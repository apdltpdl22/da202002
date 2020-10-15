import java.util.ArrayList;
import java.util.Scanner;

//스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
//1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 
//이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
//임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 
//이를 계산하는 프로그램을 작성하라.
//첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.
//입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.


// Stack 자료구조를 사용하기 위해서 Stack이라는 클래스 제작
// Stack 용도별로 다양하게 사용하기 위해 템플릿 클래스 사용.
// 템플릿 클래스는 다양한 변수타입을 클래스 선언할 때 사용하여 하나의 소스를 가지고 다양한 방법으 사용을 제공할 수 있다.
// 템블릿 클래스는 클래스 이름 뒤에 < E >와 같이 꺽쇄갈호를 이용합니다.
// 템플릿 클래스의 클래스 사용하는 곳에 E 대신 여러 변수 타입 넣어 사용 가능 (Ex. 문자열 담는 스택(Stack<String>), 숫자를 담는 스택(Stack<Integer>).)

class Node<E>{
	E value;
	Node<E> next;
	// 생성자 (주로 초기화 담당)
	Node(E v){ value = v; next=null;}
	//get next
	public Node<E> getNext() {return next;}
	//set next
	public void setNext(Node<E> n) {next = n;}
	// get value
	public E getValue() {return value;}	
}
//단일연결 스택 클래스
class StackL<E>{
	Node<E> head;
	int size;
	StackL(){ head = null; size=0;}
	public void push(E v) {
		//1. 새로운 노드를 생성
		Node<E> newNode = new Node(v);
		//2. 생성한 노드의 다음 노드를 head로 설정
		newNode.setNext(head);
		//3. head가 참조하는 노드를 newNode로 설정.
		head = newNode;
		size++;
	}
	public void pop() {
		//1. head가 참조하는 노드의 다음 노드값으로 head값을 바꾼다.
		head = head.getNext();
		size--;
	}
	public E top() {
		//1. head가 참조하는 노드의 value 값을 반환한다.
		return head.getValue();
	}
	public int size() {
		//1. 애석하게도 링크드 리스트를 전부 순회하거나 push, pop할 때 변수 하나를 증가, 감소시키지 않으면 size를 알기 힘듭니다.
	return size;
	}
}


 class Stack<E> {
	// 자바에서 배열을 사용하려면 <변수타입>[] <어레이 변수 이름>; 형태로 선언을 해주어야 합니다.
	E[] data;   //스택 데이터를 지정할 변수(배열)
	int top;	//스택 맨 위 데이터를 저장할 변수
	// 생성자
	Stack() {
		//	1. 1<=n<=100,000이므로 1000000 저장공간 만들어두기.
		data =(E[])new Object[100000];
		//	2. top 변수를 -1로 초기화합니다.
		top = -1;
	}
	//스택에 데이터v를 넣어주는 함수 push
	public void push(E v) {
		top++;
		data[top] = v;
	}
	public void pop() {
		//0. top 가 가리키는 배열값을 null로 저장함으로 해당 데이터가 사라질 수 있게 한다.
		data[top]=null;
		//1. top변수를 1 감소시킵니다.
		top--;
		//위 두개를 한 줄에 표현 가능
		//data[top--]=null;
	}
	//최상의 아이템 반환
	public E top() {
		//1. top 변수의 인덱스의 배열값을 반환합니다.
		return data[top];
	}
	//스택이 비어있는지 검사
	public boolean empty() {
	return top == -1;
	}
	public int size() {
		//1. 스택에 있는 아이템 갯수는 top+1이 됨.
		return top+1;
	}

}
 
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack();//스택 생성
		ArrayList pm = new ArrayList();//plus,minus를 출력할 pm 생성
				
		System.out.println("1<=n<=100000의 n을 입력하세요.");
		int n = sc.nextInt();
		
		if(1<=n && n<=100000) {
		int array[] = new int[n];
		System.out.println("수열을 입력하세요.");
			for (int i=0; i<n; i++) {
				array[i] = sc.nextInt();} 
			sc.close();		
			
			int k=1;
			boolean isValid = true;
			
			for(int i=0; i<n;i++) { 
				int a = array[i];				
				if(isValid) {
					while(k<=a) {
						stack.push(k++);
						pm.add("+");
					}
					
					if(stack.empty()) {
						isValid = false;
					} else {
						while(!stack.empty()&&stack.top()>=a) {
							stack.pop();
							pm.add("-");}
						}
					}
				}
			
			
			if(isValid) { 
			for (int i=0; i<pm.size(); i++) {
					   System.out.println(pm.get(i));}}
					 
			else {
				System.out.println("NO");
			}
		}	
	}

}
