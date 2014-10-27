package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.server.Common;

import Listener.CSListener;
import Listener.MainButtonListener;

public class MainFrame extends JFrame implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	//bg
	ImageIcon backgroud=new ImageIcon("img/mainbg.jpg");
	
	//第一行：
	ImageIcon User1=new ImageIcon("img/user1.jpg");
	
	ImageIcon main1=new ImageIcon("img/search_small.png");
	ImageIcon main2=new ImageIcon("img/info_small.png");
	ImageIcon main3=new ImageIcon("img/startchat_small.png");
	ImageIcon main4=new ImageIcon("img/set_small.png");
	ImageIcon main5=new ImageIcon("img/exit_small.png");
	
	JLabel UserImg;
	JLabel jlbbg=new JLabel(backgroud);
	JLabel slogan=new JLabel(Launch.user.getUserId()+Launch.user.getIP());
	
	JButton search = new JButton();
	JButton info = new JButton();
	JButton  startchat= new JButton();
	JButton systemset = new JButton();
	JButton logout = new JButton();
	
	///第二行：JPanel1 + JPanel2+JPanel3
	
	JPanel jp1=new JPanel(new FlowLayout(FlowLayout.LEFT,20,10));
	JPanel jp2=new JPanel();
	JPanel jp3=new JPanel(new FlowLayout(FlowLayout.RIGHT,100,20));

	MainButtonListener mbl=new MainButtonListener(search,info,startchat,systemset,logout);
	
	public MainFrame() throws IOException {
		// TODO Auto-generated constructor stub
		//layout 必须放在一开始！！
		this.setLayout(new BorderLayout(5,5));
		
		Dimension pSizeUser = new Dimension(80,80);
		Dimension pSizeset = new Dimension(800,200);//
		Font f1= new Font("黑体",Font.ITALIC,30);
		slogan.setFont(f1);
		slogan.setForeground(Color.CYAN);
		this.getLayeredPane().add(jlbbg,new Integer(Integer.MIN_VALUE));
		jlbbg.setBounds(0, 0, backgroud.getIconWidth(), backgroud.getIconHeight());
		JPanel jp=(JPanel)this.getContentPane();
		jp.setOpaque(false);	
		
		
		Image user1;
		user1=User1.getImage().getScaledInstance(80, 80, Image.SCALE_FAST);
		User1 =new ImageIcon(user1);
		
		UserImg=new JLabel(User1);
		UserImg.setPreferredSize(pSizeUser);
		UserImg.setLayout(new BorderLayout());
		
		
		search.setIcon(main1);
		search.setMargin(new Insets(0, 0, 0, 0));
		search.setContentAreaFilled(false);
		search.setBorderPainted(false);
		search.setPreferredSize(pSizeUser);
		search.setFocusable(false);
		search.addMouseListener(mbl);
		
		info.setIcon(main2);		
		info.setMargin(new Insets(0, 0, 0, 0));
		info.setContentAreaFilled(false);
		info.setBorderPainted(false);
		info.setPreferredSize(pSizeUser);
		info.setFocusable(false);
		info.addMouseListener(mbl);
		
		startchat.setIcon(main3);
		startchat.setMargin(new Insets(0, 0, 0, 0));
		startchat.setContentAreaFilled(false);
		startchat.setBorderPainted(false);
		startchat.setPreferredSize(pSizeUser);
		startchat.setFocusable(false);
		startchat.addMouseListener(mbl);
		
		systemset.setIcon(main4);
		systemset.setMargin(new Insets(0, 0, 0, 0));
		systemset.setContentAreaFilled(false);
		systemset.setBorderPainted(false);
		systemset.setPreferredSize(pSizeUser);
		systemset.setFocusable(false);
		systemset.addMouseListener(mbl);
		
		logout.setIcon(main5);
		logout.setMargin(new Insets(0, 0, 0, 0));
		logout.setContentAreaFilled(false);
		logout.setBorderPainted(false);
		logout.setPreferredSize(pSizeUser);
		logout.setFocusable(false);
		logout.addMouseListener(mbl);
		
		jp1.setPreferredSize(pSizeset);
		jp1.add(UserImg);
		jp1.add(slogan);
		jp1.add(jp3);
		jp3.add(search);
		jp3.add(info);
		jp3.add(startchat);
		jp3.add(systemset);
		jp3.add(logout);
		
		jp1.setOpaque(false);
		jp2.setOpaque(false);
		jp3.setOpaque(false);
		
		FriendList fList=new FriendList();
		//set maiframe:
		add("North",jp1);
	//	jp2.add(logout);
		add("West",fList);
	//	add(jp3);
		
	//添加show frame
		ShowPanel sf=new ShowPanel();
		this.add("Center",sf);
		///south
		JLabel copyright=new JLabel("Visual Chat  1.0",JLabel.CENTER);
		this.add("South",copyright);
		
		RankList rl = new RankList();
		this.add("East",rl);
		///label copyright
		//main Frame 总体设置
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setIconImage(User1.getImage());
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Thread cslistener = new Thread(new CSListener(Launch.user.getCsport(),Launch.user.getIP()));
		cslistener.start();
			
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}






