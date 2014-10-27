package Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class ShowPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7187849753837162447L;

	JLabel theme =new JLabel("Perfect is Nothing!!!!Nothing is impossible!!!!",JLabel.LEFT);
	
	//选项卡：
	JTabbedPane jtp =new JTabbedPane();
	//有三个面板：
	JEditorPane editorPane = new JEditorPane(); 
	JScrollPane jsPane=new JScrollPane(editorPane);
	
	JPanel jp1= new JPanel();
	JPanel jp2= new JPanel();
	JPanel jp3= new JPanel();
	
	
	public ShowPanel() throws IOException {
		// TODO Auto-generated constructor stub
		//html button  
		
		Font fl=new Font("Times New Roman", Font.BOLD+Font.ITALIC, 25);
		theme.setForeground(Color.GRAY);
		theme.setFont(fl);
		

		
		 jsPane.setPreferredSize(new Dimension(800,380));
		 String path = "http://www.baidu.com";
		 editorPane.setEditable(false);     //请把editorPane设置为只读，不然显示就不整齐
		 editorPane.setPage(path);
		 editorPane.setPreferredSize(new Dimension(500,300));
		 
		
			jtp.add("新闻资讯 ",jsPane);
			jtp.add("热门话题",jp1);
			jtp.add("创建新话题",jp2);
			jtp.setForeground(Color.GRAY);
	
		
		
		this.setLayout(new FlowLayout());
		this.add(theme);
		this.setOpaque(false);
		this.add(jtp);
	}
	
	

}
