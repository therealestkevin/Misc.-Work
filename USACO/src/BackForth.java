/*
ID: kevinxu8099
LANG: JAVA
TASK: Back and Forth
*/

import java.io.*;
import java.util.*;

public class BackForth {
	
	 static ArrayList<Integer> bucket1;
	 static ArrayList<Integer> bucket2;
	public static void main(String[]args) throws IOException {
		bucket1 = new ArrayList<>();
		bucket2 = new ArrayList<>();
		BufferedReader rd = new BufferedReader(new FileReader("backforth.in"));
		StringTokenizer st = new StringTokenizer(rd.readLine());
		for(int i=0; i<10;i++) {
			bucket1.add(Integer.parseInt(st.nextToken()));
		}
		StringTokenizer st2 = new StringTokenizer(rd.readLine());
		for(int i=0;i<10;i++) {
			bucket2.add(Integer.parseInt(st2.nextToken()));
		}
	
		Set<Integer> uses = new HashSet<>();
		
		
		for(int i=0; i<10;i++) {
			for(int b=0; b<11;b++) {
				for(int c=0;c<10;c++) {
					for(int d=0;d<11;d++) {
						uses.add(calculate(i,b,c,d));
					}
				}
			}
		}
		PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("backforth.out")));
		out.print(uses.size());
		out.close();
		rd.close();
		System.exit(0);
	}
	
	public static int calculate(int i, int b, int c, int d) {
		int sum1=0;
		LinkedList<Integer> n1 = new LinkedList<>();
		LinkedList<Integer> n2 = new LinkedList<>();
		
			n1.addAll(bucket1);
			n2.addAll(bucket2);
		
		
		n2.add(n1.remove(i));
		n1.add(n2.remove(b));
		n2.add(n1.remove(c));
		n1.add(n2.remove(d));
		
		for(int z=0;z<n1.size();z++) {
			sum1+=n1.get(z);
		}
		
		
		
		
		return sum1;
	}
	
	
	
}
