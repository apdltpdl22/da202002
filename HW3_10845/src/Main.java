import java.util.*;
import java.lang.*;

public class Main {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int value=0;
        Queue<Integer> q = new LinkedList<>();
        
        if(1<=N && N<=10000) {
        for(int i = 0 ; i < N; i++) {
            String order = sc.next();
            
            if(order.equals("push")) {
                value = sc.nextInt();
                if (1<=value && value<=100000) q.add(value);
                }

            else {
                switch(order) {
                    case "pop":
                        if(q.isEmpty())
                            System.out.println("-1");
                        else
                            System.out.println(q.poll());
                        break;
                        
                    case "size":
                        System.out.println(q.size());
                        break;
                        
                    case "empty":
                        if(q.isEmpty()) 
                            System.out.println("1");
                        else
                            System.out.println("0");
                        break;
                        
                    case "front":
                        if(!q.isEmpty())
                            System.out.println(q.peek());
                        else 
                            System.out.println("-1");
                        break;
                        
                    case "back":
                        if(!q.isEmpty())
                            System.out.println(value);
                        else 
                            System.out.println("-1");
                        break;
                }
            }
        }        
    }
   }
}
