/**
 * 
 */
package cn.edu.sjtu.test;

/**
 * @author wenjuangong
 *
 */
import jpcap.JpcapCaptor;

public class LoopPacketThread extends Thread {
	 private JpcapCaptor jpcap = null;
	 private String ipAddr = "";

	 public LoopPacketThread(JpcapCaptor jpcap, String ipAddr) {
	  this.jpcap = jpcap;
	  this.ipAddr = ipAddr;
	 }

	 // -1��ʾ����ץ��
	 public void run() {
	  this.jpcap.loopPacket(-1, new ReceivePacket(this.ipAddr));
	 }
	}