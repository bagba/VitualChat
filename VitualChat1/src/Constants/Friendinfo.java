package Constants;

public class Friendinfo {

	 int nums=10;
	 String[] names=new String[nums];
	 
	 
	  public Friendinfo() {
		// TODO Auto-generated constructor stub
		 for(int i=0;i<nums;i++){
			 names[i]="kid"+i;
		 }
	}
	 public int getNums(){
		 return nums;
	 }
	public String getName(int i){
		return names[i];
	}
	
	
}
