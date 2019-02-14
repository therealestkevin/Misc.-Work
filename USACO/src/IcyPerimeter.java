/*
ID: kevinxu8099
LANG: JAVA
TASK: Icy Perimeter
*/

import java.io.*;
import java.util.*;
public class IcyPerimeter {
	public static int arr=0;;
	public static int peri=0;;
		public static void main (String[]args) throws IOException {
			BufferedReader rd = new BufferedReader(new FileReader("mixmilk.txt"));
			int status = Integer.parseInt(rd.readLine());
			int[][]data = new int[status][status];
			for(int i=0; i<status;i++) {
				char[] data2 = rd.readLine().toCharArray();
				
				for(int b=0;b<status;b++) {
					if(data2[b]=='#') {
						data[i][b]=1;
					}else if(data2[b]=='.') {
						data[i][b]=0;
					}
				}
			}
			
			System.out.println(Arrays.deepToString(data));
			System.out.println(Arrays.toString(findAnswer(data)));
		}
		
		public static int[] findAnswer(int[][]data) {
			int area=0;
			int perimeter=0;
			int irrelev=0;
			for(int i=0; i<data.length;i++) {
				for(int b=0;b<data[0].length;b++) {
					if(data[i][b]==1) {
						arr=0; peri=0;
						findBlob(i,b,data,irrelev++);
						
						if(arr>area) {
							area=arr;
							perimeter=peri;
						}else if(arr==area) {
							perimeter= Math.min(peri,perimeter);
						}
					}
				}
			}
			return new int[] {area,perimeter};
		}
		public static void findBlob(int i, int b, int[][]data,int scoop) {
			if(data[i][b]==1) {
				arr++;
				data[i][b]=scoop;
			}else {
				return;
			}
			if(i==0 || data[i-1][b]==0) {
				peri++;
			}if(i==data.length-1||data[i+1][b]==0) {
				peri++;
			}
			
			if(b==0 || data[i][b-1]==0) {
				peri++;
			}if(b==data.length-1||data[i][b+1]==0) {
				peri++;
			}
			
			if(i>0) {
				findBlob(i-1,b,data,scoop);
				
			}if(i<data.length-1) {
				findBlob(i+1,b,data,scoop);
			}
			if(b>0) {
				findBlob(i,b-1,data,scoop);
			}if(b<data.length-1) {
				findBlob(i,b+1,data,scoop);
			}
			
			
			
		}
}
