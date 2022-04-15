package cn.edu.neu.shi.os.socket.tcp.talkmutithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


class Client extends Thread{
	Socket s;
	HashSet<Client> al;
	InputStream is;
	OutputStream os;
	PrintWriter pw;
	BufferedReader br;
	
	Client(Socket s, HashSet<Client> al){
		this.s=s;
		this.al=al;
		InputStream is;
		try {
			is = s.getInputStream();
			os=s.getOutputStream();
			pw=new PrintWriter(os);
			br=new BufferedReader(new InputStreamReader(is));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			al.remove(this);
		}
		
	}
	public void run(){
		al.add(this);
	
		while(true){
			try {
				String str=br.readLine();
				for(Client client: al){
					
					client.pw.println(s.getInetAddress()+":"+str);
					client.pw.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				al.remove(this);
			}
		}
		
		
		
	}
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((s == null) ? 0 : s.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Client other = (Client) obj;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}
}

public class TcpServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(3000);
		HashSet<Client> al=new HashSet<Client>();
		while(true){
			Socket s=ss.accept();
			new Client(s,al).start();
			
		}
	
	}

}
