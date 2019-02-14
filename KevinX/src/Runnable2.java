
public class Runnable2 implements Runnable{
	private int sum;
	public Runnable2(int sum){
		this.sum=sum;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=10;i++) {
			sum+=i;
			System.out.println("Thread 1: "+sum);
		}
		
		
	}
}
