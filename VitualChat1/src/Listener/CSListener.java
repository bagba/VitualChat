package Listener;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

import Frame.ChatFrame;

import com.server.ServerMessage;

public class CSListener implements Runnable{


	/**
	 *   type:   1.want chat with somebody;
	 *   		 2.want add a friend;
	 *   		 3.update
	 *   
	 *   
	 *   
	 *   
	 *   
	 */

	private int csport ;
	private String myip;
	
	public CSListener(int csport,String myip) {
		// TODO Auto-generated constructor stub
		this.csport=csport;
		this.myip=myip;
		
	}
	
	
	
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			DatagramSocket udps = new DatagramSocket(csport);
			
			while(true){
				byte[] by=new byte[1024*1024];
					
				DatagramPacket data=new DatagramPacket(by,by.length);
				ServerMessage receiver = new ServerMessage();
				
				udps.receive(data);
				
				ByteArrayInputStream bs=new ByteArrayInputStream(data.getData());
	            ObjectInputStream bo=new ObjectInputStream(bs);
       
	            receiver = (ServerMessage)bo.readObject();
	            switch (receiver.getType()) {
				case 1:
					Thread chat = new Thread(new ChatFrame());
					chat.start();
					udps.close();
					
					break;
				case 2:
					
					break;

				}

	            udps.close();
				
				
				
				
				System.out.println("dd000000000000000000000000000000000000000000000000");
				Thread.yield();
			}
			
			
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
	
	
	
	
	
	

}
