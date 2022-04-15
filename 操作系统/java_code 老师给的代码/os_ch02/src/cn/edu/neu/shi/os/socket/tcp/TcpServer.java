package cn.edu.neu.shi.os.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(3000);
		Socket s=ss.accept();
		//s.getInputStream();
		OutputStream os=s.getOutputStream();
		PrintWriter pw=new PrintWriter(os);
		pw.println("Hello world!¹þà¶°¡¡£");
		pw.close();
		os.close();
		s.close();
		ss.close();
	}

}
