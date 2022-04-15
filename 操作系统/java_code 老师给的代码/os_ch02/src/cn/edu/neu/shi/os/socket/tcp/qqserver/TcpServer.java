package cn.edu.neu.shi.os.socket.tcp.qqserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(3000);
		final Socket s=ss.accept();
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
		//pw.close();
		//os.close();
		//s.close();
		//ss.close();
	}

}
