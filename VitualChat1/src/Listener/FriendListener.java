package Listener;

import java.awt.Color;
import java.awt.event.MouseListener;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import javax.swing.JLabel;

import Frame.ChatFrame;
import Frame.Launch;



import com.server.ServerMessage;


public class FriendListener implements MouseListener{


	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==2){
			String name=((JLabel)e.getSource()).getText();
			ServerMessage send =new ServerMessage();
			try {
				int port;
				if((port=SendGreet(name))>0){
					
				Thread chat = new Thread(new ChatFrame(port,Launch.user.getIP()));
				chat.start();
				System.out.print("sent ask for chat to server!!");
					
				}
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			
			System.out.print(name);
			
		}
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jb1;
		jb1 = (JLabel)e.getSource();
		jb1.setForeground(Color.CYAN);	
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jb1;
		jb1 = (JLabel)e.getSource();
		jb1.setForeground(Color.BLACK);	
	}

	
	private int SendGreet(String name) throws UnknownHostException {
		// TODO Auto-generated method stub
		
		int chatport=0;
		try {
			String ip = Launch.user.getIP();
		
			int sendport = Launch.user.getCsport();
			 chatport = Launch.user.getChatport();
			
			DatagramSocket udps = new DatagramSocket();	
			ServerMessage sender = new ServerMessage();
			byte[] by=new byte[1024*1024];
			
			sender.setIP(ip);
			sender.setType(1);
			sender.setChatPort(chatport);
			sender.setUserId(Launch.user.getUserId());
			sender.setChatName(name);
			
			ByteArrayOutputStream bs=new ByteArrayOutputStream();
            ObjectOutputStream bo=new ObjectOutputStream(bs);
            bo.writeObject(sender);
            by=bs.toByteArray();
            DatagramPacket data=new DatagramPacket(by,by.length,new InetSocketAddress("127.0.0.1", 2555) );
            udps.send(data);
            udps.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chatport;

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
