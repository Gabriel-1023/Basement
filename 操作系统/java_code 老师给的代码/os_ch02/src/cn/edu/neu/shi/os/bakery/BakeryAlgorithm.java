package cn.edu.neu.shi.os.bakery;
import java.util.Scanner;

class BakeryAlgorithmRunnable implements Runnable{
	
	int i; //�Լ��ǵ�i���߳�
	int n; //��n���߳�
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
			System.err.println("����\t�߳�\t"+i+"\t��\t�ٽ���");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println("  �뿪\t�߳�\t"+i+"\t��\t�ٽ���");
			//critical section
			number[i] = 0;
			//remainder section
			System.out.println("����\t�߳�\t"+i+"\t��ʣ����");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("  �뿪\t�߳�\t"+i+"\t��ʣ����");
			//remainder section
		} while (true);
	}
}


public class BakeryAlgorithm {

	public static void main(String[] args) {
		int n=10;//�߳�����
		System.out.print("�������̵߳�������");
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