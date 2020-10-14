import java.util.Scanner;

public class Main {
	public static boolean isValid(String str) {
		char[] stack = new char[1024];
		int top = -1;  

		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch=='(') {
				stack[++top]=ch;
			}
			else if (ch == ')') {
				if(top == -1 || stack[top]!= '(') return false;
					top--;
			}
			
		}		
		return top==-1;
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i =0; i<n; i++) {
		String abc = sc.next();
		if(isValid(abc)) System.out.println("YES");
		else System.out.println("NO");

	}

   }
}
