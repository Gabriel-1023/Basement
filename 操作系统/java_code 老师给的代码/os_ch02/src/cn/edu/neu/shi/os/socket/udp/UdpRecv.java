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
		//���ŷ�����ָ���Լ���IP��ַ�Ͷ˿ںţ��粻ָ������Ϊ�����ͨ���������ֻ��һ��������ֻ��һ��ip��ַ����ͨ������ָ��IP��ַ��
		DatagramSocket ds=new DatagramSocket(3000);
		byte[] buf=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buf, buf.length);
		ds.receive(dp);
		String s=new String(dp.getData(), 0, dp.getLength());
		System.out.println(s);
		ds.close();
	}

}
