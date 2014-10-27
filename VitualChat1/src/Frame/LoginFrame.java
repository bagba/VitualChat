package Frame;

import java.awt.*;
import javax.swing.*;

import Listener.LoginListener;

public class LoginFrame extends JFrame implements Runnable {
		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7858987515546908196L;

	ImageIcon bg=new ImageIcon("img/loginbg.jpg");
//	ImageIcon welcome=new ImageIcon("img/welcome.img");
	
	JLabel jlb1=new JLabel(bg);
	JLabel jlb2=new JLabel(" VisulChat",JLabel.CENTER);
	JLabel jlb3=new JLabel("用户名  ");
	JLabel jlb4=new JLabel(" 密码   ");
	
	JTextField jt1=new JTextField(20);
//	JTextField jt2=new JTextField(20);
	JPasswordField jt2 =new JPasswordField(20);
	
	JButton login = new JButton();
	JButton logout = new JButton();
	JButton register = new JButton();
	LoginListener loginListener = null;
	
	 LoginFrame(){
		
		this.getLayeredPane().add(jlb1,new Integer(Integer.MIN_VALUE));
		jlb1.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
		JPanel jp1=(JPanel)this.getContentPane();
		jp1.setOpaque(false);	
		
		this.setLayout(new GridLayout(3,1));
		
		Font f= new Font("黑体",Font.ITALIC,50);
		Font f1= new Font("黑体",Font.ITALIC,20);
		Font f2= new Font("黑体",Font.ITALIC,20);
		
		jt1.setForeground(Color.RED);
		jt1.setOpaque(false);
		jt2.setForeground(Color.RED);
		jt2.setOpaque(false);
		
		
		jlb2.setFont(f);
		jlb2.setForeground(Color.BLUE);
		jlb3.setFont(f1);
		jlb3.setForeground(Color.BLUE);
		jlb4.setFont(f2);
		jlb4.setForeground(Color.BLUE);
		
		
		JPanel jp2=new JPanel(); //上部分面板


		jp2.setOpaque(false);
//		jp2.add(jlb2);
		jp2.add(jlb3);
		jp2.add(jt1);
		jp2.add(jlb4);
		jp2.add(jt2);
		
		//下部分面板
		Dimension preferredSize = new Dimension(65,65);//
		
		JPanel jp3=new JPanel();
		jp3.setOpaque(false);
		
		login.setPreferredSize(preferredSize);
		logout.setPreferredSize(preferredSize);
		register.setPreferredSize(preferredSize);
		
		login.setMargin(new Insets(0, 0, 0, 0));// 
		logout.setMargin(new Insets(0, 0, 0, 0));
		register.setMargin(new Insets(0, 0, 0, 0));
		login.setContentAreaFilled(false);// 不绘制按钮区
		logout.setContentAreaFilled(false);
		register.setContentAreaFilled(false);
		
		login.setBorderPainted(false);// 设置不绘制按钮的边框
		logout.setBorderPainted(false);
		register.setBorderPainted(false);
		

		login.setIcon(new ImageIcon("img/loginsmall.png"));
		logout.setIcon(new ImageIcon("img/logoutsmall.png"));
		register.setIcon(new ImageIcon("img/registersmall.png"));
		
		jp3.add(login);
		jp3.add(logout);
		jp3.add(register);
		
		//添加事件
		
		 loginListener = new LoginListener(jt1,
				jt2, login, logout,register);
		jt1.addMouseListener(loginListener);
		jt2.addMouseListener(loginListener);
		login.addMouseListener(loginListener);
		logout.addMouseListener(loginListener);
		register.addMouseListener(loginListener);
		
		this.add(jlb2);
		this.add(jp2);
		this.add(jp3);
		this.setVisible(true);
		this.setSize(bg.getIconWidth(),bg.getIconHeight());
		this.setTitle("Visual Chat!");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		while(true){
		if(loginListener.state()){
			this.dispose();
			
		}
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
