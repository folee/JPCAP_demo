/**
 * 
 */
package cn.edu.sjtu.FeatureExtract;

import java.io.IOException;

import javax.print.attribute.standard.MediaName;

import jpcap.JpcapCaptor;
import jpcap.packet.Packet;

/**
 * @author wenjuangong
 *
 */
public class GeneralFeatures {


	
	public static void main(String[] args) throws IOException {
		JpcapCaptor captor=JpcapCaptor.openFile("./data/tcpudptest.pcap");
	
		int packetcount = 0;
		int PacketLength=0;
		int s=2147483647;
//		int���͵����ֵ
		int l=0;
		double average=0;

		while(true){
			  Packet packet=captor.getPacket();
			  if(packet==null || packet==Packet.EOF) break;
			  if(packet instanceof jpcap.packet.TCPPacket||packet instanceof jpcap.packet.UDPPacket){
			  packetcount++;
			  PacketLength += packet.len;
//	 ��СIP����	
			  int i=packet.len;
			  if(i<s)
				  s=i;
//   ���IP����
			  if(i>l)
				 l=i;
			  }
		}
//		 IP������ƽ��ֵ
		  average=(double)PacketLength/packetcount;
//       IP��������λ��
		  Median m=new Median();

		  
		System.out.println("��СIP����Ϊ: "+s);
		System.out.println("���IP����Ϊ: "+l);
		System.out.println("IP������ƽ��ֵΪ: "+average);
		System.out.println("IP��������λ��Ϊ: "+m.median());
		
		captor.close();
	}
}