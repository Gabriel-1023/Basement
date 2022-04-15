package cn.edu.neu.shi.os.socket.tcp;

import java.io.BufferedReader;
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
		Socket s=new Socket("127.0.0.1",3000);
		//“‡ø… π”√ new Socket("127.0.0.1",3000);
		InputStream is=s.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		String str=br.readLine();
		System.out.println(str);
		br.close();
		is.close();
		s.close();

	}

}
