package cn.edu.neu.shi.os.socket.udp.loop;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpSend {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		DatagramSocket ds=new DatagramSocket();//׼��socket,����Ҫʹ��udp,Ҫʹ��DatagramSocket
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		//׼�������������е�����Ϊһ���ֽ�����:Ҫע��������еĶ������ݣ�����ǰ��ˮưע�������һ����
		//д�������˵�ַ������IP��ַ�Ͷ˿ںš�ע�⣺127.0.0.1ֻ��IP��ַ���ַ�����ʾ����Ҫʹ��InetAddress��������ʾIP��ַ��
		DatagramPacket dp=new DatagramPacket(s.getBytes(), 0, s.getBytes().length, InetAddress.getByName("192.168.1.100"), 3000);
		ds.send(dp);//������
		ds.close();//ֻҪ�漰��io,��Ҫ�ء�
	}

}
