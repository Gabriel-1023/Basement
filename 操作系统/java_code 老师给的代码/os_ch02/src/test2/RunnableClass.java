package test2;

public class RunnableClass implements Runnable {
	int num=0;
	
	@Override
	public void run() {
		while(true){
			if(num%2==0)
				syncPrint();
			else
				syncHaha();
		}
	}
	
	synchronized void syncPrint(){
		System.out.println(Thread.currentThread().getName()+":"+num);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num++;
	}
	
	synchronized void syncHaha(){
		System.out.println(Thread.currentThread().getName()+"haha"+num);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num++;
	}

}
