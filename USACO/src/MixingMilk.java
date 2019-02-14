/*
ID: kevinxu8099
LANG: JAVA
TASK: Mixing Milk
*/

import java.io.*;
import java.util.*;
public class MixingMilk {
	
	public static void main (String[]args) throws IOException {
		BufferedReader rd = new BufferedReader(new FileReader("mixmilk.in"));
		int[][] data = new int[3][2];
		for(int i=0; i<3;i++) {
			StringTokenizer st = new StringTokenizer(rd.readLine());
			data[i][0]= Integer.parseInt(st.nextToken());
			data[i][1]= Integer.parseInt(st.nextToken());
		}
		
		
		for(int b=0; b<100; b++) {
			int turn = b%3;
			if(data[(turn+1)%3][0]<data[(turn+1)%3][1]+data[turn][1]) {
				data[turn][1]-=data[(turn+1)%3][0]-data[(turn+1)%3][1];
				data[(turn+1)%3][1]+=data[(turn+1)%3][0]-data[(turn+1)%3][1];
				
			}else if(data[(turn+1)%3][0]>=data[(turn+1)%3][1]+data[turn][1]) {
				data[(turn+1)%3][1]+=data[turn][1];
				data[turn][1]=0;
			}
		}
		
		PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("mixmilk.out")));
		for(int c=0; c<3;c++) {
			out.println(data[c][1]);
		}
		out.close();
		rd.close();
		//System.out.println(Arrays.deepToString(data));
		System.exit(0);
		
	}
	
}
