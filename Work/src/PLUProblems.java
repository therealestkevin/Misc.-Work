

public class PLUProblems {
	public static void main (String[]args) {
		System.out.println(noZero(199));
	}
	public static int noZero(int n) {
		boolean status=false;
		int currInt=1;
		while(status==false) {
			int temp = n+currInt;
			boolean isZero = false;
			while(temp>1) {
				if(temp%10==0) {
					isZero=true;
					temp=0;
				}else {
					temp/=10;
				}
			}
			if(isZero==false) {
				status=true;
				return n+currInt;
			}
			currInt++;
		}
		return 0;
	}
}
