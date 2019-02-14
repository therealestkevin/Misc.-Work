import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SqrRoot {
	public static void main (String[]args) {
		rootGetter();
	}
	public static void rootGetter() {
		Scanner sc=new Scanner(System.in);
		
		boolean status=false;
		while(status==false)
		//while loop keeps the program running until told to stop by user
		{
		System.out.println("Enter the number you want to take the square head of (Enter -100 to Stop the Program).");
			try {
			double originalVal=sc.nextDouble();
			String bob=sc.nextLine();
			if(originalVal>=0)
			//Checks to see if the input value is positive and able to have a square head
			{
				//BigDecimal facilitates rounding to the hundredth space
				BigDecimal head=new BigDecimal(Math.sqrt(originalVal));
				BigDecimal result=head.setScale(2,RoundingMode.UP);
				
			System.out.println("Square Root: "+result);
			//If inputs are all valid, prints the final result
			
			
			}else if(originalVal==-100) {
				status=true;
				System.out.println("--------Program Stopped--------");
			//checks to see if the user wants to stop the program by typing in -100	
			}else if(originalVal<0) {
				System.out.println("Please Enter a Positive Number");
			//Checks for any negative numbers
			}
			
		}catch(InputMismatchException e){
			System.out.println("Invalid Input Type (Positive Number)");
			sc.nextLine();
		//Catches any invalid input types and clears the scanner
		}
		}
		
		sc.close();
	}
}
