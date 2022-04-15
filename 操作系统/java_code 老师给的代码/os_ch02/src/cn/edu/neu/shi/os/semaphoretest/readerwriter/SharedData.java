package cn.edu.neu.shi.os.semaphoretest.readerwriter;

import java.util.concurrent.Semaphore;

public class SharedData {
	public Semaphore mutex=new Semaphore(1); //initialized to 1, used to ensure mutual exclusion when the variable readcount is  updated.
	public Semaphore wrt=new Semaphore(1); //initialized to 1, common to both the reader and writer processes, used as a mutual exclusion semaphore for the writer.	
	public int readcount=0; //initialized to 0, keeps track of how many processes are reading the object.
	public String fileName="hello";
}
