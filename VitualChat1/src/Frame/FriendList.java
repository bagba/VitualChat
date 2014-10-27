package Frame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Constants.*;
import Listener.FriendListener;
public class FriendList extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton friend =new JButton("好友列表");
	JButton blacklist =new JButton("黑名单");
	JButton stranger = new JButton("陌生人");
	
	JButton friend1 =new JButton("好友列表");
	JButton blacklist1 =new JButton("黑名单");
	JButton stranger1 = new JButton("陌生人");
	
	JButton friend2 =new JButton("好友列表");
	JButton blacklist2 =new JButton("黑名单");
	JButton stranger2 = new JButton("陌生人");
	
	JPanel jp1_1=new JPanel();
	JPanel jp1_2=new JPanel();
	JPanel jp1_3=new JPanel();
	
	
	
	JPanel jp2=new JPanel();
	JPanel jp3=new JPanel();
	JPanel jp4=new JPanel();
	JPanel jp5=new JPanel();
	JPanel jp6=new JPanel();
	JPanel jp7=new JPanel();
	
	CardLayout c1;
	FriendListener fl=new FriendListener();
	
	public FriendList() {
		// TODO Auto-generated constructor stub
		Friendinfo fi=new Friendinfo();
		JLabel [] jlbfriend = new JLabel [fi.getNums()];
		ImageIcon[] imgs=new ImageIcon[fi.getNums()];
		

		
		friend.setPreferredSize(new Dimension(190,25));
		friend.setOpaque(false);
		friend.setBorder(null);
		friend.setBorderPainted(false);
		friend.setContentAreaFilled(false);
		friend.setFocusPainted(false);
		friend.setForeground(Color.GRAY);
		
		blacklist.setPreferredSize(new Dimension(190,25));
		blacklist.setOpaque(false);
		blacklist.setBorder(null);
		blacklist.setBorderPainted(false);
		blacklist.setContentAreaFilled(false);
		blacklist.setFocusPainted(false);
		blacklist.setForeground(Color.GRAY);
		
		stranger.setPreferredSize(new Dimension(190,25));
		stranger.setOpaque(false);
		stranger.setBorder(null);
		stranger.setBorderPainted(false);
		stranger.setContentAreaFilled(false);
		stranger.setFocusPainted(false);
		stranger.setForeground(Color.GRAY);
		jp1_1.add(friend);

		
		jp2.setLayout(new GridLayout(100,1,4,4));
		jp2.setOpaque(false);
		jp2.setBorder(null);
		
		
		
		for(int i=0;i<fi.getNums();i++){
			 imgs[i]=new ImageIcon("img/"+i+".jpg");
			 imgs[i]=new ImageIcon(imgs[i].getImage().getScaledInstance(40, 40, Image.SCALE_FAST));	
			 jlbfriend[i] =new JLabel(fi.getName(i),imgs[i],JLabel.LEFT);
			 jlbfriend[i].addMouseListener(fl);
			 jp2.add(jlbfriend[i]);
		}
		
		JScrollPane jsp= new JScrollPane(jp2);
				
		jsp.setPreferredSize(new Dimension(200,380));
		jsp.getViewport().setOpaque(false);
		jsp.setOpaque(false);
		jp1_1.add(jsp);
		
		jp3.add(blacklist);
		jp3.add(stranger);	
		jp3.setLayout(new GridLayout(2,1));
		jp3.setPreferredSize(new Dimension(200,30));
		jp3.setOpaque(false);
		
		
		jp1_1.add(jp3);
		jp1_1.setLayout(new FlowLayout());
		jp1_1.setOpaque(false);
		
		//dierzhang card
		friend1.setPreferredSize(new Dimension(190,25));
		friend1.setOpaque(false);
		friend1.setBorder(null);
		friend1.setBorderPainted(false);
		friend1.setContentAreaFilled(false);
		friend1.setFocusPainted(false);
		friend1.setForeground(Color.GRAY);
		
		blacklist1.setPreferredSize(new Dimension(190,25));
		blacklist1.setOpaque(false);
		blacklist1.setBorder(null);
		blacklist1.setBorderPainted(false);
		blacklist1.setContentAreaFilled(false);
		blacklist1.setFocusPainted(false);
		blacklist1.setForeground(Color.GRAY);
		
		stranger1.setPreferredSize(new Dimension(190,25));
		stranger1.setOpaque(false);
		stranger1.setBorder(null);
		stranger1.setBorderPainted(false);
		stranger1.setContentAreaFilled(false);
		stranger1.setFocusPainted(false);
		stranger1.setForeground(Color.GRAY);
		
		JLabel [] jlbblacklist = new JLabel [fi.getNums()];
		
		jp4.add(friend1);
		jp4.add(blacklist1);
		jp4.setLayout(new GridLayout(2,1));
		jp4.setPreferredSize(new Dimension(200,30));
		jp4.setOpaque(false);

		jp5.setLayout(new GridLayout(50,1,4,4));
		jp5.setOpaque(false);
		jp5.setBorder(null);

		
		//添加标签事件
		
		
		for(int i=0;i<fi.getNums();i++){
			 imgs[i]=new ImageIcon("img/"+i+".jpg");
			 imgs[i]=new ImageIcon(imgs[i].getImage().getScaledInstance(40, 40, Image.SCALE_FAST));	
			 jlbblacklist[i] =new JLabel(fi.getName(i),imgs[i],JLabel.LEFT);
			 jlbblacklist[i].addMouseListener(fl);
			 jp5.add(jlbblacklist[i]);
		}
		
		JScrollPane jsp1= new JScrollPane(jp5);
		jsp1.setPreferredSize(new Dimension(200,380));
		jsp1.getViewport().setOpaque(false);
		jsp1.setOpaque(false);
		
		jp1_2.add(jp4);
		jp1_2.add(jsp1);
		jp1_2.add(stranger1);
		jp1_2.setLayout(new FlowLayout());
		jp1_2.setOpaque(false);
		
		
		///第三张card
		friend2.setPreferredSize(new Dimension(190,25));
		friend2.setOpaque(false);
		friend2.setBorder(null);
		friend2.setBorderPainted(false);
		friend2.setContentAreaFilled(false);
		friend2.setFocusPainted(false);	
		friend2.setForeground(Color.GRAY);
		blacklist2.setPreferredSize(new Dimension(190,25));
		blacklist2.setOpaque(false);
		blacklist2.setBorder(null);
		blacklist2.setBorderPainted(false);
		blacklist2.setContentAreaFilled(false);
		blacklist2.setFocusPainted(false);
		blacklist2.setForeground(Color.GRAY);
		stranger2.setPreferredSize(new Dimension(190,25));
		stranger2.setOpaque(false);
		stranger2.setBorder(null);
		stranger2.setBorderPainted(false);
		stranger2.setContentAreaFilled(false);
		stranger2.setFocusPainted(false);
		stranger2.setForeground(Color.GRAY);
		JLabel [] jlbstranger = new JLabel [fi.getNums()];
		
		jp6.add(friend2);
		jp6.add(blacklist2);
		jp6.setLayout(new GridLayout(2,1));
		jp6.setPreferredSize(new Dimension(200,30));
		jp6.setOpaque(false);

		jp7.setLayout(new GridLayout(50,1,4,4));
		jp7.setOpaque(false);
		jp7.setBorder(null);

		for(int i=0;i<fi.getNums();i++){
			 imgs[i]=new ImageIcon("img/"+i+".jpg");
			 imgs[i]=new ImageIcon(imgs[i].getImage().getScaledInstance(40, 40, Image.SCALE_FAST));	
			 jlbstranger[i] =new JLabel(fi.getName(i),imgs[i],JLabel.LEFT);
			 jlbstranger[i].addMouseListener(fl);
			 jp7.add(jlbstranger[i]);
		}
		
		JScrollPane jsp2= new JScrollPane(jp7);
		jsp2.setPreferredSize(new Dimension(200,380));
		jsp2.getViewport().setOpaque(false);
		jsp2.setOpaque(false);
		
		jp1_3.add(jp6);
		jp1_3.add(stranger2);
		jp1_3.add(jsp2);
		jp1_3.setLayout(new FlowLayout());
		jp1_3.setOpaque(false);
		
		c1=new CardLayout();
		this.setLayout(c1);
		this.add(jp1_1,"1");
		this.add(jp1_2,"2");
		this.add(jp1_3,"3");
		
		friend.addActionListener(this);
		friend1.addActionListener(this);
		friend2.addActionListener(this);
		blacklist.addActionListener(this);
		blacklist1.addActionListener(this);
		blacklist2.addActionListener(this);
		stranger.addActionListener(this);
		stranger1.addActionListener(this);
		stranger2.addActionListener(this);
		
		this.setPreferredSize(new Dimension(200,380));
		this.setVisible(true);
		this.setOpaque(false);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==friend||e.getSource()==friend1||e.getSource()==friend2){
			c1.show(this, "1");
		}
		else if(e.getSource()==blacklist||e.getSource()==blacklist1||e.getSource()==blacklist2){
			c1.show(this, "2");
		}
		else if(e.getSource()==stranger||e.getSource()==stranger1||e.getSource()==stranger2){
			c1.show(this, "3");
		}
	}	

}
