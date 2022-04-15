package cn.edu.neu.shi.os.deadlock;

class Cust{
	private String name;
	private int money;
	public String getName() {
		return name;
	}
	public Cust(String name, int money){
		this.name=name;
		this.money=money;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "\t"+name+"��"+"���Ϊ"+money+"\t";
	}
	
}

public class DeadLockTest{
	static void transfer(Cust remitter, Cust payee, int money){
		//remitter�ǻ���ˣ�payee���տ��ˣ�money��ת�ʽ�
		synchronized(remitter){
			System.out.println("lock remitter "+remitter.getName());
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(payee){
				System.out.println("lock payee "+payee.getName()+"�ʻ�");
				remitter.setMoney(remitter.getMoney()-money);
				payee.setMoney(payee.getMoney()+money);
				System.out.println(remitter.getName()+" "+payee.getName()+"ת�ʳɹ���");
				System.out.println(remitter.getMoney()+" "+payee.getMoney());
			}
		}
	}
	
	public static void main(String[] args){
		final Cust cust1=new Cust("mama", 100000);
		final Cust cust2=new Cust("son", 10000);
		
		new Thread(){
			public void run(){
				transfer(cust1, cust2, 20000);
			}
		}.start();
		new Thread(){
			public void run(){
				transfer(cust2, cust1, 5000);
			}
		}.start();
		
		//System.out.println(cust1.getMoney()+" "+cust2.getMoney()+" "+cust3.getMoney());
//		System.out.println("��ʼʱ"+cust1+cust2);
//		//cust1��cust2ת�ʡ�
////cust1��cust2ת��ͬʱ��cust2Ҳ��cust1ת�ʣ�
//		new Thread(){
//			public void run() {
//				transfer(cust1, cust2, 200);
//			}
//			
//		}.start();
//		new Thread(){
//			public void run() {
//				transfer(cust2, cust1, 300);
//			}
//			
//		}.start();
//		
	}
}