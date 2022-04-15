package cn.edu.neu.shi.os.monitor.intro;

class MyRun implements Runnable{

	public void run() {
		while(true){
			synchronized(this){
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

public class MonitorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyRun myRun=new MyRun();
/*		Thread t1=new Thread(myRun);
		Thread t2=new Thread(myRun);
		t1.start();
		t2.start();
*/		
		
		for(int i=0; i<100; i++){
			new Thread(myRun).start();
		}
		
		
	}

}
