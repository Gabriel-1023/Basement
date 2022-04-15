package cn.edu.neu.shi.os.thread.introduction;

public class MyRunnableThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnableThread mrt=new MyRunnableThread();
		Thread t=new Thread(mrt);
		t.start();
	}

}
