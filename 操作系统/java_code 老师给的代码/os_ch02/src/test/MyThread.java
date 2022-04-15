package test;

public class MyThread extends Thread {

	@Override
	public void run() {
		while(true){
			System.out.println("I am thread");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
