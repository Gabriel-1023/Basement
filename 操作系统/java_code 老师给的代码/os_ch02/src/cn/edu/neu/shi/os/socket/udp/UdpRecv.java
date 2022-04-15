package cn.edu.neu.shi.os.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpRecv {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//收信方必须指明自己的IP地址和端口号，如不指定，则都为随机。通常如果本机只有一块网卡既只有一个ip地址，则通常都不指定IP地址。
		DatagramSocket ds=new DatagramSocket(3000);
		byte[] buf=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buf, buf.length);
		ds.receive(dp);
		String s=new String(dp.getData(), 0, dp.getLength());
		System.out.println(s);
		ds.close();
	}

}
