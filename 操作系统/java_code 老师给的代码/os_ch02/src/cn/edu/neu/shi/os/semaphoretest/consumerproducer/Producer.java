package cn.edu.neu.shi.os.semaphoretest.consumerproducer;

public class Producer extends Thread{

	Table t;
	
	public Producer(Table t) {
		super();
		this.t = t;
	}

	public void run() {
		while(true){
			Dish d=new Dish("水煮鱼");
			t.addDish(d);
		}
	}
	
}
