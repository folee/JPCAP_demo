/**
 * 
 */
package cn.edu.sjtu.FlowanAlyze;

import java.io.IOException;

import jpcap.JpcapWriter;
import jpcap.packet.Packet;
import jpcap.JpcapCaptor;

/**
 * @author wenjuangong
 *
 */
public class FenLiu {
	// ������������ӵ����ͬ��Զ������ݰ�����һ���ļ������һ����

	public void fenLiu(Packet p) throws IOException {
		
		JpcapCaptor captor=JpcapCaptor.openFile("./data/tcpudptest.pcap");
		int i=0;
		while(true){
			  Packet packet=captor.getPacket();

			if(packet==null || packet==Packet.EOF) break;
			  else if()
			  Writer wr=new Writer();
			  
			  
			  
			  
			}
		
	
			}
		
		

		captor.close();
	} 
}