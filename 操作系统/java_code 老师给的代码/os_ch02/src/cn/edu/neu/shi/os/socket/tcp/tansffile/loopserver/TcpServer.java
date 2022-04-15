package cn.edu.neu.shi.os.socket.tcp.tansffile.loopserver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws IOException 
	 */

	
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(3000);
		
		while(true){
			final Socket s=ss.accept();
			
			new Thread(new Runnable(){
				public void run() {
					byte[] buf=new byte[1024];
					System.out.println(s.getInetAddress()+"ทรฮสฮามหฃก");
					FileInputStream fis;
					try {
						fis = new FileInputStream("c:\\FullStack_MyEclipseEnterpriseWorkbenchInstaller_5.1.0GA_E3.2.1.exe");
						OutputStream os=s.getOutputStream();
						
						int len;
						while((len=fis.read(buf))>0){
							os.write(buf, 0, len);
						}
						
						os.close();
						s.close();
						fis.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}).start();
		}
		
		//ss.close();
	}

}
