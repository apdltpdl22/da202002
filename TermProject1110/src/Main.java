import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("N과 a,b를 입력하세요.");
		int N = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int [] arr = new int [N];
		Random rand = new Random(100);
		
		int r = 0;
		
		for(int i=0; i<N; i++) {
			r = rand.nextInt(100);
			System.out.println("Rand : "+ r);
			arr[i] = r;
			r=0;
		}
			
		int re_arr[] = new int[b-a+1];
		int x = 0;
		for(int i=a-1; i<b; i++) {
			re_arr[x] = arr[i];
			x++;
		}
		
		int max = re_arr[0];
		int min = re_arr[0];
		
		for(int i=0;i<re_arr.length;i++) {
		    if(max < re_arr[i]) {
			max = re_arr[i];
		    }
					
		    if(min>re_arr[i]) {
			min = re_arr[i];
		    }
		}
		int sum = 0;
		for(int i=0;i<re_arr.length;i++) {
			sum+=re_arr[i];
		}
				
		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);
		System.out.println("합계 : "+sum);
		
	}
}