package Listener;

import java.awt.Color;
import java.awt.event.MouseListener;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JLabel;

import Frame.ChatFrame;
import Frame.Launch;



import Frame.MainFrame;

import com.server.ServerMessage;


public class FriendListener implements MouseListener{

	


	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==2){
			String name=((JLabel)e.getSource()).getText();
//			ServerMessage send =new ServerMessage();
//			int chatport;
//			if(Launch.chatManager.getChat(name)==null)
			if(Launch.chatManager.Check(name)){
				ChatFrame chatFrame=new ChatFrame(name);
				Thread chat = new Thread(chatFrame);
				chat.start();
				Launch.chatManager.AddChat(chatFrame, name);
				System.out.println("sent ask for chat to server!!");
				System.out.println(Launch.user.getChatport());
				System.out.print(name);						
			}
			else {
				System.out.println("you already open one!£¡£¡");
				
			}

			
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

	
	private int SendGreet(String name)  {
		
		int port=Launch.user.getChatport();
  			 
		try {
			
			ObjectOutputStream out=new ObjectOutputStream(Launch.cssocket.getOutputStream());
			
			ServerMessage sm = new ServerMessage();
		
			sm.setChatName(name);
			sm.setIP(Launch.user.getIP());
			sm.setType(2);
			sm.setUserId(Launch.user.getUserId());
			
			sm.setChatPort(port);
			out.writeObject(sm);
			System.out.println("sendGreet over!!!");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return port;
		
		
	}
	
}
