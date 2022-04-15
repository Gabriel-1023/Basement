package cn.edu.neu.shi.os.thread.introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintHello {

	/**
	 * @param args
	 */
	static boolean flag=true;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Thread(){

			@Override
			public void run() {
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				while(true){
					try {
						br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					flag=!flag;
				}
			}
			
		}.start();
		while(true){
			if(flag)
				System.out.println("Hello");
		}
	}	

}
