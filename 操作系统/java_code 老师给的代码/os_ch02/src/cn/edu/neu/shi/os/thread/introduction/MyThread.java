package cn.edu.neu.shi.os.thread.introduction;

public class MyThread extends Thread {

	private String name;
	
	public MyThread(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		while(true)
			System.out.println(name);
	}
	
}
