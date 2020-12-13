		import java.util.Random;
		import java.util.Scanner;
		
public class Main {

	public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
				System.out.println("N과 K를 입력하세요.");
				int N = sc.nextInt();
				int K = sc.nextInt();
				sc.close();
				
				long t1 = System.currentTimeMillis();
				
				int [] arr = new int [N];
				int [] sum = new int [N];
				Random rand = new Random();
				
				int r = 0;
				r = rand.nextInt();
				System.out.println("Rand : "+ r);
				arr[0] = r;
				sum[0] = arr[0];
				r=0;
				
				for(int i=1; i<N; i++) {
					r = rand.nextInt();
					System.out.println("Rand : "+ r);
					arr[i] = r;
					sum[i] = sum[i-1]+arr[i];
					r=0;
				}									
				
				int t = 0;
				int tmp = 0;
				for(int i=0; i<K*2; i++) {
					t = rand.nextInt(N);
					int a= t;
					if(a==0) {t=rand.nextInt(N);a=t;}
					System.out.println(a);
					t = rand.nextInt(N);
					int b = t;
					if(b==0) {t=rand.nextInt(N);b=t;}
					System.out.println(b);
					
					if(a<=b) {
						int re_arr[] = new int[b-a+1];
						int x = 0;
						for(int l=a-1; l<b; l++) {
							re_arr[x] = arr[l];
							x++;
						}
						int max = re_arr[0];
						int min = re_arr[0];
						
						for(int l=0;l<re_arr.length;l++) {
						    if(max < re_arr[l]) {
							max = re_arr[l];
						    }
									
						    if(min>re_arr[l]) {
							min = re_arr[l];
						    }
						}
						int s = sum[b] - sum[a-1];
						
								
						System.out.println(a+"와 "+b+" 구간의 최대값 : "+max);
						System.out.println(a+"와 "+b+" 구간의 최소값 : "+min);
						System.out.println(a+"와 "+b+" 구간의 합계 : "+s);
						
					}
					else {tmp=b;b=a;a=tmp; 
					int re_arr[] = new int[b-a+1];
					int x = 0;
					for(int l=a-1; l<b; l++) {
						re_arr[x] = arr[l];
						x++;
					}
					int max = re_arr[0];
					int min = re_arr[0];
					
					for(int l=0;l<re_arr.length;l++) {
					    if(max < re_arr[l]) {
						max = re_arr[l];
					    }
								
					    if(min>re_arr[l]) {
						min = re_arr[l];
					    }
					}
					int s = sum[b] - sum[a-1];
							
					System.out.println(a+"와 "+b+" 구간의 최대값 : "+max);
					System.out.println(a+"와 "+b+" 구간의 최소값 : "+min);
					System.out.println(a+"와 "+b+" 구간의 합계 : "+s);
					}
					i++;
				}
			
				t1= System.currentTimeMillis()-t1;
				System.out.println("소요시간 : "+t1+"ms");

	}

}
