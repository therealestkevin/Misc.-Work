
public class Runnable1 implements Runnable {
	private int sum;
	public Runnable1(int sum){
		this.sum=sum;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
	}
	public int returnSum(int sum,int i) {
		
			sum+=i;
			System.out.println("Thread 1: "+sum);	
			return sum;
		
	
		
	}

}
