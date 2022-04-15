package cn.edu.neu.shi.os.monitor.intro;

class MyRun1 implements Runnable{

	String s;
	
	public MyRun1(String s) {
		super();
		this.s = s;
	}

	public void run() {
		while(true){
			synchronized(s){
				System.out.println(Thread.currentThread().getName()+": 1 step!");
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName()+": 2 step!");
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName()+": 3 step!");
			}
		}
	}
}

class MyRun2 implements Runnable{

	String s;
	
	public MyRun2(String s) {
		super();
		this.s = s;
	}

	public void run() {
		while(true){
			synchronized(s){
				System.out.println("HAHA"+Thread.currentThread().getName()+": 1 step!");
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("HAHA"+Thread.currentThread().getName()+": 2 step!");
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("HAHA"+Thread.currentThread().getName()+": 3 step!");
			}
		}
	}
}

public class MonitorTest2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String synstr=new String();
		new Thread(new MyRun1(synstr)).start();
		new Thread(new MyRun2(synstr)).start();
	}
}
