package cn.edu.neu.shi.os.semaphoretest.consumerproducer;

public class Room {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Table t=new Table();
		Producer p=new Producer(t);
		Producer p2=new Producer(t);
		Consumer c=new Consumer(t);
		Consumer c2=new Consumer(t);
		p2.start();
		c2.start();
		p.start();
		c.start();
		
	}

}
