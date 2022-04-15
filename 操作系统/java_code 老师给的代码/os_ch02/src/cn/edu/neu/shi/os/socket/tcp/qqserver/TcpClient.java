package cn.edu.neu.shi.os.socket.tcp.qqserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		final Socket s=new Socket(InetAddress.getByName("127.0.0.1"),3000);
		InputStream is=s.getInputStream();
		OutputStream os=s.getOutputStream();
		final PrintWriter pw=new PrintWriter(os);
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		final Scanner sc=new Scanner(System.in);
		new Thread(new Runnable(){

			public void run() {
				while(true){
					String str=sc.next();
					pw.println(str);
					pw.flush();
				}
				
			}
			
		}).start();
		
		
		while(true){
			System.out.println(br.readLine());
		}

	}

}
