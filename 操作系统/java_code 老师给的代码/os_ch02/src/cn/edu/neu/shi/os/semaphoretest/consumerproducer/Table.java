package cn.edu.neu.shi.os.semaphoretest.consumerproducer;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Table {
	ArrayList<Dish> al;
	final int SIZE=5;
	public Semaphore mutex=new Semaphore(1); //initialized to 1, used to ensure mutual exclusion when the variable readcount is  updated.
	public Semaphore full=new Semaphore(0);
	public Semaphore empty=new Semaphore(5); 

	public Table() {
		al=new ArrayList<Dish>();
	}
	
	public void addDish(Dish d){
		try {
			empty.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			mutex.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		al.add(d);
		System.out.println(Thread.currentThread().getName()+"上菜："+al.size());	
	
		mutex.release();
		full.release();
		
	}
	
	public void getDish(){
		try {
			full.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+"吃菜："+al.size());
		al.remove(0);
		
		mutex.release();
		empty.release();
	}
	
}
