package Frame;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import com.server.Common;

public class Launch {

	public static Common user = new Common();
	
	public static void main(String args[]) throws IOException{
		
	//	LoginFrame loginframe=new LoginFrame();	
	//	run(new LoginFrame());
	//	Launch launcher=new Launch();
		Thread login = new Thread(new LoginFrame());
	//	run(new LoginFrame());
	
	}
    public static void
	  run(final JFrame f) {
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        f.setTitle(f.getClass().getSimpleName());
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setVisible(true);	  
	      }
	    });
	  }
}
