/**
 * 
 */
package cn.edu.sjtu.test;

/**
 * @author wenjuangong
 *
 */

import java.io.IOException;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterface; 

public class TrafficStatictics {

	/**
	 * @param args
	 */
	
	private static TrafficStatictics ts;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // ����ͳ���߳�
		  TrafficStatictics.ins();
	}
	 public synchronized static TrafficStatictics ins() {
		  if (null == ts) {
		   TrafficStatictics ts = new TrafficStatictics();
		   ts.init();
		  }
		  return ts;
		 }

		 
		 public void init() {

		  // ��ȡ�����ϵ�����ӿڶ���
		  final NetworkInterface[] devices = JpcapCaptor.getDeviceList();

		  for (int i = 0; i < devices.length; i++) {
		   NetworkInterface ni = devices[i];

		   // ������ʱΪ��Ч��ַ����ץ������ַ
		   if (ni.addresses.length > 0) {

		    // һ�����������ж����ַ��ֻ��ȡ��һ��
		    String addr = ni.addresses[0].address.toString();

		    try {
		     // ���������ϵ�ץȡ����
		     JpcapCaptor jpcap = JpcapCaptor.openDevice(ni, 2000, true,
		       20);

		     // ������Ӧ��ץȡ�̲߳�����
		     LoopPacketThread lpt = new LoopPacketThread(jpcap, addr);
		     lpt.start();
		     System.out.println(addr + "�ϵĲɼ��߳�������������");

		    } catch (IOException e) {
		     e.printStackTrace();
		     System.out.println("ץȡ���ݰ�ʱ�����쳣!!!");
		    }

		   }
		  }

		 }

		}

