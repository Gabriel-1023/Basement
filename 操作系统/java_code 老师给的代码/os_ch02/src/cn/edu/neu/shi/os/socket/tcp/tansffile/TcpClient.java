package cn.edu.neu.shi.os.socket.tcp.tansffile;

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
		while((len=is.read(buf))>0){
			fos.write(buf, 0, len);
		}
		
		is.close();
		s.close();

	}

}
