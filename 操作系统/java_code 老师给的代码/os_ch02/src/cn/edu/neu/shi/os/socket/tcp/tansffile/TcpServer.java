package cn.edu.neu.shi.os.socket.tcp.tansffile;

import java.io.FileInputStream;
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
		FileInputStream fis=new FileInputStream("yp.jpg");
		byte[] buf=new byte[1024];
		Socket s=ss.accept();
		OutputStream os=s.getOutputStream();
		
		int len;
		while((len=fis.read(buf))>0){
			os.write(buf, 0, len);
		}
		
		os.close();
		s.close();
		
		fis.close();
		ss.close();
	}

}
