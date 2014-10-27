
package com.server;

public class ServerMessage  implements java.io.Serializable{
       

	/**
	 *   type:   0.login failure.
	 *   		 1.login ok
	 *   		 2.want add a friend;
	 *   		 3.want chat with somebody;
	 *   		 
	 *   
	 *   
	 *   
	 *   
	 */

	private static final long serialVersionUID = 3040011122104093262L;
		private int type;
		
		private String userId;
		private String chatname;
		private int ChatPort;
		private String ip;
	
	
		
		
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		
		
		public String getChatName() {
			return chatname;
		}
		public void setChatName(String chatname) {
			this.chatname = chatname;
		}


		public void setType(int type){
			this.type=type;    	  
		}
		public int getType(){
			return type;
		}

		public int getChatPort() {
			return ChatPort;
		}
		public void setChatPort(int port) {
			this.ChatPort = port;
		}
		
		public String getIP() {
			return ip;
		}
		public void setIP(String ip) {
			this.ip = ip;
		}
		
		
		
		
		
		
		
		
		
		
		
}
