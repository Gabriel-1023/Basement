package cn.edu.neu.shi.os.monitor.intro;

public class MonitorStandard {

	private int id;
	private String name;
	private boolean sex;
	
	public synchronized int getId() {
		return id;
	}

	public synchronized void setId(int id) {
		System.out.println("setId");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.id = id;
		System.out.println("setId OK");
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		System.out.println("setName");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.name = name;
		System.out.println("setName OK");
	}

	public synchronized boolean isSex() {
		return sex;
	}

	public synchronized void setSex(boolean sex) {
		System.out.println("setSex");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.sex = sex;
		System.out.println("setSex Ok");
	}


	@Override
	public String toString() {
		return "MonitorStandard [id=" + id + ", name=" + name + ", sex=" + sex
				+ "]";
	}

}
