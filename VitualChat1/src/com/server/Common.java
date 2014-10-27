package com.server;

import java.util.LinkedList;
import java.util.Queue;





public class Common implements java.io.Serializable  {
	 

	/**
	 *   type:   1.want chat with somebody;
	 *   		 2.want add a friend;
	 *   		 3...........
	 *   
	 *   
	 *   
	 *   
	 *   
	 */
	private static final long serialVersionUID = 7307084155603382779L;
	
	private String userId;
	private String passwd;
	private int type;
	private String ip;
	private int port;
	private String[] Friends;
	private Queue<Integer> chatport = new LinkedList<Integer>();
	private int csport;  //暂时只用一个！！！

	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getIP() {
		return ip;
	}
	public void setIP(String ip) {
		this.ip = ip;
	}
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public String[] getFriends() {
		return Friends;
	}
	public void setFriend(String[] friends) {
		this.Friends =friends;
	}
	public int getChatport() {
		
		return chatport.remove();
	}
	public void setChatport(int ports) {
		chatport.add(ports);
	}
	public int getCsport() {
		return csport;
	}
	public void setCSport(int ports) {
		this.csport=ports;
	}
	
	
	
	}


