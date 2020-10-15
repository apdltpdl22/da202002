import java.util.ArrayList;
import java.util.Scanner;

//���� (stack)�� �⺻���� �ڷᱸ�� �� �ϳ���, ��ǻ�� ���α׷��� �ۼ��� �� ���� �̿�Ǵ� �����̴�. ������ �ڷḦ �ִ� (push) �Ա��� �ڷḦ �̴� (pop) �Ա��� ���� ���� ���߿� �� �ڷᰡ ���� ���� ������ (LIFO, Last in First out) Ư���� ������ �ִ�.
//1���� n������ ���� ���ÿ� �־��ٰ� �̾� �þ�������ν�, �ϳ��� ������ ���� �� �ִ�. 
//�̶�, ���ÿ� push�ϴ� ������ �ݵ�� ���������� ��Ű���� �Ѵٰ� ����. 
//������ ������ �־����� �� ������ �̿��� �� ������ ���� �� �ִ��� ������, �ִٸ� � ������ push�� pop ������ �����ؾ� �ϴ����� �˾Ƴ� �� �ִ�. 
//�̸� ����ϴ� ���α׷��� �ۼ��϶�.
//ù �ٿ� n (1 �� n �� 100,000)�� �־�����. ��° �ٺ��� n���� �ٿ��� ������ �̷�� 1�̻� n������ ������ �ϳ��� ������� �־�����. ���� ���� ������ �� �� ������ ���� ����.
//�Էµ� ������ ����� ���� �ʿ��� ������ �� �ٿ� �� ���� ����Ѵ�. push������ +��, pop ������ -�� ǥ���ϵ��� �Ѵ�. �Ұ����� ��� NO�� ����Ѵ�.


// Stack �ڷᱸ���� ����ϱ� ���ؼ� Stack�̶�� Ŭ���� ����
// Stack �뵵���� �پ��ϰ� ����ϱ� ���� ���ø� Ŭ���� ���.
// ���ø� Ŭ������ �پ��� ����Ÿ���� Ŭ���� ������ �� ����Ͽ� �ϳ��� �ҽ��� ������ �پ��� ����� ����� ������ �� �ִ�.
// �ۺ� Ŭ������ Ŭ���� �̸� �ڿ� < E >�� ���� ���Ⱕȣ�� �̿��մϴ�.
// ���ø� Ŭ������ Ŭ���� ����ϴ� ���� E ��� ���� ���� Ÿ�� �־� ��� ���� (Ex. ���ڿ� ��� ����(Stack<String>), ���ڸ� ��� ����(Stack<Integer>).)

class Node<E>{
	E value;
	Node<E> next;
	// ������ (�ַ� �ʱ�ȭ ���)
	Node(E v){ value = v; next=null;}
	//get next
	public Node<E> getNext() {return next;}
	//set next
	public void setNext(Node<E> n) {next = n;}
	// get value
	public E getValue() {return value;}	
}
//���Ͽ��� ���� Ŭ����
class StackL<E>{
	Node<E> head;
	int size;
	StackL(){ head = null; size=0;}
	public void push(E v) {
		//1. ���ο� ��带 ����
		Node<E> newNode = new Node(v);
		//2. ������ ����� ���� ��带 head�� ����
		newNode.setNext(head);
		//3. head�� �����ϴ� ��带 newNode�� ����.
		head = newNode;
		size++;
	}
	public void pop() {
		//1. head�� �����ϴ� ����� ���� ��尪���� head���� �ٲ۴�.
		head = head.getNext();
		size--;
	}
	public E top() {
		//1. head�� �����ϴ� ����� value ���� ��ȯ�Ѵ�.
		return head.getValue();
	}
	public int size() {
		//1. �ּ��ϰԵ� ��ũ�� ����Ʈ�� ���� ��ȸ�ϰų� push, pop�� �� ���� �ϳ��� ����, ���ҽ�Ű�� ������ size�� �˱� ����ϴ�.
	return size;
	}
}


 class Stack<E> {
	// �ڹٿ��� �迭�� ����Ϸ��� <����Ÿ��>[] <��� ���� �̸�>; ���·� ������ ���־�� �մϴ�.
	E[] data;   //���� �����͸� ������ ����(�迭)
	int top;	//���� �� �� �����͸� ������ ����
	// ������
	Stack() {
		//	1. 1<=n<=100,000�̹Ƿ� 1000000 ������� �����α�.
		data =(E[])new Object[100000];
		//	2. top ������ -1�� �ʱ�ȭ�մϴ�.
		top = -1;
	}
	//���ÿ� ������v�� �־��ִ� �Լ� push
	public void push(E v) {
		top++;
		data[top] = v;
	}
	public void pop() {
		//0. top �� ����Ű�� �迭���� null�� ���������� �ش� �����Ͱ� ����� �� �ְ� �Ѵ�.
		data[top]=null;
		//1. top������ 1 ���ҽ�ŵ�ϴ�.
		top--;
		//�� �ΰ��� �� �ٿ� ǥ�� ����
		//data[top--]=null;
	}
	//�ֻ��� ������ ��ȯ
	public E top() {
		//1. top ������ �ε����� �迭���� ��ȯ�մϴ�.
		return data[top];
	}
	//������ ����ִ��� �˻�
	public boolean empty() {
	return top == -1;
	}
	public int size() {
		//1. ���ÿ� �ִ� ������ ������ top+1�� ��.
		return top+1;
	}

}
 
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack();//���� ����
		ArrayList pm = new ArrayList();//plus,minus�� ����� pm ����
				
		System.out.println("1<=n<=100000�� n�� �Է��ϼ���.");
		int n = sc.nextInt();
		
		if(1<=n && n<=100000) {
		int array[] = new int[n];
		System.out.println("������ �Է��ϼ���.");
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
