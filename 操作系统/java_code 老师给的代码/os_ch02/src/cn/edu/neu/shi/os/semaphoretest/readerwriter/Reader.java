package cn.edu.neu.shi.os.semaphoretest.readerwriter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader implements Runnable {

	SharedData sharedData;
	
	public Reader(SharedData sharedData) {
		super();
		this.sharedData = sharedData;
	}

	public void read(){
		try {
			FileInputStream fis=new FileInputStream(sharedData.fileName);
			BufferedReader br=new BufferedReader(new InputStreamReader(fis));

			String s;
			try {
				while((s=br.readLine())!=null){
					System.out.println("Reader "+Thread.currentThread().getName()+": "+s);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fis.close();
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
				sharedData.mutex.acquire();
				sharedData.readcount++;
			    if (sharedData.readcount == 1)
			    	sharedData.wrt.acquire();
			    sharedData.mutex.release();
		     
			    // reading is performed
			    read();
			    
			    sharedData.mutex.acquire();
			    sharedData.readcount--;
			    if (sharedData.readcount == 0)
			    	sharedData.wrt.release();
			    sharedData.mutex.release();
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
