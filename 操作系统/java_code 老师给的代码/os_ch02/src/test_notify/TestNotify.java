package test_notify;

class RunFunc implements Runnable{
	String string;
	int label=0;
	
	public RunFunc(int label, String s) {
		super();
		this.label = label;
		string=s;
	}

	public void run() {
		synchronized(string){
			if(label==0){
				System.out.println(Thread.currentThread()+"wait");
				try {
					string.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread()+"awake");
			}else{
				System.out.print("I will notify");
				string.notify();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				string.notify();
			}
		}
	}
}


public class TestNotify{
	public static void main(String[] args) {
		String s=new String();
		RunFunc runFunc0=new RunFunc(0,s);
		RunFunc runFunc1=new RunFunc(1,s);
		new Thread(runFunc0).start();
		new Thread(runFunc0).start();
		new Thread(runFunc0).start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(runFunc1).start();
	}

}
