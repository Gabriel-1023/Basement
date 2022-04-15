package cn.edu.neu.shi.os.thread.selltickets;

public class TicketRunnableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketRunnnableNotSynchronized tr=new TicketRunnnableNotSynchronized();
		Thread t1=new Thread(tr, "沈阳南");
		Thread t2=new Thread(tr, "沈阳");
		Thread t3=new Thread(tr, "沈阳北");
		t1.start();
		t2.start();
		t3.start();
	}

}
