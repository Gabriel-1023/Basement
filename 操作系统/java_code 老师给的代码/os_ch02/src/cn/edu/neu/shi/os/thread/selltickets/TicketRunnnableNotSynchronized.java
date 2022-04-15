package cn.edu.neu.shi.os.thread.selltickets;

public class TicketRunnnableNotSynchronized implements Runnable {

	private int ticket=100;
	
	public void run() {
		while(true){	
			if(ticket>0){
				System.out.println(Thread.currentThread().getName()+
						"sells No."+ticket);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ticket--;
			}	
		}	
	}
}
