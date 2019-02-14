import java.io.*;
import java.util.*;

public class mountain {
	public static void main (String[]args) throws NumberFormatException, IOException {
		 BufferedReader rd = new BufferedReader(new FileReader("mountains.in"));
			int status = Integer.parseInt(rd.readLine());
			ArrayList<int[]> data = new ArrayList<int[]>();
			for(int i=0; i<status;i++) {
				StringTokenizer st = new StringTokenizer(rd.readLine());
				int[]temp = new int[2];
				temp[0]=Integer.parseInt(st.nextToken());
				temp[1]=Integer.parseInt(st.nextToken());
				data.add(temp);
			}
			System.out.println(Arrays.toString(data.get(0)));
		;
			PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("mountains.out")));
			if(status==0) {
				out.println(0);
			}else if(status==1) {
				out.println(1);
			}else {
				out.println(returnMount(data));
			}
			
			out.close();
			rd.close();
	}
	public static int returnMount(ArrayList<int[]> data) {
		int current = data.size();
		for(int i=0; i<data.size();i++) {
			for(int b=0; b<data.size();b++) {
				if(b!=i) {
					if(isInside(data.get(b)[0]-data.get(b)[1],0,data.get(b)[0],data.get(b)[1],data.get(b)[0]+data.get(b)[1],0,
							data.get(i)[0],data.get(i)[1])) {
						current--;
					}
				}
			}
		}
		
		
		return current;
	}
	
	public static double area(int x1, int y1, int x2, int y2, int x3, int y3) { 
			return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0); 
}
	public static boolean isInside(int x1, int y1, int x2, 
            int y2, int x3, int y3, int x, int y) {    
  
    double A = area (x1, y1, x2, y2, x3, y3); 
   
  
    double A1 = area (x, y, x2, y2, x3, y3); 
   
   
    double A2 = area (x1, y1, x, y, x3, y3); 
   
     
    double A3 = area (x1, y1, x2, y2, x, y); 
     
   
    return (A == A1 + A2 + A3); 
} 
}
