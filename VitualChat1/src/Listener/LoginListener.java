package Listener;


import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;







import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.server.Common;

import Frame.Launch;
import Frame.MainFrame;

public class LoginListener implements MouseListener {

	private JTextField jtfUserName;
	private JPasswordField jpfPassword;
	private JButton login;
	private JButton logout;
	private JButton register;
	private int lport = 3738;
	private boolean state=false;

	
	public LoginListener(JTextField jtfUserName, JPasswordField jpfPassword,
			JButton login, JButton logout,JButton register ) {
		this.jtfUserName = jtfUserName;
		this.jpfPassword = jpfPassword;
		this.login = login;
		this.logout = logout;
		this.register=register;

	}

	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		if ( e.getSource() == login) {
			
			 try {
				 	System.out.println("trying to connect server!!!");
			//	 	Launch.cssocket =new Socket("127.0.0.1",Launch.lport);
					Socket loginSocket= new Socket("127.0.0.1",Launch.lport);
				//	ObjectOutputStream Oos=new ObjectOutputStream(Launch.cssocket.getOutputStream());
					ObjectOutputStream Oos=new ObjectOutputStream(loginSocket.getOutputStream());
					Common c=new Common();
					
					c.setPasswd(jpfPassword.getText());
					c.setUserId(jtfUserName.getText());
					
					Oos.writeObject(c);
		//			ObjectInputStream ois=new ObjectInputStream(Launch.cssocket.getInputStream());
					ObjectInputStream ois=new ObjectInputStream(loginSocket.getInputStream());
				
					c=(Common)ois.readObject();
					Launch.user = c;
					System.out.println(Launch.user.getIP());
					if(c.getType()==1){
						
						Thread MainFrame = new Thread(new MainFrame());
						MainFrame.start();
						
						state=true;
						
						Oos.close();
						ois.close();
					    }
					    else {
							JOptionPane.showMessageDialog(null, "用户名或密码错误！", "提示",
							JOptionPane.ERROR_MESSAGE);
					    	}
				} catch (UnknownHostException e1) {

					e1.printStackTrace();
				} catch (IOException e1) {

					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block

					e1.printStackTrace();
				}
			
				 
			////JSon
			
		
			
			
			
			
		} else if (e.getSource() == logout) {	
			
			 System.exit(0);
		}
		else if(e.getSource()==register){
			
			
		}
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		JButton jb1;
		if(e.getSource()==register){
			jb1 = (JButton)e.getSource();
		jb1.setIcon(new ImageIcon("img/register.png"));
		}
		else if(e.getSource()==login){
			jb1 = (JButton)e.getSource();
			jb1.setIcon(new ImageIcon("img/login.png"));
		}
		else if(e.getSource()==logout){
			jb1 = (JButton)e.getSource();
			jb1.setIcon(new ImageIcon("img/logout.png"));
		}
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		JButton jb1;
		if(e.getSource()==register){
			jb1 = (JButton)e.getSource();
		jb1.setIcon(new ImageIcon("img/registersmall.png"));
		}
		else if(e.getSource()==login){
			jb1 = (JButton)e.getSource();
			jb1.setIcon(new ImageIcon("img/loginsmall.png"));
		}
		else if(e.getSource()==logout){
			jb1 = (JButton)e.getSource();
			jb1.setIcon(new ImageIcon("img/logoutsmall.png"));
		}
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		JButton jb1;
		if(e.getSource()==register){
			jb1 = (JButton)e.getSource();
		jb1.setIcon(new ImageIcon("img/register.png"));
		}
		else if(e.getSource()==login){
			jb1 = (JButton)e.getSource();
			jb1.setIcon(new ImageIcon("img/login.png"));
		}
		else if(e.getSource()==logout){
			jb1 = (JButton)e.getSource();
			jb1.setIcon(new ImageIcon("img/logout.png"));
		}
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		JButton jb1;
		if(e.getSource()==register){
			jb1 = (JButton)e.getSource();
		jb1.setIcon(new ImageIcon("img/registersmall.png"));
		}
		else if(e.getSource()==login){
			jb1 = (JButton)e.getSource();
			jb1.setIcon(new ImageIcon("img/loginsmall.png"));
		}
		else if(e.getSource()==logout){
			jb1 = (JButton)e.getSource();
			jb1.setIcon(new ImageIcon("img/logoutsmall.png"));
		}
	}

	public boolean state(){
		
		return state;
		
	}
	
}
