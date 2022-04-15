package cn.edu.neu.shi.os.monitor.consumerproducer;

import java.util.ArrayList;

public class Table {
	ArrayList<Dish> al;
	final int SIZE=5;

	public Table() {
		al=new ArrayList<Dish>();
	}
	
	public synchronized void addDish(Dish d){
		int n=al.size();
		if(n<SIZE){
			System.out.println(Thread.currentThread().getName()+"上菜!");
			al.add(d);
			notify();
		}else{
			System.out.println(Thread.currentThread().getName()+"没地方了！");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void getDish(){
		int n=al.size();
		if(n>0){
			System.out.println(Thread.currentThread().getName()+"吃菜");
			al.remove(0);
			notify();
		}else{
			System.out.println(Thread.currentThread().getName()+"没菜了:(");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
