package cn.edu.neu.shi.os.socket.tcp.tansffile.loopserver;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s=new Socket(InetAddress.getByName("127.0.0.1"),3000);
		InputStream is=s.getInputStream();
		FileOutputStream fos=new FileOutputStream("haha.jpg");

		byte[] buf=new byte[1024];
		int len;
		int dot=0;
		System.out.println("正在传输中：");
		while((len=is.read(buf))>0){
			if(dot>10000){
				System.out.print(".");
				dot=0;
			}
			dot++;
			fos.write(buf, 0, len);
		}
		
		is.close();
		s.close();

	}

}
