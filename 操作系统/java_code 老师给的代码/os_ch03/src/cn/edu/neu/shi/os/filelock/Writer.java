package cn.edu.neu.shi.os.filelock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Writer {

	public static final boolean EXCLUSIVE = false;

	public static void main(String arsg[]) throws IOException { 
		
		FileLock exclusiveLock = null;
		try { 
			RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");
			// get the channel for the file
			FileChannel ch = raf.getChannel();
			// this locks the file - exclusive
			exclusiveLock = ch.lock(0, raf.length(), EXCLUSIVE);
			/** Now modify the data . . . */
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String s;
			do{
				System.out.println("Input sth, \"0\"to quit:");
				s=br.readLine();
				raf.writeBytes(s);
			}while(!s.equals("0"));
			
			// release the lock
			exclusiveLock.release();
			
		} catch (java.io.IOException ioe) { 
			System.err.println(ioe);
		}finally { 
			if (exclusiveLock != null)
				exclusiveLock.release();
		}
	}

}
