package cn.edu.neu.shi.os.semaphoretest.readerwriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Writer implements Runnable{

	
	private SharedData sharedData;
	
	public Writer(SharedData shareData) {
		super();
		this.sharedData = shareData;
	}

	public void write(){
		try {
			FileOutputStream fos=new FileOutputStream(sharedData.fileName);
			PrintWriter pw=new PrintWriter(fos);
			Scanner sc=new Scanner(System.in);
			for(int i=0; i<5; i++){
				System.out.print("Writer "+Thread.currentThread().getName()+" input:");
				pw.println("Writer "+Thread.currentThread().getName()+sc.next());
				pw.flush();
			}
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			try {
				sharedData.wrt.acquire();
				//writing is performed
				write();
				sharedData.wrt.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			//以下是剩余区
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}      	
	}
}
