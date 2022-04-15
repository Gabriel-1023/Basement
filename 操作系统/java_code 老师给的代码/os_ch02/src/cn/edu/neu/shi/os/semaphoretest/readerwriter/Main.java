package cn.edu.neu.shi.os.semaphoretest.readerwriter;


public class Main {
	
	/**
	 * 
	 * ���㷨�������㷨��ע�⣺�����Ե��¼���
	 * 
	 */
	public static void main(String[] args) {
		SharedData sharedData=new SharedData();
		Reader reader=new Reader(sharedData);
		Writer writer=new Writer(sharedData);
		
		new Thread(writer).start();
		
		new Thread(reader).start();
		
		new Thread(writer).start();
		
		new Thread(reader).start();
		new Thread(reader).start();
		
		//new Thread(writer).start();
		//new Thread(writer).start();
		
		

	}

}
