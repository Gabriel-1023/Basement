package test;

public class Test {

	public static void main(String[] args) {
		MyThread mt=new MyThread();
		mt.start();
		
		while(true){
			System.out.println("I am main");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
