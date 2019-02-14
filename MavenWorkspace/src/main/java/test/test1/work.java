package test.test1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class work {
	public static void main(String[]args) throws FileNotFoundException {
		readAttendance();
	}
	public static void readAttendance() throws FileNotFoundException  {
		//Use Scanner to read the file and parse through each line of text
		Scanner sc = new Scanner(new File("sample.txt"));
		int counter=1;
		//counter is used to track which section the loop is in so that it can print which section it is on
		while(sc.hasNextLine()) {
			//while loop to handle different amounts of sections
			System.out.println("Section "+ counter);
			
			int [] points = new int[5];
			//int array to handle total points, length of 5 for 5 students
			String temp = sc.nextLine();
			char[]holder = temp.toCharArray();
			//making the string to char array to handle each letter in the line
			for(int a=0; a<(holder.length/5); a++) {
				//first for loop goes through each block of 5 letters in each line
				for(int b=0; b<5; b++) {
					//looping through each letter of the 5 letter block
					if(holder[(a*5)+b]=='y'&&points[b]<=17) {
						points[b]+=3;
						//checks if value is y and so that points don't exceed 20
					}else if(holder[(a*5)+b]=='n'&&points[b]<=18) {
						points[b]+=2;
						//checks if n and that points don't exceed 20
					}
				}
			}
			System.out.println("Student points: "+ Arrays.toString(points));
			double[]grades = new double[5];
			for(int c=0;c<grades.length;c++) {
				grades[c]=((double)points[c]/20.0)*100;
			}
			
			System.out.println("Student grades: "+ Arrays.toString(grades));
			//printing section of code, creates double array to handle each student's grade
			counter++;
		}
	}
}
