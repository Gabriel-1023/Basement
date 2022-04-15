package cn.edu.neu.shi.os.thread.selltickets;

public class TicketRunnable implements Runnable {

	private int ticket=100;

	synchronized private void sell(){
		if(ticket>0){
			System.out.println(Thread.currentThread().getName()+"卖出第"+ticket+"张票。");
			ticket--;
		}
	}
	
	public void run() {
		while(true){
			sell();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
/*	public void run() {
		while(true){
			synchronized(this){
				if(ticket>0){
					System.out.println(Thread.currentThread().getName()+"卖出第"+ticket+"张票。");
					ticket--;
				}
			}
		}
	}*/

	
}
