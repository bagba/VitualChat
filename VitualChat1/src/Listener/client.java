package Listener;

import java.net.*;
import java.io.*;

import com.server.Common;





public class client {
	public static void main(String[] args) {
		new client();
	}
		public client(){				 	   	  
		    try {
			Socket s=new Socket("10.108.170.31",4726);			
			   ObjectOutputStream Oos=new ObjectOutputStream(s.getOutputStream());
				Common c=new Common();
				c.setPasswd("123");
				c.setUserId("123");
				Oos.writeObject(c);
			    ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			Common receive=(Common)ois.readObject();			 
			    System.out.println(receive.getPasswd()); 
			    s.close();
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	    } 
		
		
	    
   }
	
   
       

