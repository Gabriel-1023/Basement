package cn.edu.neu.shi.os.thread.introduction;

public class MyThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread m1=new MyThread("Hello");
		MyThread m2=new MyThread("world");
		m1.start();
		m2.start();
	}

}
