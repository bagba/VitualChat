package Frame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.InputStream;
import java.net.Socket;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.omg.CORBA.portable.OutputStream;
import java.io.*;

public class ChatFrame implements KeyListener, ActionListener, WindowListener,Runnable {
	private int port;
	private String ip;
	JTextArea msg=new JTextArea();
	
	JTextField str_send=new JTextField(20);
	
	JTabbedPane jtp =new JTabbedPane();
	  Button send;
	  JPanel jp1= new JPanel();
		JPanel jp2= new JPanel();
		JPanel jp3= new JPanel();
		JPanel jp4=new JPanel();
		JPanel jp5=new JPanel();
		public ChatFrame(int port,String ip) {
			// TODO Auto-generated constructor stub
			this.port=port;
			this.ip=ip;
		}
		public ChatFrame(){
			
		}

public void display(){
	   jtp.add("开始语音通信",jp1);
	   jtp.add("开始视频通信",jp2);
	   jtp.add("传送文件",jp3);
	   jtp.add("创建讨论组",jp4);
	   jtp.add("应用",jp5);
	   JFrame f=new JFrame("对话框");
	   f.setSize(400, 350);
	   f.setLocation(400,400);
       f.setBackground(Color.red);	
       JPanel p1=new JPanel();
       f.add(p1,"South");
       f.add(jtp,"North");
       
       msg.setSize(50, 150);
       msg.setBackground(Color.white); 
       msg.setEditable(false);
       f.add(msg);
       JLabel label=new JLabel("发送信息",Label.LEFT);
       p1.add(label);
       
       p1.add(str_send);
       str_send.addKeyListener(this);
       send=new Button("发送信息");
       p1.add(send);
       send.addActionListener(this);
       Button exit=new Button("推出");
       p1.add(exit);
       exit.addActionListener(this);
       f.addWindowListener(this);
       f.setVisible(true);      
       
   }
 

  
public  void sendMessage() {
	// TODO Auto-generated method stub

		

	
	}



@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


public void windowActivated(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosed(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosing(WindowEvent arg0) {
	// TODO Auto-generated method stub
	System.out.println("聊天程序已关闭，再见");
	System.exit(0);
	
}

@Override
public void windowDeactivated(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeiconified(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowIconified(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowOpened(WindowEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void run() {
	// TODO Auto-generated method stub
	while(true){
		
		Socket socket;
		try{
			socket=new Socket(ip,port);
			InputStream in=socket.getInputStream();
			java.io.OutputStream out=socket.getOutputStream();	
			DataInputStream din=new DataInputStream(in);
			DataOutputStream dout=new DataOutputStream(out);
			
			while(true){
				dout.writeUTF(str_send.getText());	
				msg.append(din.readLine());			
			}
		     
		}catch(Exception e1){
			System.out.println("error"+e1);
	}
	}


		
		
	}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
} 
	
	
	
	
	
	
	
}



	// TODO Auto-generated method stub
	