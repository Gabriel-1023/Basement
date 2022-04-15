package cn.edu.neu.shi.os.thread.selltickets;

public class TicketRunnnableNotSynchronizedTest {
	public static void main(String[] args) {
		TicketRunnnableNotSynchronized tr=new TicketRunnnableNotSynchronized();
		Thread t1=new Thread(tr, "沈阳南站");
		Thread t2=new Thread(tr, "沈阳站");
		Thread t3=new Thread(tr, "沈阳北站");
		t1.start();
		t2.start();
		t3.start();
	}
}
