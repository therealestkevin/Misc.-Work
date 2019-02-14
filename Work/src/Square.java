import java.util.*;
import java.io.*;
public class Square {
	public static void main (String[]args) throws  IOException {
	BufferedReader rd = new BufferedReader(new FileReader("mathematics.txt"));
	int lines = Integer.parseInt(rd.readLine());
	
		for(int i=0; i< lines; i++) {
			String temp =rd.readLine();
			char[]reverse = temp.toCharArray();
			for(int b=0; b<temp.length();b++) {
				if(b==0) {
					System.out.print(temp);
				}else if(b==temp.length()-1) {
					
					char[] reverseAnswer = new char[reverse.length];
					for(int c=reverse.length-1;c>=0;c--) {
						reverseAnswer[reverseAnswer.length-c-1]=reverse[c];
					}
					for(char e: reverseAnswer) {
						System.out.print(e);
					}
				}else {
					System.out.print(reverse[b]);
					for(int d=0; d<temp.length()-2;d++) {
						System.out.print(" ");
					}
					System.out.print(reverse[temp.length()-b]);
				}
				System.out.println();
			}
		}
	
	}
	
}
