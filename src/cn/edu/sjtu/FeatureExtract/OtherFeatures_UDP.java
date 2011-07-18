/**
 * 
 */
package cn.edu.sjtu.FeatureExtract;

import java.io.IOException;

import jpcap.JpcapCaptor;
import jpcap.packet.Packet;
import jpcap.packet.UDPPacket;

/**
 * @author wenjuangong
 *
 */
public class OtherFeatures_UDP {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JpcapCaptor captor=JpcapCaptor.openFile("./data/tcpudptest.pcap");
		Packet packet=captor.getPacket();
		if (packet instanceof jpcap.packet.UDPPacket) {

			UDPPacket udp = (UDPPacket) packet;

			System.out.println("UDPPacket");
			System.out.println("ԴIP��ַ��" + udp.src_ip);
			System.out.println("Ŀ��IP��ַ��" + udp.dst_ip);
			System.out.println("Դ�˿ںţ�" + udp.src_port );
			System.out.println("Ŀ�Ķ˿ںţ�" + udp.dst_port);			  
			System.out.println("Э�����ͣ�" + udp.protocol + "(TCP)");
		}
		captor.close();
	}
}
