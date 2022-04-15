package test2;

public class Test {
	public static void printHaha(){
		while(true){
			System.out.println(Thread.currentThread().getName()+"haha");
		}
	}

	public static void main(String[] args) {
		new Thread(){
			public void run() {
				printHaha();
			}
		}.start();
		
		new Thread(){
			public void run() {
				printHaha();
			}
		}.start();

	}

}
