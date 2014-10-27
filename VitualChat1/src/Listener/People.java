package Listener;

import java.util.ArrayList;



/*
Server


HashMap<String,People> people=new HashMap<...>;


for(int i=0;i<100;i++){

	People ptem = new People(id,pw);
	
	ptem.setip("111");
	
	people.put("name",ptem);
	
}
	for(i=0;i<10;i++){
	
		HashMap.get(zhouxiaojiang).friend.add("ddd");
		
		}
		
*/
	public class People{
		String id="",
				pw="";
		String ip="";
		
		
		int port;
		int judge=1;

		sbfriend[] sb=new sbfriend[10];
		ArrayList<People> friend =new ArrayList<People>();
		
		public People(String id,String pw) {
			// TODO Auto-generated constructor stub		
			this.id=id;
			this.pw=pw;
			for(int i=0;i<10;i++){
				
			sb[i]=new sbfriend("sb"+i, "10.21.12."+i, i+4000);		
			}
	
		}
			
		class sbfriend{
			
			String name="";
			String ip="";
			int port;
			public sbfriend(String name,String ip,int port) {
				// TODO Auto-generated constructor stub
				this.name=name;
				this.ip=ip;
				this.port=port;
			}
			
		}

		
		
		/*
		class sendfriend{
			String name="";
			String ip="";
			int port;
			
			void getinfo(People p1){
	
				this.name=p1.id;
				this.ip=p1.ip;
				this.port=p1.port;
			}
			
		}
		 */

		
		void addfriend(People p){
			friend.add(p);
		}
		
		void getIpandPort(String ip,int port){
			this.ip=ip;
			this.port=port;
		}		
	}


