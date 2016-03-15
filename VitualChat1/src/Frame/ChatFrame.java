package Frame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.TabableView;






import org.json.JSONException;
import org.json.JSONObject;
import org.omg.CORBA.portable.OutputStream;

import java.io.*;

///////////directly scp to chat each other!!!!!!!!!!!!!1

public class ChatFrame  extends JFrame implements Runnable,ActionListener{
	private int port;
	private String ip;
	String ChatName;
	
	JPanel head ;
	JPanel show ;
	JPanel write ;
	JScrollPane jspshow;
	JScrollPane jspwrite;
	ImageIcon User;
	JLabel headlb;
	
	JTextArea showta;
	JTextArea writeta;
	JTextField showname;
	JButton sendjb;
	DataOutputStream outmes;
	
		public ChatFrame(String chatname){//主动聊天
			try {
				
				outmes=new DataOutputStream(Launch.cssocket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.port= port;
			this.ChatName=chatname;
			this.setLayout(new BorderLayout());
			head=new JPanel();
			head.setSize(400, 100);
			User=new ImageIcon("img/user1.jpg");//User=new ImageIcon("img/chatname.jpg");
			Image user;
			user=User.getImage().getScaledInstance(80, 80, Image.SCALE_FAST);
			User =new ImageIcon(user);
			headlb=new JLabel(User);
			showname=new JTextField(chatname);
//			show=new JPanel();
//			show.setSize(400, 200);
			
			write=new JPanel();
			write.setSize(400, 200);
			
			jspshow=new JScrollPane(showta=new JTextArea(10,30));
			jspshow.setSize(500, 200);
			
			jspwrite=new JScrollPane(writeta=new JTextArea(7,20));
			jspwrite.setSize(400,200);
			
			head.add(headlb);
			head.add(showname);
			
	//		show.add(showta=new JTextArea(15,30));
			write.add(jspwrite);
//			write.add(writeta=new JTextArea(7,20));
			write.add(sendjb=new JButton("send"));
			
			sendjb.addActionListener(this);
			showta.disable();
			showta.setLineWrap(true);
			writeta.setLineWrap(true);
			this.addWindowListener(new WindowAdapter()
			 {
			 public void windowClosing(WindowEvent e)
			 {
				 
			 System.out.println("it works??");
			 Launch.chatManager.Remove(ChatName);
			 System.out.println(Launch.chatManager.Check(ChatName));
			 dispose();
			 }
			 });
			
			
			
			this.add(head,"North");
			this.add(jspshow,"Center");
			this.add(write,"South");
			this.setVisible(true);																						
			this.setLocationRelativeTo(null);				
			this.setSize(400, 500);
		}
		
	
		
		//////////////用来监听是否下线？？？？？？？？？？？？
@Override
public void run() {
	// TODO Auto-generated method stub
	
		}

 public	void showmes(String mes){
		showta.append(mes+"\n");
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {	

            JSONObject mes=new JSONObject();
            mes.put("type", "1");
            mes.put("chatname", ChatName);
            mes.put("content", writeta.getText());
			outmes.writeUTF(mes.toString());
			outmes.flush();
			String mymes ="我说:"+writeta.getText()+"\n";
			showta.append(mymes);
			writeta.setText("");			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}

