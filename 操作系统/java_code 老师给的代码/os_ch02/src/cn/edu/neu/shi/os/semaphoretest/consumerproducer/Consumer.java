package cn.edu.neu.shi.os.semaphoretest.consumerproducer;

public class Consumer extends Thread{
	Table t;
	
	public Consumer(Table t) {
		super();
		this.t = t;
	}

	public void run() {
		while(true){
			t.getDish();
		}
	}
}
