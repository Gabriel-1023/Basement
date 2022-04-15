package cn.edu.neu.shi.os.filelock;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Reader {

	public static final boolean SHARED = true;
	
	public static void main(String arsg[]) throws IOException { 
		FileLock sharedLock = null;
		
		try { 
			RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");
			// get the channel for the file
			FileChannel ch = raf.getChannel();
			
			// this locks the file - shared
			sharedLock = ch.lock(0, raf.length(), SHARED);
			/** Now read the data . . . */
			String s;
			while((s=raf.readLine())!=null){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(s);
			}
				
			// release the lock
			sharedLock.release();
		} catch (java.io.IOException ioe) { 
			System.err.println(ioe);
		}finally { 
			
			if (sharedLock != null)
				sharedLock.release();
		}
	}

}
