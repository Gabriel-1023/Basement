package cn.edu.neu.shi.os.bakery;
import java.util.Scanner;

class BakeryAlgorithmRunnable implements Runnable{
	
	int i; //自己是第i个线程
	int n; //共n个线程
	boolean[] choosing;
	int[] number;
	
	BakeryAlgorithmRunnable(int i, int n, boolean[] choosing, int[] number){
		
		this.i=i;
		this.n=n;
		this.choosing=choosing;
		this.number=number;
	}
	
	public void run(){
		do { 
			choosing[i] = true;
			int max=0;
			for(int j=0; j<n; j++){
				if(j!=i){
					if(number[j]>max){
						max=number[j];
					}
				}
			}
			number[i] =max+1;
			choosing[i] = false;

			for(int j = 0; j < n; j++) {
				while (choosing[j]) ; 
				while ((number[j] != 0) && ((number[j]<number[i])||(number[j]==number[i]&&j<i)));
			}
			//critical section
			System.err.println("进入\t线程\t"+i+"\t的\t临界区");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println("  离开\t线程\t"+i+"\t的\t临界区");
			//critical section
			number[i] = 0;
			//remainder section
			System.out.println("进入\t线程\t"+i+"\t的剩余区");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("  离开\t线程\t"+i+"\t的剩余区");
			//remainder section
		} while (true);
	}
}


public class BakeryAlgorithm {

	public static void main(String[] args) {
		int n=10;//线程数量
		System.out.print("请输入线程的数量：");
		n=new Scanner(System.in).nextInt();
		boolean[] choosing=new boolean[n];
		int[] number=new int[n];
		
//		for(boolean b:choosing)
//			System.out.println(b);
		
		for(int i=0; i<n; i++){
			new Thread(new BakeryAlgorithmRunnable(i, n, choosing, number)).start();
		}
		
		
	}
}