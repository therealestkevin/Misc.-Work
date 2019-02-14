
public class SchoolWork {
	public static void main (String[]args) {
		int sum=0;
		Runnable r=new Runnable1(sum);
		Thread t1=new Thread(r);
		
		t1.start();
		
		sumto();
		
	}
	public static void sumto() {
		int sum=0;
		for(int i=1;i<=10;i++) {
			
			System.out.println(sum);
		}
	}
	

	
	
	
}
	


