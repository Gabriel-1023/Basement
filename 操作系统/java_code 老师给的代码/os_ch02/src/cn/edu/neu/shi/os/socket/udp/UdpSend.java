package cn.edu.neu.shi.os.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpSend {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		DatagramSocket ds=new DatagramSocket();//准备socket,由于要使用udp,要使用DatagramSocket
		String s=new String("Hello world!");
		//准备包裹，包裹中的内容为一个字节数组:要注意放数组中的多少内容，跟以前的水瓢注意的事情一样。
		//写上收信人地址：包括IP地址和端口号。注意：127.0.0.1只是IP地址的字符串表示。需要使用InetAddress对象来表示IP地址。
		DatagramPacket dp=new DatagramPacket(s.getBytes(), 0, s.getBytes().length, InetAddress.getByName("127.0.0.1"), 3000);
		ds.send(dp);//发送信
		ds.close();//只要涉及到io,就要关。
	}

}
